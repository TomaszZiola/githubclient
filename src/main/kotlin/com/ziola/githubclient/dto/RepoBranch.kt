package com.ziola.githubclient.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class RepoBranch(val commit: Commit, val name: String)
