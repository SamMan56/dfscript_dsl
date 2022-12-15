package net.dfplots.dfscript_dsl.json

import kotlinx.serialization.Serializable

@Serializable
sealed class JsonActionOrEvent(val type: String)

@Serializable
data class JsonEvent(val event: String) : JsonActionOrEvent("event")

@Serializable
data class JsonAction(val action: String, val arguments: List<JsonValue>) : JsonActionOrEvent("action")