package com.ziola.githubclient.controllers

import com.ziola.githubclient.dto.ApiResponses
import com.ziola.githubclient.service.GhService
import io.smallrye.mutiny.Uni
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/{username}")
class GhController(
    private val ghService: GhService,
) {
    @GET
    fun getApiResponses(username: String): Uni<List<ApiResponses>> {
        return ghService.retrieveRepositoryDetails(username)
    }
}
