package net.dfplots.dfscript_dsl.dsl


// a couple of these are not really necessary but like a uniform way to get values
fun text(value: String): TextValue {
    return TextValue(value)
}

fun number(value: Int): NumberValue {
    return NumberValue(value.toDouble())
}

fun number(value: Double): NumberValue {
    return NumberValue(value)
}

/**
 * Makes a variable from some literal value.
 *
 * Note that some types, such as lists and dictionaries cannot be used here.
 * This is since DFScript does not have list or dictionary literals.
 * Thus, they are always variables.
 */
fun <T: ValueType> EventBuilder.variable(name: String, value: LiteralValue<T>): VariableValue<T> {
    val variable = VariableValue<T>(name)
    setVariable(variable, value)
    return variable
}

fun <T: ValueType> EventBuilder.variable(name: String): VariableValue<T> {
    return VariableValue(name)
}

fun<T : ValueType> EventBuilder.list(name: String, vararg items: Value<T>): VariableValue<ListType<T>> {
    val listVariable = VariableValue<ListType<T>>(name)
    createList(listVariable)
    appendValue(listVariable, *items)
    return listVariable
}

fun<K: ValueType, V: ValueType> EventBuilder.dictionary(name: String, vararg valuePairs: Pair<Value<K>, Value<V>>) {
    val dictionaryVariable = VariableValue<DictionaryType<K, V>>(name)
    createDictionary(dictionaryVariable)
    for (valuePair in valuePairs) {
        setDictionaryValue(dictionaryVariable, valuePair.first, valuePair.second)
    }
}