package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.ScriptMarker
import net.dfplots.dfscript_dsl.json.JsonConfigPrototype
import net.dfplots.dfscript_dsl.json.JsonIntConfigPrototype
import net.dfplots.dfscript_dsl.json.JsonScript
import net.dfplots.dfscript_dsl.json.JsonTextConfigPrototype

@ScriptMarker
data class ScriptBuilder(
    var events: List<EventBuilder> = listOf(),
    var configPrototypes: List<JsonConfigPrototype> = listOf()
)  {
    fun sendChat(build: EventBuilder.() -> Unit) {
        val builder = EventBuilder("SEND_CHAT")
        builder.build()

        events += builder
    }

    fun intConfigValue(name: String, value: Int): ConfigValue<NumberType> {
        configPrototypes += JsonIntConfigPrototype(name, value)
        return ConfigValue(name)
    }

    fun textConfigValue(name: String, value: String): ConfigValue<TextType> {
        configPrototypes += JsonTextConfigPrototype(name, value)
        return ConfigValue(name)
    }

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