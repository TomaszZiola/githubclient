package com.ziola.githubclient.utils

import io.smallrye.mutiny.Uni
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber

object UnitTestUtils {
    fun <T> subscribe(uni: Uni<T>): T {
        return uni.subscribe()
            .withSubscriber(UniAssertSubscriber.create())
            .awaitItem()
            .item
    }

    fun <T> uni(source: T): Uni<T> {
        return Uni.createFrom().item(source)
    }
}
