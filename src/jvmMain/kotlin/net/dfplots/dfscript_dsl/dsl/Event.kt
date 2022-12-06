package net.dfplots.dfscript_dsl.dsl

import kotlinx.serialization.Serializable
import net.dfplots.dfscript_dsl.ScriptMarker

@ScriptMarker
@Serializable
data class Event(
    val name: String,
    var actions: List<BaseAction> = listOf()
) {
    fun display_chat(vararg texts: String) {}
}