package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.JsonAction

fun EventBuilder.display_chat(vararg texts: Value<TextType>) {
    actions += JsonAction("DISPLAY_CHAT", texts.map { it.toSerializable() })
}

fun EventBuilder.increment(variable: VariableValue<NumberType>) {
    actions += JsonAction("INCREMENT", listOf(variable.toSerializable()))
}