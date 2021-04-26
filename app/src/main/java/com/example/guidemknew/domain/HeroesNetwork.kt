package com.example.guidemknew.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeroesNetwork(
    @SerialName("UUID")
    val id: String,
    @SerialName("Name")
    val name: String,
    @SerialName("Capture")
    val urlImage: String
)