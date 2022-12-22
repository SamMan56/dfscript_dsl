package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*

// unfortunately, this cannot check if types are equal at compile time
// since it will automatically assume anytype equality if unspecified
fun<T: ValueType> ConditionalBuilder.equals(x: Value<T>, y: Value<T>) {
    actionReceiver.addAction("IF_EQUALS", x, y)
}

/**
 * Checks if a text contains a value.
 */
fun ConditionalBuilder.textContains(text: Value<TextType>, subtext: Value<TextType>) {
    actionReceiver.addAction("IF_TEXT_CONTAINS", text, subtext)
}

fun ActionReceiver.closeBracket() {
    addAction("CLOSE_BRACKET")
}
