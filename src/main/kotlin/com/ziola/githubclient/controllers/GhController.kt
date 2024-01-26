package com.ziola.githubclient.controllers

import com.ziola.githubclient.dto.ApiResponse
import com.ziola.githubclient.services.GhService
import io.smallrye.mutiny.Uni
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/{username}")
class GhController(
    private val ghService: GhService,
) {
    @GET
    fun getApiResponses(username: String): Uni<List<ApiResponse>> {
        return ghService.retrieveRepositoryDetails(username)
    }
}
