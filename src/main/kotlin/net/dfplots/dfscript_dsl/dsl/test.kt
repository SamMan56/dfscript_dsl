package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.dsl.actions.displayChat
import net.dfplots.dfscript_dsl.dsl.actions.equals

fun main() {
    script {
        onBuildMode {
            `if` { equals(number(3), text("e")) }.then {
                displayChat(text("true"))
            }.else_if { equals(text("e"), number(3)) }.then {
                displayChat(text("maybe"))
            }.`else` {
                displayChat(text("false"))
            }
        }
    }
}