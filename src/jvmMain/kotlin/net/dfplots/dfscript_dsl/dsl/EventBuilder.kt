package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.ScriptMarker
import net.dfplots.dfscript_dsl.json.Action
import net.dfplots.dfscript_dsl.json.BaseAction
import net.dfplots.dfscript_dsl.json.Event

@ScriptMarker
data class EventBuilder (
    val name: String,
    var actions: List<BaseAction> = listOf()
) {
    fun display_chat(vararg texts: String) {
        actions += Action("DISPLAY_CHAT")
    }

    fun toSerializable(): Event {
        return Event(name, actions)
    }
}