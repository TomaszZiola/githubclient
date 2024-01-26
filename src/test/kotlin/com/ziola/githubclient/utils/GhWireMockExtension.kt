package com.ziola.githubclient.utils

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching
import java.nio.file.Files.readAllBytes
import java.nio.file.Paths

internal class GhWireMockExtension : WireMockExtension() {
    override fun start(): MutableMap<String, String> {
        val appProperties = super.start()

        stubFor(
            get(urlPathMatching("/users/TomaszZiola/repos"))
                .willReturn(okJson(fullResponse())),
        )
        stubFor(
            get(urlPathMatching("/repos/TomaszZiola/currency_exchanger_app/branches"))
                .willReturn(okJson(currencyExchanger())),
        )
        stubFor(
            get(urlPathMatching("/repos/TomaszZiola/githubrepochecker/branches"))
                .willReturn(okJson(githubrepochecker())),
        )
        appProperties["quarkus.rest-client.\"com.ziola.githubclient.clients.GhClient\".url"] = server.baseUrl()
        return appProperties
    }

    private fun githubrepochecker(): String {
        return String(readAllBytes(Paths.get("src/test/resources/fixture/Githubrepochecker.json")))
    }

    private fun currencyExchanger(): String {
        return String(readAllBytes(Paths.get("src/test/resources/fixture/CurrencyExchanger.json")))
    }

    private fun fullResponse(): String {
        return String(readAllBytes(Paths.get("src/test/resources/fixture/GhClientResponse.json")))
    }
}
