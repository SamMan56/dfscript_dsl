package net.dfplots.dfscript_dsl.json

import kotlinx.serialization.Serializable

@Serializable
sealed class JsonValue(val type: String)

@Serializable
data class JsonTextValue(val value: String) : JsonValue("TEXT")

@Serializable
data class JsonNumberValue(val value: Double) : JsonValue("NUMBER")

@Serializable
data class JsonVariableValue(val value: String) : JsonValue("VARIABLE")

@Serializable
data class JsonClientValue(val value: String) : JsonValue("CLIENT_VALUE")

@Serializable
data class JsonConfigValue(val value: String) : JsonValue("CONFIG_VALUE")


