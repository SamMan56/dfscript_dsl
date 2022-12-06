package net.dfplots.dfscript_dsl.json

import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val name: String,
    var actions: List<BaseAction> = listOf()
)