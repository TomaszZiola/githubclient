package com.ziola.githubclient.integration

import com.ziola.githubclient.utils.GhWireMockExtension
import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files.readAllBytes
import java.nio.file.Paths

@QuarkusTest
@QuarkusTestResource(GhWireMockExtension::class)
class GhControllerTest {
    @Test
    fun `WHEN making GET request with existing ID and all Headers SHOULD return BookingAssocList with two elements`() {
        val getResponse =
            Given {
                pathParam("username", "TomaszZiola")
            } When {
                get("/{username}")
            } Then {
                statusCode(200)
            } Extract {
                body().asString()
            }

        val expectedResult = String(readAllBytes(Paths.get("src/test/resources/fixture/GhResponse.json"))).trim()

        assertThat(getResponse).isEqualTo(expectedResult)
    }
}
