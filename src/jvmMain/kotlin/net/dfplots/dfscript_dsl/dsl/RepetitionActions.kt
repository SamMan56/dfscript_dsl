package net.dfplots.dfscript_dsl.dsl

private fun EventBuilder.addActionWithChildren(name: String, vararg arguments: Value<AnyType>, build: EventBuilder.() -> Unit) {
    addAction(name, *arguments)
    build()
    closeBracket()
}

fun EventBuilder.repeatMultiple(times: Value<NumberType>, current: VariableValue<NumberType>, build: EventBuilder.() -> Unit) {
    addActionWithChildren("REPEAT_MULTIPLE", times, current, build=build)
}

fun <T: ValueType> EventBuilder.forEachInList(variable: VariableValue<T>, list: Value<ListType<T>>, build: EventBuilder.() -> Unit) {
    addActionWithChildren("FOR_EACH_IN_LIST", variable, list, build=build)
}

fun <K: ValueType, V: ValueType> EventBuilder.forEachInDictionary(
    key: VariableValue<K>,
    value: VariableValue<V>,
    dict: Value<DictionaryType<K,V>>,
    build: EventBuilder.() -> Unit
) {
    addActionWithChildren("DICT_FOR_EACH", key, value, dict, build=build)
}

fun EventBuilder.repeatForever(build: EventBuilder.() -> Unit) {
    addActionWithChildren("REPEAT_FOREVER", build=build)
}