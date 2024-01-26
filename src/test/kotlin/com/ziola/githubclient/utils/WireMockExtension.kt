package com.ziola.githubclient.utils

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager

internal abstract class WireMockExtension : QuarkusTestResourceLifecycleManager {
    companion object {
        var server: WireMockServer =
            WireMockServer(
                wireMockConfig()
                    .dynamicPort().dynamicHttpsPort(),
            )
    }

    override fun start(): MutableMap<String, String> {
        if (!server.isRunning) {
            server.start()
            WireMock.configureFor(server.port())
        }

        return mutableMapOf()
    }

    override fun stop() {
        if (server.isRunning) {
            server.stop()
        }
    }
}
