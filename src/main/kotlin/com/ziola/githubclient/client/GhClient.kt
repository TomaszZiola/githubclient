package com.ziola.githubclient.client

import com.ziola.githubclient.dto.GhRepository
import com.ziola.githubclient.dto.RepoBranch
import io.smallrye.mutiny.Uni
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@RegisterRestClient
interface GhClient {
    @GET
    @Path("users/{username}/repos")
    fun getGgRepositories(
        @PathParam("username") username: String,
    ): Uni<List<GhRepository>>

    @GET
    @Path("repos/{username}/{repoName}/branches")
    fun getBranches(
        @PathParam("username") username: String,
        @PathParam("repoName") repoName: String,
    ): Uni<List<RepoBranch>>
}