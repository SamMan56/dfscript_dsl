package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.ScriptMarker
import net.dfplots.dfscript_dsl.json.Action
import net.dfplots.dfscript_dsl.json.ActionOrEvent
import net.dfplots.dfscript_dsl.json.Event

@ScriptMarker
data class EventBuilder (
    val name: String,
    var actions: List<ActionOrEvent> = listOf()
) {
    fun display_chat(vararg texts: String) {
        actions += Action("DISPLAY_CHAT", listOf())
    }

    fun toSerializable(): List<ActionOrEvent> {
        // an event is really just an action - create a new list headed by this
        val allActions = listOf(Event(name)) + actions
        return allActions
    }
}