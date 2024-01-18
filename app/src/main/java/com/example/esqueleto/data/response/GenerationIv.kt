package com.example.esqueleto.data.response

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamondpearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    val heartgoldsoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)