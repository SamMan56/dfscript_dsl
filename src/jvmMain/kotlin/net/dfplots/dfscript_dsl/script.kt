package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.*

fun cool_script(): String {
    return script {
        val range = intConfigValue("name", 0)
        val message = textConfigValue("message", "")

        sendChat {
            val testVar = literalVariable("testVar", textLiteral("Hello"))
            val listVar = listVariable("listVar", textLiteral("Hello"), textLiteral("world"))
            display_chat(TextValue("some"), testVar, receivedMessage(), message)
        }
    }
}

@DslMarker
annotation class ScriptMarker