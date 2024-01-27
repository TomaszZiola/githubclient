package com.ziola.githubclient.utils

import com.ziola.githubclient.clients.GhClient
import com.ziola.githubclient.controllers.GhController
import com.ziola.githubclient.dto.ApiResponse
import com.ziola.githubclient.dto.Branch
import com.ziola.githubclient.dto.Repository
import com.ziola.githubclient.models.ApiResponseModel
import com.ziola.githubclient.models.BranchModel
import com.ziola.githubclient.models.RepositoryModel
import com.ziola.githubclient.services.GhService
import com.ziola.githubclient.utils.UnitTestUtils.uni
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

abstract class BaseUnitTest {
    var ghClient = mockk<GhClient>()
    var ghService = mockk<GhService>()

    protected lateinit var apiResponse: ApiResponse
    protected lateinit var repository: Repository
    protected lateinit var branch: Branch

    protected lateinit var ghControllerImpl: GhController
    protected lateinit var ghServiceImpl: GhService

    @BeforeEach
    fun mockResponses() {
        apiResponse = ApiResponseModel.basic()
        repository = RepositoryModel.basic()
        branch = BranchModel.basic()

        ghControllerImpl = GhController(ghService)
        ghServiceImpl = GhService(ghClient)

        every { ghClient.getBranches("tomaszziola", "githubclient") } returns uni(listOf(branch))
        every { ghClient.getRepositories("tomaszziola") } returns uni(listOf(repository))
        every { ghService.retrieveRepositoryDetails("tomaszziola") } returns uni(listOf(apiResponse))
    }
}
