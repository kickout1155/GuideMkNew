package com.example.guidemknew.modelNetwork

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Heroes(
    @SerialName("UUID")
    val id: String,
    @SerialName("Name")
    val name: String,
    @SerialName("Capture")
    val urlImage: String
)