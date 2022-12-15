package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.EventBuilder

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