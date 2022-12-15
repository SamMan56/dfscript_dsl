package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.JsonAction
import net.dfplots.dfscript_dsl.json.JsonActionOrEvent
import net.dfplots.dfscript_dsl.json.JsonEvent

@DslMarker
annotation class DFScriptDSL

@DFScriptDSL
class EventBuilder (
    val name: String,
    val actions: MutableList<JsonActionOrEvent> = mutableListOf()
) {
    fun toSerializable(): List<JsonActionOrEvent> {
        // an event is really just an action - create a new list headed by this
        return listOf(JsonEvent(name)) + actions
    }

    fun addAction(name: String, vararg arguments: Value<AnyType>) {
        actions += JsonAction(name, arguments.map { it.toSerializable() })
    }

    fun popActions(amount: Int) {
        (1..amount).forEach { _ -> actions.removeLast() }
    }
}