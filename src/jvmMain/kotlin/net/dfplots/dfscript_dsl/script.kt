package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.*

fun cool_script(): String {
    return script {
        val message = textConfigValue("message", "")

        onOverlay {
            val testVar = variable("testVar", text("Hello"))
            val listVar = list("listVar", text("Hello"), text("world"))
            val dictVar = dictionary("dictVar", text("Hello") to number(3))
            display_chat(TextValue("some"), testVar, receivedMessage(), message)
        }
    }
}

@DslMarker
annotation class ScriptMarker