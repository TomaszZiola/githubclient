package com.ziola.githubclient.dto

data class ApiResponse(val repositoryName: String, val ownerLogin: String, val branches: List<Branch>)
