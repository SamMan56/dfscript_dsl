package net.dfplots.dfscript_dsl

import net.dfplots.dfscript_dsl.dsl.*

fun cool_script(): String {
    return script {
        onOverlay {
            `if` { equals(text("a"), text("b")) }.then {
                display_chat(text("1"))
            }.`else` {
                `if` { equals(text("c"), text("d")) }.then {
                    display_chat(text("2"))
                }.`else` {
                    display_chat(text("3"))
                }
            }
        }
    }
}

@DslMarker
annotation class ScriptMarker