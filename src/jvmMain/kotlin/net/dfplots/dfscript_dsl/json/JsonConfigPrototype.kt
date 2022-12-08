package net.dfplots.dfscript_dsl.json

import kotlinx.serialization.Serializable

@Serializable
sealed class JsonConfigPrototype(val type: String)

@Serializable
data class JsonIntConfigPrototype (val name: String, val value: Int) : JsonConfigPrototype("INT")

@Serializable
data class JsonTextConfigPrototype (val name: String, val value: String) : JsonConfigPrototype("TEXT")