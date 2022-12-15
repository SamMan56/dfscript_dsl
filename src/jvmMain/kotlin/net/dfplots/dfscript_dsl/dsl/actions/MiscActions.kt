package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*

/**
 * Cancels the event.
 */
fun EventBuilder.cancelEvent() {
    addAction("CANCEL_EVENT")
}

/**
 * Uncancels the event.
 */
fun EventBuilder.uncancelEvent() {
    addAction("UNCANCEL_EVENT")
}

/**
 * Waits for a given amount of time.
 */
fun EventBuilder.wait(ticks: Value<NumberType>) {
    addAction("WAIT", ticks)
}

/**
 * Registers a /cmd completion.
 */
fun EventBuilder.registerCommand(vararg commands: Value<TextType>) {
    addAction("REGISTER_CMD", *commands)
}

/**
 * Stops the current codeline.
 */
fun EventBuilder.stop() {
    addAction("STOP")
}

/**
 * Skips the current iteration of the latest loop.
 */
fun EventBuilder.skipIteration() {
    addAction("SKIP_ITERATION")
}

/**
 * Stops the latest loop.
 */
fun EventBuilder.stopRepetition() {
    addAction("STOP_REPETITION")
}

/**
 * Reads a file from the scripts folder.
 */
fun EventBuilder.readFile(result: VariableValue<TextType>, filename: Value<TextType>) {
    addAction("READ_FILE", result, filename)
}

/**
 * Writes a file to the scripts folder.
 */
fun EventBuilder.writeFile(filename: Value<TextType>, content: Value<AnyType>) {
    addAction("WRITE_FILE", filename, content)
}