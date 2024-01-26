package com.ziola.githubclient.controllers

import com.ziola.githubclient.utils.BaseUnitTest
import com.ziola.githubclient.utils.UnitTestUtils.subscribe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GhControllerTest : BaseUnitTest() {
    @Test
    fun `GhController#getApiResponses should return ApiResponses when subscribed`() {
        // when
        val result = subscribe(ghControllerImpl.getApiResponses("tomaszziola"))

        // then
        assertThat(result).isEqualTo(listOf(apiResponse))
    }
}
