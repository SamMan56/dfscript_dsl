package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.ScriptMarker
import net.dfplots.dfscript_dsl.json.Event
import net.dfplots.dfscript_dsl.json.Script

@ScriptMarker
data class ScriptBuilder(var events: List<Event> = listOf())  {
    fun sendChat(build: EventBuilder.() -> Unit) {
        val builder = EventBuilder("SEND_CHAT")
        builder.build()

        events += builder.toSerializable()
    }

    fun toSerializable(): Script {
        return Script(events)
    }
}