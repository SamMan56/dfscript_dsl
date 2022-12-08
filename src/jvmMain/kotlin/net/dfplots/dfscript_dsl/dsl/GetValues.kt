package net.dfplots.dfscript_dsl.dsl


// a couple of these are not really necessary but like a uniform way to get values
fun textLiteral(value: String): TextValue {
    return TextValue(value)
}

fun numberLiteral(value: Double): NumberValue {
    return NumberValue(value)
}

fun<T : ValueType> EventBuilder.listVariable(name: String, vararg items: Value<T>): VariableValue<ListType<T>> {
    val listVariable = VariableValue<ListType<T>>(name)
    createList(listVariable)
    appendValue(listVariable, *items)
    return listVariable
}

fun <T: ValueType> EventBuilder.literalVariable(name: String, value: Value<T>): VariableValue<T> {
    val textVariable = VariableValue<T>(name)
    setVariable(textVariable, value)
    return textVariable
}