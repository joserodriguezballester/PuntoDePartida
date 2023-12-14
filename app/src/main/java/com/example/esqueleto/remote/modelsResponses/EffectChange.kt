package com.example.esqueleto.remote.modelsResponses

data class EffectChange(
    val effect_entries: List<EffectEntry>,
    val version_group: VersionGroup
)