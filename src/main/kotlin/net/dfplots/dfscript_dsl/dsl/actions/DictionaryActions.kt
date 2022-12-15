package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*


/**
 * Creates a new dictionary.
 */
fun <K: ValueType, V: ValueType> EventBuilder.createDictionary(
    variable: VariableValue<DictionaryType<K, V>>
) {
    addAction("CREATE_DICT", variable)
}

/**
 * Creates a dict from JSON data.
 */
fun <K: ValueType, V: ValueType> EventBuilder.parseJson(result: VariableValue<DictionaryType<K,V>>, json: Value<TextType>) {
    addAction("PARSE_JSON", result, json)
}

/**
 * Gets a value from a dictionary.
 */
fun <K: ValueType, V: ValueType> EventBuilder.getDictionaryValue(result: VariableValue<V>, dictionary: VariableValue<DictionaryType<K,V>>, key: Value<K>) {
    addAction("GET_DICT_VALUE", result, dictionary, key)
}

/**
 * Sets a value in a dictionary.
 */
fun <K: ValueType, V: ValueType> EventBuilder.setDictionaryValue(
    variable: VariableValue<DictionaryType<K, V>>, key: Value<K>, value: Value<V>,
) {
    addAction("SET_DICT_VALUE", variable, key, value)
}

/**
 * Gets the size of a dictionary.
 */
fun <K: ValueType, V: ValueType> EventBuilder.getDictionarySize(result: VariableValue<NumberType>, dictionary: Value<DictionaryType<K,V>>) {
    addAction("GET_DICT_SIZE", result, dictionary)
}

/**
 * Gets a list of the keys in a dictionary.
 */
fun <K: ValueType, V: ValueType> EventBuilder.getDictionaryKeys(result: VariableValue<ListType<K>>, dictionary: Value<DictionaryType<K,V>>) {
    addAction("GET_DICT_KEYS", result, dictionary)
}

/**
 * Removes a key from a dictionary.
 */
fun <K: ValueType, V: ValueType> EventBuilder.removeDictionaryEntry(dictionary: VariableValue<DictionaryType<K,V>>, key: Value<K>) {
    addAction("REMOVE_DICT_ENTRY", dictionary, key)
}