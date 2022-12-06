package net.dfplots.dfscript_dsl.json

import kotlinx.serialization.Serializable

@Serializable
data class Script(var events: List<Event>)