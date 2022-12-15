package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.*

fun cool_script(): String {
    return script {
        onReceiveChat {
            repeatForever {
                displayChat(text("a"))
            }
        }
    }
}

@DslMarker
annotation class ScriptMarker