package com.example.esqueleto.data.response

import com.google.gson.annotations.SerializedName

data class Other(
    val dream_world: DreamWorld,
    val home: Home,
    @SerializedName("official-artwork")
    val officialartwork: OfficialArtwork,
    val showdown: Showdown
)