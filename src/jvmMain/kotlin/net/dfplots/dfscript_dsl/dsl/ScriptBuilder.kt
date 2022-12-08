package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.ScriptMarker
import net.dfplots.dfscript_dsl.json.JsonConfigPrototype
import net.dfplots.dfscript_dsl.json.JsonScript

@ScriptMarker
data class ScriptBuilder(
    var events: List<EventBuilder> = listOf(),
    var configPrototypes: List<JsonConfigPrototype> = listOf()
)  {
    fun toSerializable(): JsonScript {
        return JsonScript(
            events.flatMap { it.toSerializable() },
            configPrototypes,
            "DSL Script",
            false,
            "Do nothing",
            "Me"
        )
    }
}