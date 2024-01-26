package com.ziola.githubclient.services

import com.ziola.githubclient.utils.BaseUnitTest
import com.ziola.githubclient.utils.UnitTestUtils.subscribe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GhServiceTest : BaseUnitTest() {
    @Test
    fun `GhService#retrieveRepositoryDetails should return list of ApiResponse when subscribed`() {
        // when
        val result = subscribe(ghServiceImpl.retrieveRepositoryDetails("tomaszziola"))

        // then
        assertThat(result).isEqualTo(listOf(apiResponse))
    }
}
