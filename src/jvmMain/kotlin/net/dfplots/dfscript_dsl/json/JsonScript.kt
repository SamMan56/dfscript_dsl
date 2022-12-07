package net.dfplots.dfscript_dsl.json

import kotlinx.serialization.Serializable

@Serializable
data class JsonScript(
    var actions: List<JsonActionOrEvent>,
    val config: List<Int>,
    val description: String,
    val disabled: Boolean,
    val name: String,
    val owner: String,
    val server: String = "None",
    val version: Int = 4
)