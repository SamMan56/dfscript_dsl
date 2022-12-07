package net.dfplots.dfscript_dsl

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.dfplots.dfscript_dsl.dsl.ScriptBuilder

fun main() {
    println(cool_script())
}

fun script(build: ScriptBuilder.() -> Unit): String {
    val builder = ScriptBuilder()
    builder.build()
    val format = Json { prettyPrint = true; classDiscriminator = "class" }
    return format.encodeToString(builder.toSerializable())
}