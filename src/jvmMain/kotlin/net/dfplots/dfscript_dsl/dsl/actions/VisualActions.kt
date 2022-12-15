package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.EventBuilder
import net.dfplots.dfscript_dsl.dsl.TextType
import net.dfplots.dfscript_dsl.dsl.Value


fun EventBuilder.displayChat(vararg texts: Value<TextType>) {
    addAction("DISPLAY_CHAT", *texts)
}

fun EventBuilder.actionBar(vararg texts: Value<TextType>) {
    addAction("ACTIONBAR", *texts)
}

/**
 * Makes the player send a chat message.
 */
fun EventBuilder.sendChat(vararg texts: Value<TextType>) {
    addAction("SEND_CHAT", *texts)
}