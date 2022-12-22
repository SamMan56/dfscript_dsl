package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*


fun ActionReceiver.displayChat(vararg texts: Value<TextType>) {
    addAction("DISPLAY_CHAT", *texts)
}

fun ActionReceiver.actionBar(vararg texts: Value<TextType>) {
    addAction("ACTIONBAR", *texts)
}

/**
 * Makes the player send a chat message.
 */
fun ActionReceiver.sendChat(vararg texts: Value<TextType>) {
    addAction("SEND_CHAT", *texts)
}

fun ActionReceiver.playSound(sound: Value<TextType>, volume: Value<NumberType> = number(1), pitch: Value<NumberType> = number(1)) {
    addAction("PLAY_SOUND", sound, volume, pitch)
}

/**
 * Stops all sounds.
 */
fun ActionReceiver.stopAllSounds() {
    addAction("STOP_ALL_SOUNDS")
}

/**
 * Displays a title.
 */
fun ActionReceiver.displayTitle(
    title: Value<TextType>,
    subtitle: Value<TextType> = text(""),
    fadeIn: Value<NumberType> = number(20),
    stay: Value<NumberType> = number(60),
    fadeOut: Value<NumberType> = number(20)
) {
    addAction("DISPLAY_TITLE", title, subtitle, fadeIn, stay, fadeOut)
}

/**
 * Draws text on the screen.
 */
fun ActionReceiver.drawText(text: Value<TextType>, x: Value<NumberType>, y: Value<NumberType>) {
    addAction("DRAW_TEXT", text, x, y)
}

/**
 * Measures the width of a text in pixels.
 */
fun ActionReceiver.measureText(result: VariableValue<NumberType>, text: Value<TextType>) {
    addAction("MEASURE_TEXT", result, text)
}