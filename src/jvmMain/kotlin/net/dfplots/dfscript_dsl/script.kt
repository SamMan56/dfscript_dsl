package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.TextType
import net.dfplots.dfscript_dsl.dsl.TextValue
import net.dfplots.dfscript_dsl.dsl.VariableValue
import net.dfplots.dfscript_dsl.dsl.receivedMessage

fun cool_script(): String {
    return script {
        val variable = VariableValue<TextType>("variable")

        sendChat {
            display_chat(TextValue("some"), variable, receivedMessage())
        }
    }
}

@DslMarker
annotation class ScriptMarker