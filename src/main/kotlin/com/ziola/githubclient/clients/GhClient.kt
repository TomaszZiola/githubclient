package com.ziola.githubclient.clients

import com.ziola.githubclient.dto.Branch
import com.ziola.githubclient.dto.Repository
import io.smallrye.mutiny.Uni
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@RegisterRestClient
interface GhClient {
    @GET
    @Path("users/{username}/repos")
    fun getRepositories(
        @PathParam("username") username: String,
    ): Uni<List<Repository>>

    @GET
    @Path("repos/{username}/{repoName}/branches")
    fun getBranches(
        @PathParam("username") username: String,
        @PathParam("repoName") repoName: String,
    ): Uni<List<Branch>>
}
