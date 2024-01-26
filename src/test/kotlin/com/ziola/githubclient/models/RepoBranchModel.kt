package com.ziola.githubclient.models

import com.ziola.githubclient.dto.RepoBranch

internal object RepoBranchModel {
    fun basic(): RepoBranch {
        return RepoBranch(CommitModel.basic(), "master")
    }
}
