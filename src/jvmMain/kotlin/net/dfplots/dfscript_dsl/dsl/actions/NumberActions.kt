package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.EventBuilder
import net.dfplots.dfscript_dsl.dsl.NumberType
import net.dfplots.dfscript_dsl.dsl.Value
import net.dfplots.dfscript_dsl.dsl.VariableValue


fun EventBuilder.increment(variable: VariableValue<NumberType>) {
    addAction("INCREMENT", variable)
}

/**
 * Decrements a variable by a value.
 */
fun EventBuilder.decrement(variable: VariableValue<NumberType>) {
    addAction("DECREMENT", variable)
}

/**
 * Sets a variable to the sum of the number(s).
 */
fun EventBuilder.add(result: VariableValue<NumberType>, vararg numbers: Value<NumberType>) {
    addAction("ADD", result, *numbers)
}

/**
 * Sets a variable to the difference of the number(s).
 */
fun EventBuilder.subtract(result: VariableValue<NumberType>, vararg numbers: Value<NumberType>) {
    addAction("SUBTRACT", result, *numbers)
}

/**
 * Sets a variable to the product of the number(s).
 */
fun EventBuilder.multiply(result: VariableValue<NumberType>, vararg numbers: Value<NumberType>) {
    addAction("MULTIPLY", result, *numbers)
}

/**
 * Sets a variable to the quotient of the number(s).
 */
fun EventBuilder.divide(result: VariableValue<NumberType>, vararg numbers: Value<NumberType>) {
    addAction("DIVIDE", result, *numbers)
}

/**
 * Sets a variable to the remainder of the numbers.
 */
fun EventBuilder.modulo(result: VariableValue<NumberType>, dividend: Value<NumberType>, divisor: Value<NumberType>) {
    addAction("MODULO", result, dividend, divisor)
}