package com.example.esqueleto.data.modelsResponses

data class EffectChange(
    val effect_entries: List<EffectEntry>,
    val version_group: VersionGroup
)