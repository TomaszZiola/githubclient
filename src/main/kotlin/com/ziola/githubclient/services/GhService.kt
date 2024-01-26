package com.ziola.githubclient.services

import com.ziola.githubclient.clients.GhClient
import com.ziola.githubclient.dto.ApiResponse
import com.ziola.githubclient.dto.GhRepository
import com.ziola.githubclient.dto.RepoBranchCommit
import io.smallrye.mutiny.Uni
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class GhService(
    @RestClient private val client: GhClient,
) {
    fun retrieveRepositoryDetails(username: String): Uni<List<ApiResponse>> {
        return client.getGgRepositories(username)
            .map { ghRepo -> ghRepo.filter { it.fork.not() } }
            .flatMap { createResponse(username, it) }
    }

    private fun createResponse(
        username: String,
        repositories: List<GhRepository>,
    ): Uni<List<ApiResponse>> {
        val apiResponse =
            repositories.map { repository ->
                retrieveBranches(username, repository)
                    .map { branches -> ApiResponse(repository.name, repository.owner.login, branches) }
            }

        return Uni.combine().all().unis<RepoBranchCommit>(apiResponse)
            .with { responses -> responses.filterIsInstance<ApiResponse>() }
    }

    private fun retrieveBranches(
        username: String,
        repository: GhRepository,
    ): Uni<List<RepoBranchCommit>> {
        return client.getBranches(username, repository.name)
            .map { branch -> branch.map { RepoBranchCommit(it.name, it.commit.sha) } }
    }
}
