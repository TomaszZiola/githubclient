package com.ziola.githubclient.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@Suppress("ConstructorParameterNaming")
@JsonIgnoreProperties(ignoreUnknown = true)
data class GhRepository(val name: String, val fork: Boolean, val owner: RepoOwner)
