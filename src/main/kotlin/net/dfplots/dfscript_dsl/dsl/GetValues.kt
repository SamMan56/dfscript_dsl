package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.dsl.actions.*


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
fun <T: ValueType> ActionReceiver.variable(name: String, value: LiteralValue<T>): VariableValue<T> {
    val variable = VariableValue<T>(name)
    setVariable(variable, value)
    return variable
}

fun <T: ValueType> ActionReceiver.variable(name: String): VariableValue<T> {
    return VariableValue(name)
}

fun<T : ValueType> ActionReceiver.list(variableName: String, vararg items: Value<T>): VariableValue<ListType<T>> {
    val listVariable = VariableValue<ListType<T>>(variableName)
    createList(listVariable)
    appendValue(listVariable, *items)
    return listVariable
}

fun<K: ValueType, V: ValueType> ActionReceiver.dictionary(variableName: String, vararg valuePairs: Pair<Value<K>, Value<V>>)
: VariableValue<DictionaryType<K, V>> {
    val dictionaryVariable = VariableValue<DictionaryType<K, V>>(variableName)
    createDictionary(dictionaryVariable)
    for (valuePair in valuePairs) {
        setDictionaryValue(dictionaryVariable, valuePair.first, valuePair.second)
    }
    return dictionaryVariable
}

fun ActionReceiver.item(variableName: String, id: String): VariableValue<DictionaryType<TextType, AnyType>> {
    return dictionary(variableName, Pair(text("id"), text(id)))
}