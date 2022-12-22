package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.dsl.actions.displayChat
import net.dfplots.dfscript_dsl.dsl.actions.textContains

fun main() {
    script {
        onBuildMode {
            `if` { !textContains(text("e"), text("e")) }.then {
                displayChat(text("true"))
            }.else_if { !textContains(text("ec"), text("c")) }.then {
                displayChat(text("maybe"))
            }.`else` {
                displayChat(text("false"))
            }
        }
    }
}