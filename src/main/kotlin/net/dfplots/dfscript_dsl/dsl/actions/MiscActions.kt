package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*

/**
 * Cancels the event.
 */
fun ActionReceiver.cancelEvent() {
    addAction("CANCEL_EVENT")
}

/**
 * Uncancels the event.
 */
fun ActionReceiver.uncancelEvent() {
    addAction("UNCANCEL_EVENT")
}

/**
 * Waits for a given amount of time.
 */
fun ActionReceiver.wait(ticks: Value<NumberType>) {
    addAction("WAIT", ticks)
}

/**
 * Registers a /cmd completion.
 */
fun ActionReceiver.registerCommand(vararg commands: Value<TextType>) {
    addAction("REGISTER_CMD", *commands)
}

/**
 * Stops the current codeline.
 */
fun ActionReceiver.stop() {
    addAction("STOP")
}

/**
 * Skips the current iteration of the latest loop.
 */
fun ActionReceiver.skipIteration() {
    addAction("SKIP_ITERATION")
}

/**
 * Stops the latest loop.
 */
fun ActionReceiver.stopRepetition() {
    addAction("STOP_REPETITION")
}

/**
 * Reads a file from the scripts folder.
 */
fun ActionReceiver.readFile(result: VariableValue<TextType>, filename: Value<TextType>) {
    addAction("READ_FILE", result, filename)
}

/**
 * Writes a file to the scripts folder.
 */
fun ActionReceiver.writeFile(filename: Value<TextType>, content: Value<AnyType>) {
    addAction("WRITE_FILE", filename, content)
}

/**
 * Executes if a gui is open.
 */
fun ConditionalBuilder.guiOpen(): Condition {
    return addNullable("IF_GUI_OPEN", "IF_GUI_CLOSED")
}

/**
 * Executes if the specified file exists.
 */
fun ConditionalBuilder.fileExists(filename: Value<TextType>): Condition {
    return addNullable("IF_FILE_EXISTS", "IF_FILE_DOESNT_EXIST")
}