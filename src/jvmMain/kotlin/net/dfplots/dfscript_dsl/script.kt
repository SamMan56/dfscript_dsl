package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.*
import net.dfplots.dfscript_dsl.dsl.actions.*

fun cool_script(): String {
    return script {
        onReceiveChat {
            displayChat(number(5).asText())
        }
    }
}

@DslMarker
annotation class ScriptMarker