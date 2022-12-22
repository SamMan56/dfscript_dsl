package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.dsl.actions.displayChat
import net.dfplots.dfscript_dsl.dsl.actions.equals

fun main() {
    val builder = ScriptBuilder()

    builder.onBuildMode {
        `if` { equals(text("a"), text("b")) }.then {
            displayChat(text("a"))
        }.else_if { equals(text("c"), text("d")) }.then {
            displayChat(text("b"))
        }.`else` {
            displayChat(text("c"))
        }
    }

    println("done")
}