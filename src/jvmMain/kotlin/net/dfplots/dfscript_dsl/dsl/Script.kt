package net.dfplots.dfscript_dsl.dsl

import kotlinx.serialization.Serializable
import net.dfplots.dfscript_dsl.ScriptMarker

@ScriptMarker
@Serializable
data class Script(var events: List<Event> = listOf())  {
    fun sendChat(build: Event.() -> Unit) {
        val builder = Event("SEND_CHAT")
        builder.build()

        events += builder
    }
}