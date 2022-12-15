package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*


fun <T: ValueType> EventBuilder.createList(variable: VariableValue<ListType<T>>) {
    addAction("CREATE_LIST", variable)
}

fun <T: ValueType> EventBuilder.appendValue(list: VariableValue<ListType<T>>, vararg values: Value<T>) {
    addAction("APPEND_VALUE", list, *values)
}

fun <T: ValueType> EventBuilder.listLength(variable: VariableValue<NumberType>, list: VariableValue<ListType<T>>) {
    addAction("LIST_LENGTH", variable, list)
}