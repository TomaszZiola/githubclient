package com.ziola.githubclient.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Branch(val commit: Commit, val name: String)
