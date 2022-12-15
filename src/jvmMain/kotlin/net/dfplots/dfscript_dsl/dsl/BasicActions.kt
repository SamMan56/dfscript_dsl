package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.JsonValue

// quick utility function to avoid type nonsense & cleaner
fun <T: ValueType> Array<out Value<T>>.toSerializable(): Array<JsonValue> {
    return map { it.toSerializable() }.toTypedArray()
}

//
// visuals
//
fun EventBuilder.displayChat(vararg texts: Value<AnyType>) {
    addAction("DISPLAY_CHAT", *texts.toSerializable())
}

fun EventBuilder.splitTextByRegex(
    variable: VariableValue<ListType<TextType>>,
    text: Value<TextType>,
    separatorRegex: Value<TextType>
) {
    addAction("REGEX_SPLIT_TEXT", variable.toSerializable(), text.toSerializable(), separatorRegex.toSerializable())
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
    addAction("REGEX_REPLACE_TEXT", variable.toSerializable(), textToChange.toSerializable(), regex.toSerializable(), replacement.toSerializable())
}

//
// variables
//
fun <T: ValueType> EventBuilder.setVariable(variable: VariableValue<T>, value: Value<T>) {
    addAction("SET_VARIABLE", variable.toSerializable(), value.toSerializable())
}

//
// numbers
//
fun EventBuilder.increment(variable: VariableValue<NumberType>) {
    addAction("INCREMENT", variable.toSerializable())
}

//
// lists
//
fun <T: ValueType> EventBuilder.createList(variable: VariableValue<ListType<T>>) {
    addAction("CREATE_LIST", variable.toSerializable())
}

fun <T: ValueType> EventBuilder.appendValue(list: VariableValue<ListType<T>>, vararg values: Value<T>) {
    addAction("APPEND_VALUE", list.toSerializable(), *values.toSerializable())
}

fun <T: ValueType> EventBuilder.listLength(variable: VariableValue<NumberType>, list: VariableValue<ListType<T>>) {
    addAction("LIST_LENGTH", variable.toSerializable(), list.toSerializable())
}

//
// dictionaries
//
fun <K: ValueType, V: ValueType> EventBuilder.createDictionary(
    variable: VariableValue<DictionaryType<K, V>>
) {
    addAction("CREATE_DICT", variable.toSerializable())
}

fun <K: ValueType, V: ValueType> EventBuilder.setDictionaryValue(
    variable: VariableValue<DictionaryType<K, V>>, key: Value<K>, value: Value<V>,
) {
    addAction("SET_DICT_VALUE", variable.toSerializable(), key.toSerializable(), value.toSerializable())
}