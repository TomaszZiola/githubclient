package com.ziola.githubclient.models

import com.ziola.githubclient.dto.GhRepository
import com.ziola.githubclient.dto.RepoOwner

internal object GhRepositoryModel {
    fun basic(): GhRepository {
        return GhRepository(
            "githubclient",
            false,
            RepoOwner("tomaszziola"),
        )
    }
}
