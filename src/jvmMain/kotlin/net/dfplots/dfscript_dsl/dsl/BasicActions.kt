package net.dfplots.dfscript_dsl.dsl

//
// visuals
//
fun EventBuilder.displayChat(vararg texts: Value<TextType>) {
    addAction("DISPLAY_CHAT", *texts)
}

fun EventBuilder.actionBar(vararg texts: Value<TextType>) {
    addAction("ACTIONBAR", *texts)
}

/**
 * Makes the player send a chat message.
 */
fun EventBuilder.sendChat(vararg texts: Value<TextType>) {
    addAction("SEND_CHAT", *texts)
}

//
// texts
//
fun EventBuilder.splitTextByRegex(
    variable: VariableValue<ListType<TextType>>,
    text: Value<TextType>,
    separatorRegex: Value<TextType>
) {
    addAction("REGEX_SPLIT_TEXT", variable, text, separatorRegex)
}

fun EventBuilder.replaceTextUsingRegex(
    variable: VariableValue<TextType>,
    textToChange: Value<TextType>,
    regex: Value<TextType>,
    replacement: Value<TextType>
) {
    addAction("REGEX_REPLACE_TEXT", variable, textToChange, regex, replacement)
}

//
// variables
//
fun <T: ValueType> EventBuilder.setVariable(variable: VariableValue<T>, value: Value<T>) {
    addAction("SET_VARIABLE", variable, value)
}

//
// numbers
//
fun EventBuilder.increment(variable: VariableValue<NumberType>) {
    addAction("INCREMENT", variable)
}

/**
 * Decrements a variable by a value.
 */
fun EventBuilder.decrement(variable: VariableValue<NumberType>) {
    addAction("DECREMENT", variable)
}

/**
 * Joins multiple texts into one.
 */
fun EventBuilder.joinText(variable: VariableValue<TextType>) {
    addAction("JOIN_TEXT", variable)
}

//
// lists
//
fun <T: ValueType> EventBuilder.createList(variable: VariableValue<ListType<T>>) {
    addAction("CREATE_LIST", variable)
}

fun <T: ValueType> EventBuilder.appendValue(list: VariableValue<ListType<T>>, vararg values: Value<T>) {
    addAction("APPEND_VALUE", list, *values)
}

fun <T: ValueType> EventBuilder.listLength(variable: VariableValue<NumberType>, list: VariableValue<ListType<T>>) {
    addAction("LIST_LENGTH", variable, list)
}

//
// dictionaries
//
fun <K: ValueType, V: ValueType> EventBuilder.createDictionary(
    variable: VariableValue<DictionaryType<K, V>>
) {
    addAction("CREATE_DICT", variable)
}

fun <K: ValueType, V: ValueType> EventBuilder.setDictionaryValue(
    variable: VariableValue<DictionaryType<K, V>>, key: Value<K>, value: Value<V>,
) {
    addAction("SET_DICT_VALUE", variable, key, value)
}