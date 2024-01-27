package com.ziola.githubclient.models

import com.ziola.githubclient.dto.ApiResponse

object ApiResponseModel {
    fun basic(): ApiResponse {
        return ApiResponse(
            "githubclient",
            "tomaszziola",
            listOf(BranchModel.basic()),
        )
    }
}
