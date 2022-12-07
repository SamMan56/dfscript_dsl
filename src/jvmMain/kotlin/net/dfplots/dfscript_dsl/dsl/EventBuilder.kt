package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.ScriptMarker
import net.dfplots.dfscript_dsl.json.JsonAction
import net.dfplots.dfscript_dsl.json.JsonActionOrEvent
import net.dfplots.dfscript_dsl.json.JsonEvent

@ScriptMarker
data class EventBuilder (
    val name: String,
    var actions: List<JsonActionOrEvent> = listOf()
) {
    fun display_chat(vararg texts: Value<TextType>) {
        actions += JsonAction("DISPLAY_CHAT", texts.map { it.toSerializable() })
    }

    fun toSerializable(): List<JsonActionOrEvent> {
        // an event is really just an action - create a new list headed by this
        val allActions = listOf(JsonEvent(name)) + actions
        return allActions
    }
}