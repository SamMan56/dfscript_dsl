package net.dfplots.dfscript_dsl

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.dfplots.dfscript_dsl.dsl.Script

fun main() {
    println(cool_script())
}

fun script(build: Script.() -> Unit): String {
    val builder = Script()
    builder.build()
    return Json.encodeToString(builder)
}