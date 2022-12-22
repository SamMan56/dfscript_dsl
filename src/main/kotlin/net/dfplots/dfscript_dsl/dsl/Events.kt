package net.dfplots.dfscript_dsl.dsl


private fun ScriptBuilder.addEvent(name: String, build: ActionReceiver.() -> Unit) {
    val builder = EventBuilder(name)
    builder.build()

    events += builder
}

/**
 * Executed when a player sends a chat message.
 */
fun ScriptBuilder.onSendChat(build: ActionReceiver.() -> Unit) {
    addEvent("SEND_CHAT", build)
}

/**
 * Executed when a player presses a key.
 */
fun ScriptBuilder.onKeyPress(build: ActionReceiver.() -> Unit) {
    addEvent("KEY_PRESS", build)
}

/**
 * Executed when a player receives a chat message.
 */
fun ScriptBuilder.onReceiveChat(build: ActionReceiver.() -> Unit) {
    addEvent("RECEIVE_CHAT", build)
}

/**
 * Executed every tick.
 */
fun ScriptBuilder.onTick(build: ActionReceiver.() -> Unit) {
    addEvent("TICK_EVENT", build)
}

/**
 * Executed when a player enters play mode.
 */
fun ScriptBuilder.onPlayMode(build: ActionReceiver.() -> Unit) {
    addEvent("PLAY_MODE_EVENT", build)
}

/**
 * Executed when a player enters build mode.
 */
fun ScriptBuilder.onBuildMode(build: ActionReceiver.() -> Unit) {
    addEvent("BUILD_MODE", build)
}

/**
 * Executed when a player enters dev mode.
 */
fun ScriptBuilder.onDevMode(build: ActionReceiver.() -> Unit) {
    addEvent("DEV_MODE", build)
}

/**
 * Executed when all scripts are being loaded.
 */
fun ScriptBuilder.onStartUp(build: ActionReceiver.() -> Unit) {
    addEvent("START_UP", build)
}

/**
 * Executed when the overlay is being rendered.
 */
fun ScriptBuilder.onOverlay(build: ActionReceiver.() -> Unit) {
    addEvent("OVERLAY_EVENT", build)
}

/**
 * Executed when a player clicks a button inside a custom menu.
 */
fun ScriptBuilder.onMenuButtonClick(build: ActionReceiver.() -> Unit) {
    addEvent("MENU_BUTTON_EVENT", build)
}

/**
 * Executed when a player receives a sound.
 */
fun ScriptBuilder.onReceiveSound(build: ActionReceiver.() -> Unit) {
    addEvent("RECEIVE_SOUND", build)
}