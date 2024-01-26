package com.ziola.githubclient.service

import com.ziola.githubclient.client.GhClient
import com.ziola.githubclient.dto.ApiResponses
import com.ziola.githubclient.dto.GhRepository
import com.ziola.githubclient.dto.RepoBranchCommit
import io.smallrye.mutiny.Uni
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class GhService(
    @RestClient private val client: GhClient,
) {
    fun retrieveRepositoryDetails(username: String): Uni<List<ApiResponses>> {
        return client.getGgRepositories(username)
            .map { ghRepo -> ghRepo.filter { it.fork.not() } }
            .flatMap { createResponse(username, it) }
    }

    private fun createResponse(
        username: String,
        repositories: List<GhRepository>,
    ): Uni<List<ApiResponses>> {
        val apiResponses =
            repositories.map { repository ->
                retrieveBranches(username, repository)
                    .map { branches -> ApiResponses(repository.name, repository.owner.login, branches) }
            }

        return Uni.combine().all().unis<RepoBranchCommit>(apiResponses)
            .with { responses -> responses.filterIsInstance<ApiResponses>() }
    }

    private fun retrieveBranches(
        username: String,
        repository: GhRepository,
    ): Uni<List<RepoBranchCommit>> {
        return client.getBranches(username, repository.name)
            .map { branch -> branch.map { RepoBranchCommit(it.name, it.commit.sha) } }
    }
}
