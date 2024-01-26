package com.ziola.githubclient.models

import com.ziola.githubclient.dto.Commit

internal object CommitModel {
    fun basic(): Commit {
        return Commit("abc678")
    }
}
