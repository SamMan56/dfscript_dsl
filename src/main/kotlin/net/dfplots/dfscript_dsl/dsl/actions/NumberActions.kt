package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*


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

/**
 * Rounds a number.
 */
fun EventBuilder.roundNumber(result: VariableValue<NumberType>, number: Value<NumberType>) {
    addAction("ROUND_NUM", result, number)
}

/**
 * Rounds a number down.
 */
fun EventBuilder.floorNumber(result: VariableValue<NumberType>, number: Value<NumberType>) {
    addAction("FLOOR_NUM", result, number)
}

/**
 * Rounds a number up.
 */
fun EventBuilder.ceilNumber(result: VariableValue<NumberType>, number: Value<NumberType>) {
    addAction("CEIL_NUM", result, number)
}

/**
 * Parses a number from a text.
 */
fun EventBuilder.parseNumber(result: VariableValue<NumberType>, text: Value<TextType>) {
    addAction("PARSE_NUMBER", result, text)
}

/**
 * Generates a random whole number between two other numbers.
 */
fun EventBuilder.randomInt(result: VariableValue<NumberType>, min: Value<NumberType>, max: Value<NumberType>) {
    addAction("RANDOM_INT", result, min, max)
}

/**
 * Generates a random number between two other numbers.
 */
fun EventBuilder.randomDouble(result: VariableValue<NumberType>, min: Value<NumberType>, max: Value<NumberType>) {
    addAction("RANDOM_DOUBLE", result, min, max)
}