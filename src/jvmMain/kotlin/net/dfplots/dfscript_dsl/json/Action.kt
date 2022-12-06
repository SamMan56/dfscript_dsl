package net.dfplots.dfscript_dsl.json

import kotlinx.serialization.Serializable

@Serializable
abstract class BaseAction(val type: String)

data class EventAction(val event: String) : BaseAction("event")

data class Action(val action: String) : BaseAction("action")