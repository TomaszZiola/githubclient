package com.ziola.githubclient.models

import com.ziola.githubclient.dto.Branch

internal object BranchModel {
    fun basic(): Branch {
        return Branch(CommitModel.basic(), "master")
    }
}
