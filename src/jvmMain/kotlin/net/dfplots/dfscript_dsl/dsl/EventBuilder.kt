package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.ScriptMarker
import net.dfplots.dfscript_dsl.json.JsonActionOrEvent
import net.dfplots.dfscript_dsl.json.JsonEvent

@ScriptMarker
class EventBuilder (
    val name: String,
    var actions: List<JsonActionOrEvent> = listOf()
) {
    fun toSerializable(): List<JsonActionOrEvent> {
        // an event is really just an action - create a new list headed by this
        return listOf(JsonEvent(name)) + actions
    }
}