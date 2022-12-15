package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*


fun <T: ValueType> EventBuilder.createList(variable: VariableValue<ListType<T>>) {
    addAction("CREATE_LIST", variable)
}

fun <T: ValueType> EventBuilder.appendValue(list: VariableValue<ListType<T>>, vararg values: Value<T>) {
    addAction("APPEND_VALUE", list, *values)
}

/**
 * Appends one list's contents to another.
 */
fun <T: ValueType> EventBuilder.appendListValues(baseList: VariableValue<ListType<T>>, otherList: Value<ListType<T>>) {
    addAction("APPEND_LIST_VALUES", baseList, otherList)
}

/**
 * Gets a value from a list.
 */
fun <T: ValueType> EventBuilder.getListValue(result: VariableValue<T>, list: Value<ListType<T>>, index: Value<NumberType>) {
    addAction("GET_LIST_VALUE", result, list, index)
}

/**
 * Searches for a value in a list variable and gets the index if found.
 */
fun <T: ValueType> EventBuilder.getValueIndex(result: VariableValue<NumberType>, list: Value<ListType<T>>, value: Value<T>) {
    addAction("GET_VALUE_INDEX", result, list, value)
}

/**
 * Sets a value in a list.
 */
fun <T: ValueType> EventBuilder.setListValue(list: VariableValue<ListType<T>>, index: Value<NumberType>, value: Value<T>) {
    addAction("SET_LIST_VALUE", list, index, value)
}

/**
 * Removes a value at index from a list.
 */
fun <T: ValueType> EventBuilder.removeListIndex(list: VariableValue<ListType<T>>, index: Value<NumberType>) {
    addAction("REMOVE_LIST_AT_INDEX_VALUE", list, index)
}

/**
 * Removes a value from a list.
 */
fun <T: ValueType> EventBuilder.removeListValue(list: VariableValue<ListType<T>>, value: Value<T>) {
    addAction("REMOVE_LIST_VALUE", list, value)
}

/**
 * Returns the length of a list.
 */
fun <T: ValueType> EventBuilder.listLength(variable: VariableValue<NumberType>, list: VariableValue<ListType<T>>) {
    addAction("LIST_LENGTH", variable, list)
}

/**
 * Joins a list into a single text.
 */
fun <T: ValueType> EventBuilder.joinListToText(result: VariableValue<TextType>, list: Value<ListType<T>>, seperator: Value<TextType> = text(", ")) {
    addAction("JOIN_LIST_TO_TEXT", result, list, seperator)
}

/**
 * Sorts a list in ascending order.
 */
fun <T: ValueType> EventBuilder.sortList(result: VariableValue<ListType<T>>, list: Value<ListType<T>>) {
    addAction("SORT_LIST", result, list)
}