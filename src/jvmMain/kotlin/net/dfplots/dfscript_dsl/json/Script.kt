package net.dfplots.dfscript_dsl.json

import kotlinx.serialization.Serializable

@Serializable
data class Script(
    var actions: List<ActionOrEvent>,
    val config: List<Int>,
    val description: String,
    val disabled: Boolean,
    val name: String,
    val owner: String,
    val server: String = "None",
    val version: Int = 4
)