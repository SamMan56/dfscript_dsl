package net.dfplots.dfscript_dsl.dsl


// a couple of these are not really necessary but like a uniform way to get values
fun textLiteral(value: String): TextValue {
    return TextValue(value)
}

fun numberLiteral(value: Int): NumberValue {
    return NumberValue(value.toDouble())
}

fun numberLiteral(value: Double): NumberValue {
    return NumberValue(value)
}

fun <T: ValueType> EventBuilder.literalVariable(name: String, value: Value<T>): VariableValue<T> {
    val textVariable = VariableValue<T>(name)
    setVariable(textVariable, value)
    return textVariable
}

fun<T : ValueType> EventBuilder.listVariable(name: String, vararg items: Value<T>): VariableValue<ListType<T>> {
    val listVariable = VariableValue<ListType<T>>(name)
    createList(listVariable)
    appendValue(listVariable, *items)
    return listVariable
}

fun<K: ValueType, V: ValueType> EventBuilder.dictionaryVariable(name: String, vararg valuePairs: Pair<Value<K>, Value<V>>) {
    val dictionaryVariable = VariableValue<DictionaryType<K, V>>(name)
    createDictionary(dictionaryVariable)
    for (valuePair in valuePairs) {
        setDictionaryValue(dictionaryVariable, valuePair.first, valuePair.second)
    }
}