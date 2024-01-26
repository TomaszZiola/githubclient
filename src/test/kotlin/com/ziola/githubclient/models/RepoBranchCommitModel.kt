package com.ziola.githubclient.models

import com.ziola.githubclient.dto.RepoBranchCommit

internal object RepoBranchCommitModel {
    fun basic(): RepoBranchCommit {
        return RepoBranchCommit(
            "master",
            "abc678",
        )
    }
}
