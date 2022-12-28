package net.dfplots.dfscript_dsl.dsl

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.dfplots.dfscript_dsl.json.JsonConfigPrototype
import net.dfplots.dfscript_dsl.json.JsonScript

@DFScriptDSL
class ScriptBuilder(
    var events: List<EventBuilder<BaseEvent>> = listOf(),
    var configPrototypes: List<JsonConfigPrototype> = listOf()
) {
    fun toSerializable(): JsonScript {
        return JsonScript(
            events.flatMap { it.actions }.flatMap { it.toSerializable() },
            configPrototypes,
            "DSL Script",
            false,
            "Do nothing",
            "Me"
        )
    }
}

fun script(build: ScriptBuilder.() -> Unit) {
    val builder = ScriptBuilder()
    builder.build()
    val format = Json { prettyPrint = true; classDiscriminator = "class" }
    print(format.encodeToString(builder.toSerializable()))
}