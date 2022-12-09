package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.*

fun cool_script(): String {
    return script {
        onReceiveChat {
            val nextMsg = variable<NumberType>("nextMsg")
            `if` { equals(nextMsg, number(1)) }.then {
                val split = list<TextType>("split")
                splitTextByRegex(split, receivedMessage(), text(","))
                val len = variable<NumberType>("len")
                listLength(len, split)
                display_chat(text("Ignored Player Count:"), len)
                setVariable(nextMsg, number(0))
            }
            `if` { textContains(receivedMessage(), text("Current ignored players:")) }.then {
                setVariable(nextMsg, number(1))
            }
        }
    }
}

@DslMarker
annotation class ScriptMarker