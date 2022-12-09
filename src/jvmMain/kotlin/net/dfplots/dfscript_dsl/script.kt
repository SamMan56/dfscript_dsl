package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.*

fun cool_script(): String {
    return script {
        onReceiveChat {
            `if` { equals(text("A"), text("B")) }.then {
                displayChat(text("1"))
            }.else_if { equals(text("C"), text("D")) }.then {
                displayChat(text("2"))
            }.`else` {
                displayChat(text("3"))
            }
        }
    }
}

@DslMarker
annotation class ScriptMarker