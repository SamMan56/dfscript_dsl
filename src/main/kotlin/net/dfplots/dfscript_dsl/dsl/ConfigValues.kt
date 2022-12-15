package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.JsonIntConfigPrototype
import net.dfplots.dfscript_dsl.json.JsonTextConfigPrototype

fun ScriptBuilder.intConfigValue(name: String, value: Int): ConfigValue<NumberType> {
    configPrototypes += JsonIntConfigPrototype(name, value)
    return ConfigValue(name)
}

fun ScriptBuilder.textConfigValue(name: String, value: String): ConfigValue<TextType> {
    configPrototypes += JsonTextConfigPrototype(name, value)
    return ConfigValue(name)
}