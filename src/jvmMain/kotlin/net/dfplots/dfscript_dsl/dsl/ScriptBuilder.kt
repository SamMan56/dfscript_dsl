package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.ScriptMarker
import net.dfplots.dfscript_dsl.json.Script

@ScriptMarker
data class ScriptBuilder(var events: List<EventBuilder> = listOf())  {
    fun sendChat(build: EventBuilder.() -> Unit) {
        val builder = EventBuilder("SEND_CHAT")
        builder.build()

        events += builder
    }

    fun toSerializable(): Script {
        return Script(events.flatMap { it.toSerializable() }, listOf(), "DSL Script", false, "Do nothing", "Me")
    }
}