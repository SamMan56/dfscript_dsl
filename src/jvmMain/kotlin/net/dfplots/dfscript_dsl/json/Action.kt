package net.dfplots.dfscript_dsl.json

import kotlinx.serialization.Serializable

@Serializable
sealed class ActionOrEvent(val type: String)

@Serializable
data class Event(val event: String) : ActionOrEvent("event")

@Serializable
data class Action(val action: String, val arguments: List<Int>) : ActionOrEvent("action")