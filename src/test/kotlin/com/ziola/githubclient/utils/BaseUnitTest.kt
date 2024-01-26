package com.ziola.githubclient.utils

import com.ziola.githubclient.controllers.GhController
import com.ziola.githubclient.dto.ApiResponse
import com.ziola.githubclient.models.ApiResponsesModel
import com.ziola.githubclient.service.GhService
import com.ziola.githubclient.utils.UnitTestUtils.uni
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

abstract class BaseUnitTest {
    var ghService = mockk<GhService>()

    protected lateinit var apiResponse: ApiResponse

    protected lateinit var ghControllerImpl: GhController

    @BeforeEach
    fun mockResponses() {
        apiResponse = ApiResponsesModel.basic()

        ghControllerImpl = GhController(ghService)

        every { ghService.retrieveRepositoryDetails("tomaszziola") } returns uni(listOf(apiResponse))
    }
}
