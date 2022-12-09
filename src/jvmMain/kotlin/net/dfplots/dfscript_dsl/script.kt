package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.*

fun cool_script(): String {
    return script {
        val range = intConfigValue("name", 0)
        val message = textConfigValue("message", "")

        sendChat {
            val testVar = variable("testVar", text("Hello"))
            val listVar = list("listVar", text("Hello"), text("world"))
            val dictVar = dictionary("dictVar", text("Hello") to number(3))
            display_chat(TextValue("some"), testVar, receivedMessage(), message)
        }
    }
}

@DslMarker
annotation class ScriptMarker