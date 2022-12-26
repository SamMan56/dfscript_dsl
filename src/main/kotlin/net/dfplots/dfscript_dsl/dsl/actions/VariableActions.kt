package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*


fun <T: ValueType> ActionReceiver.setVariable(variable: VariableValue<T>, value: Value<T>) {
    addAction("SET_VARIABLE", variable, value)
}

// unfortunately, this cannot check if types are equal at compile time
// since it will automatically assume anytype equality if unspecified
/**
 * Checks if one value is equal to another.
 */
fun<T: ValueType> ConditionalBuilder.equals(x: Value<T>, y: Value<T>): Condition {
    return addNullable("IF_EQUALS", "IF_NOT_EQUALS", x, y)
}

/**
 * Checks if one value is not equal to another.
 */
fun<T: ValueType> ConditionalBuilder.notEquals(x: Value<T>, y: Value<T>): Condition {
    return addNullable("IF_NOT_EQUALS", "IF_EQUALS", x, y)
}