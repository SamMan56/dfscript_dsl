package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.JsonAction
import net.dfplots.dfscript_dsl.json.JsonValue

fun EventBuilder.add_action(name: String, vararg jsonArguments: JsonValue) {
    actions += JsonAction(name, jsonArguments.toList())
}

// quick utility function to avoid type nonsense & cleaner
fun <T: ValueType> Array<out Value<T>>.toSerializable(): Array<JsonValue> {
    return map { it.toSerializable() }.toTypedArray()
}

//
// visuals
//
fun EventBuilder.display_chat(vararg texts: Value<AnyType>) {
    add_action("DISPLAY_CHAT", *texts.toSerializable())
}

fun EventBuilder.splitTextByRegex(
    variable: VariableValue<ListType<TextType>>,
    text: Value<TextType>,
    separatorRegex: Value<TextType>
) {
    add_action("REGEX_SPLIT_TEXT", variable.toSerializable(), text.toSerializable(), separatorRegex.toSerializable())
}

//
// texts
//
fun EventBuilder.replaceTextUsingRegex(
    variable: VariableValue<TextType>,
    textToChange: Value<TextType>,
    regex: Value<TextType>,
    replacement: Value<TextType>
) {
    add_action("REGEX_REPLACE_TEXT", variable.toSerializable(), textToChange.toSerializable(), regex.toSerializable(), replacement.toSerializable())
}

//
// variables
//
fun <T: ValueType> EventBuilder.setVariable(variable: VariableValue<T>, value: Value<T>) {
    add_action("SET_VARIABLE", variable.toSerializable(), value.toSerializable())
}

//
// numbers
//
fun EventBuilder.increment(variable: VariableValue<NumberType>) {
    add_action("INCREMENT", variable.toSerializable())
}

//
// lists
//
fun <T: ValueType> EventBuilder.createList(variable: VariableValue<ListType<T>>) {
    add_action("CREATE_LIST", variable.toSerializable())
}

fun <T: ValueType> EventBuilder.appendValue(list: VariableValue<ListType<T>>, vararg values: Value<T>) {
    add_action("APPEND_VALUE", list.toSerializable(), *values.toSerializable())
}

fun <T: ValueType> EventBuilder.listLength(variable: VariableValue<NumberType>, list: VariableValue<ListType<T>>) {
    add_action("LIST_LENGTH", variable.toSerializable(), list.toSerializable())
}

//
// dictionaries
//
fun <K: ValueType, V: ValueType> EventBuilder.createDictionary(
    variable: VariableValue<DictionaryType<K, V>>
) {
    add_action("CREATE_DICT", variable.toSerializable())
}

fun <K: ValueType, V: ValueType> EventBuilder.setDictionaryValue(
    variable: VariableValue<DictionaryType<K, V>>, key: Value<K>, value: Value<V>,
) {
    add_action("SET_DICT_VALUE", variable.toSerializable(), key.toSerializable(), value.toSerializable())
}