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

/**
 * Checks if one number is greater than another.
 */
fun ConditionalBuilder.greaterThan(x: Value<NumberType>, y: Value<NumberType>): Condition {
    return addNullable("IF_GREATER", "IF_LESS_EQUALS", x, y)
}

/**
 * Checks if one number is greater than or equal to another.
 */
fun ConditionalBuilder.greaterThanOrEqualTo(x: Value<NumberType>, y: Value<NumberType>): Condition {
    return addNullable("IF_GREATER_EQUAL", "IF_LESS", x, y)
}

/**
 * Checks if one number is less than another.
 */
fun ConditionalBuilder.lessThan(x: Value<NumberType>, y: Value<NumberType>): Condition {
    return addNullable("IF_LESS", "IF_GREATER_EQUALS", x, y)
}

/**
 * Checks if one number is less than or equal to another.
 */
fun ConditionalBuilder.lessThanOrEqualTo(x: Value<NumberType>, y: Value<NumberType>): Condition {
    return addNullable("IF_LESS_EQUAL", "IF_GREATER", x, y)
}

/**
 * Checks if a number is between 2 different numbers (inclusive).
 */
fun ConditionalBuilder.withinRange(value: Value<NumberType>, minimum: Value<NumberType>, maximum: Value<NumberType>): Condition {
    return addNullable("IF_WITHIN_RANGE", "IF_NOT_WITHIN_RANGE", value, minimum, maximum)
}