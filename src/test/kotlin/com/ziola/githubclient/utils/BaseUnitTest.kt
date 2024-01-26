package com.ziola.githubclient.utils

import com.ziola.githubclient.clients.GhClient
import com.ziola.githubclient.controllers.GhController
import com.ziola.githubclient.dto.ApiResponse
import com.ziola.githubclient.dto.GhRepository
import com.ziola.githubclient.dto.RepoBranch
import com.ziola.githubclient.models.ApiResponsesModel
import com.ziola.githubclient.models.GhRepositoryModel
import com.ziola.githubclient.models.RepoBranchModel
import com.ziola.githubclient.services.GhService
import com.ziola.githubclient.utils.UnitTestUtils.uni
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

abstract class BaseUnitTest {
    var ghClient = mockk<GhClient>()
    var ghService = mockk<GhService>()

    protected lateinit var apiResponse: ApiResponse
    protected lateinit var ghRepository: GhRepository
    protected lateinit var repoBranch: RepoBranch

    protected lateinit var ghControllerImpl: GhController
    protected lateinit var ghServiceImpl: GhService

    @BeforeEach
    fun mockResponses() {
        apiResponse = ApiResponsesModel.basic()
        ghRepository = GhRepositoryModel.basic()
        repoBranch = RepoBranchModel.basic()

        ghControllerImpl = GhController(ghService)
        ghServiceImpl = GhService(ghClient)

        every { ghClient.getBranches("tomaszziola", "githubclient") } returns uni(listOf(repoBranch))
        every { ghClient.getRepositories("tomaszziola") } returns uni(listOf(ghRepository))
        every { ghService.retrieveRepositoryDetails("tomaszziola") } returns uni(listOf(apiResponse))
    }
}
