package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.*

fun cool_script(): String {
    return script {
        val variable = VariableValue<TextType>("variable")
        val range = intConfigValue("name", 0)
        val incremeted = VariableValue<NumberType>("eee")
        val message = textConfigValue("message", "")

        sendChat {
            display_chat(TextValue("some"), variable, receivedMessage(), message)
            increment(incremeted)
        }
    }
}

@DslMarker
annotation class ScriptMarker