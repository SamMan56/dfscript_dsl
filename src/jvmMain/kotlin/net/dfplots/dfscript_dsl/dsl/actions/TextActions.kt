package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*

/**
 * Joins multiple texts into one.
 */
fun EventBuilder.joinText(variable: VariableValue<TextType>) {
    addAction("JOIN_TEXT", variable)
}


fun EventBuilder.splitTextByRegex(
    variable: VariableValue<ListType<TextType>>,
    text: Value<TextType>,
    separatorRegex: Value<TextType>
) {
    addAction("REGEX_SPLIT_TEXT", variable, text, separatorRegex)
}

fun EventBuilder.replaceTextUsingRegex(
    variable: VariableValue<TextType>,
    textToChange: Value<TextType>,
    regex: Value<TextType>,
    replacement: Value<TextType>
) {
    addAction("REGEX_REPLACE_TEXT", variable, textToChange, regex, replacement)
}