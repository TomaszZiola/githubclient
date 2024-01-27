package com.ziola.githubclient.models

import com.ziola.githubclient.dto.Owner
import com.ziola.githubclient.dto.Repository

internal object RepositoryModel {
    fun basic(): Repository {
        return Repository(
            "githubclient",
            false,
            Owner("tomaszziola"),
        )
    }
}
