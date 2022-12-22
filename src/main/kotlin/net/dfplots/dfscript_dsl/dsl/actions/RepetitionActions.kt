package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*

private fun ActionReceiver.addActionWithChildren(name: String, vararg arguments: Value<AnyType>, build: ActionReceiver.() -> Unit) {
    addAction(name, *arguments)
    build()
    closeBracket()
}

fun ActionReceiver.repeatMultiple(times: Value<NumberType>, current: VariableValue<NumberType>, build: ActionReceiver.() -> Unit) {
    addActionWithChildren("REPEAT_MULTIPLE", times, current, build=build)
}

fun <T: ValueType> ActionReceiver.forEachInList(variable: VariableValue<T>, list: Value<ListType<T>>, build: ActionReceiver.() -> Unit) {
    addActionWithChildren("FOR_EACH_IN_LIST", variable, list, build=build)
}

fun <K: ValueType, V: ValueType> ActionReceiver.forEachInDictionary(
    key: VariableValue<K>,
    value: VariableValue<V>,
    dict: Value<DictionaryType<K, V>>,
    build: ActionReceiver.() -> Unit
) {
    addActionWithChildren("DICT_FOR_EACH", key, value, dict, build=build)
}

fun ActionReceiver.repeatForever(build: ActionReceiver.() -> Unit) {
    addActionWithChildren("REPEAT_FOREVER", build=build)
}