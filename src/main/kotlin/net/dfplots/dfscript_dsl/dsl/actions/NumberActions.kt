package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*


fun ActionReceiver.increment(variable: VariableValue<NumberType>) {
    addAction("INCREMENT", variable)
}

/**
 * Decrements a variable by a value.
 */
fun ActionReceiver.decrement(variable: VariableValue<NumberType>) {
    addAction("DECREMENT", variable)
}

/**
 * Sets a variable to the sum of the number(s).
 */
fun ActionReceiver.add(result: VariableValue<NumberType>, vararg numbers: Value<NumberType>) {
    addAction("ADD", result, *numbers)
}

/**
 * Sets a variable to the difference of the number(s).
 */
fun ActionReceiver.subtract(result: VariableValue<NumberType>, vararg numbers: Value<NumberType>) {
    addAction("SUBTRACT", result, *numbers)
}

/**
 * Sets a variable to the product of the number(s).
 */
fun ActionReceiver.multiply(result: VariableValue<NumberType>, vararg numbers: Value<NumberType>) {
    addAction("MULTIPLY", result, *numbers)
}

/**
 * Sets a variable to the quotient of the number(s).
 */
fun ActionReceiver.divide(result: VariableValue<NumberType>, vararg numbers: Value<NumberType>) {
    addAction("DIVIDE", result, *numbers)
}

/**
 * Sets a variable to the remainder of the numbers.
 */
fun ActionReceiver.modulo(result: VariableValue<NumberType>, dividend: Value<NumberType>, divisor: Value<NumberType>) {
    addAction("MODULO", result, dividend, divisor)
}

/**
 * Rounds a number.
 */
fun ActionReceiver.roundNumber(result: VariableValue<NumberType>, number: Value<NumberType>) {
    addAction("ROUND_NUM", result, number)
}

/**
 * Rounds a number down.
 */
fun ActionReceiver.floorNumber(result: VariableValue<NumberType>, number: Value<NumberType>) {
    addAction("FLOOR_NUM", result, number)
}

/**
 * Rounds a number up.
 */
fun ActionReceiver.ceilNumber(result: VariableValue<NumberType>, number: Value<NumberType>) {
    addAction("CEIL_NUM", result, number)
}

/**
 * Parses a number from a text.
 */
fun ActionReceiver.parseNumber(result: VariableValue<NumberType>, text: Value<TextType>) {
    addAction("PARSE_NUMBER", result, text)
}

/**
 * Generates a random whole number between two other numbers.
 */
fun ActionReceiver.randomInt(result: VariableValue<NumberType>, min: Value<NumberType>, max: Value<NumberType>) {
    addAction("RANDOM_INT", result, min, max)
}

/**
 * Generates a random number between two other numbers.
 */
fun ActionReceiver.randomDouble(result: VariableValue<NumberType>, min: Value<NumberType>, max: Value<NumberType>) {
    addAction("RANDOM_DOUBLE", result, min, max)
}