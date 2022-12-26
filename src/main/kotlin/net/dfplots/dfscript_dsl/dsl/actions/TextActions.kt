package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*

/**
 * Joins multiple texts into one.
 */
fun ActionReceiver.joinText(variable: VariableValue<TextType>) {
    addAction("JOIN_TEXT", variable)
}

/**
 * Copies the text to the clipboard.
 */
fun ActionReceiver.copyText(text: Value<TextType>) {
    addAction("COPY_TEXT", text)
}

/**
 * Splits a text into a list of texts.
 */
fun ActionReceiver.splitText(result: VariableValue<ListType<TextType>>, text: Value<TextType>, seperator: Value<TextType>) {
    addAction("SPLIT_TEXT", result, text, seperator)
}

/**
 * Splits a text into a list of texts using a regex as a separator.
 */
fun ActionReceiver.splitTextByRegex(
    variable: VariableValue<ListType<TextType>>,
    text: Value<TextType>,
    separatorRegex: Value<TextType>
) {
    addAction("REGEX_SPLIT_TEXT", variable, text, separatorRegex)
}

fun ActionReceiver.replaceTextUsingRegex(
    variable: VariableValue<TextType>,
    textToChange: Value<TextType>,
    regex: Value<TextType>,
    replacement: Value<TextType>
) {
    addAction("REGEX_REPLACE_TEXT", variable, textToChange, regex, replacement)
}

/**
 * Gets the index of the first occurrence of a text within another text.
 */
fun ActionReceiver.indexOfText(result: VariableValue<TextType>, text: Value<TextType>, subtext: Value<TextType>) {
    addAction("TEXT_INDEX_OF", result, text, subtext)
}

/**
 * Gets a piece of text within another text.
 */
fun ActionReceiver.getSubtext(result: VariableValue<TextType>, text: Value<TextType>, firstIndex: Value<NumberType>, lastIndex: Value<NumberType>) {
    addAction("TEXT_SUBTEXT", result, text, firstIndex, lastIndex)
}

/**
 * Get the length of a text value.
 */
fun ActionReceiver.getTextLength(result: VariableValue<NumberType>, text: Value<TextType>) {
    addAction("TEXT_LENGTH", result, text)
}

/**
 * Searches for part of a text and replaces it.
 */
fun ActionReceiver.replaceText(result: VariableValue<TextType>, textToChange: Value<TextType>, textToReplace: Value<TextType>, replacement: Value<TextType>) {
    addAction("REPLACE_TEXT", result, textToChange, textToReplace, replacement)
}

/**
 * Searches for part of a text using a regex and replaces it.
 */
fun ActionReceiver.replaceTextRegex(result: VariableValue<TextType>, textToChange: Value<TextType>, regex: Value<TextType>, replacement: Value<TextType>) {
    addAction("REGEX_REPLACE_TEXT", result, textToChange, regex, replacement)
}

/**
 * Searches for part of a text and removes it.
 */
fun ActionReceiver.removeText(result: VariableValue<TextType>, textToChange: Value<TextType>, textToRemove: Value<TextType>) {
    addAction("REMOVE_TEXT", result, textToChange, textToRemove)
}

/**
 * Searches for color codes in a text and removes them.
 */
fun ActionReceiver.stripColor(result: VariableValue<TextType>, text: Value<TextType>) {
    addAction("STRIP_COLOR", result, text)
}

/**
 * Repeats a text the given number of times.
 */
fun ActionReceiver.repeatText(result: VariableValue<TextType>, textToRepeat: Value<TextType>, timesToRepeat: Value<NumberType>) {
    addAction("REPEAT_TEXT", result, textToRepeat, timesToRepeat)
}

/**
 * Checks if a text contains a value.
 */
fun ConditionalBuilder.textContains(text: Value<TextType>, subtext: Value<TextType>): NonNullableCondition {
    actionReceiver.addAction("IF_TEXT_CONTAINS", text, subtext)
    return NonNullableCondition(innerBuilder)
}