package com.ziola.githubclient.models

import com.ziola.githubclient.dto.ApiResponse

object ApiResponsesModel {
    fun basic(): ApiResponse {
        return ApiResponse(
            "githubclient",
            "tomaszziola",
            listOf(RepoBranchCommitModel.basic()),
        )
    }
}
