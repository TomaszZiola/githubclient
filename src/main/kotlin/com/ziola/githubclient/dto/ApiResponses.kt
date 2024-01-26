package com.ziola.githubclient.dto

data class ApiResponses(val repositoryName: String, val ownerLogin: String, val branches: List<RepoBranchCommit>)
