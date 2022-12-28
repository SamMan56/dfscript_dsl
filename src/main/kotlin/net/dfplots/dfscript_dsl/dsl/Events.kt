package net.dfplots.dfscript_dsl.dsl


private fun <T: BaseEvent> ScriptBuilder.addEvent(name: String, build: EventBuilder<T>.() -> Unit) {
    val builder = EventBuilder<T>(name)
    builder.build()

    events += builder
}

/**
 * Executed when a player sends a chat message.
 */
fun ScriptBuilder.onSendChat(build: EventBuilder<SendChatEvent>.() -> Unit) {
    addEvent("SEND_CHAT", build)
}

/**
 * Executed when a player presses a key.
 */
fun ScriptBuilder.onKeyPress(build: EventBuilder<KeyPressEvent>.() -> Unit) {
    addEvent("KEY_PRESS", build)
}

/**
 * Executed when a player receives a chat message.
 */
fun ScriptBuilder.onReceiveChat(build: EventBuilder<ReceiveChatEvent>.() -> Unit) {
    addEvent("RECEIVE_CHAT", build)
}

/**
 * Executed every tick.
 */
fun ScriptBuilder.onTick(build: EventBuilder<BaseEvent>.() -> Unit) {
    addEvent("TICK_EVENT", build)
}

/**
 * Executed when a player enters play mode.
 */
fun ScriptBuilder.onPlayMode(build: EventBuilder<BaseEvent>.() -> Unit) {
    addEvent("PLAY_MODE_EVENT", build)
}

/**
 * Executed when a player enters build mode.
 */
fun ScriptBuilder.onBuildMode(build: EventBuilder<BaseEvent>.() -> Unit) {
    addEvent("BUILD_MODE", build)
}

/**
 * Executed when a player enters dev mode.
 */
fun ScriptBuilder.onDevMode(build: EventBuilder<BaseEvent>.() -> Unit) {
    addEvent("DEV_MODE", build)
}

/**
 * Executed when all scripts are being loaded.
 */
fun ScriptBuilder.onStartUp(build: EventBuilder<BaseEvent>.() -> Unit) {
    addEvent("START_UP", build)
}

/**
 * Executed when the overlay is being rendered.
 */
fun ScriptBuilder.onOverlay(build: EventBuilder<BaseEvent>.() -> Unit) {
    addEvent("OVERLAY_EVENT", build)
}

/**
 * Executed when a player clicks a button inside a custom menu.
 */
fun ScriptBuilder.onMenuButtonClick(build: EventBuilder<MenuClickButtonEvent>.() -> Unit) {
    addEvent("MENU_BUTTON_EVENT", build)
}

/**
 * Executed when a player receives a sound.
 */
fun ScriptBuilder.onReceiveSound(build: EventBuilder<ReceiveSoundEvent>.() -> Unit) {
    addEvent("RECEIVE_SOUND", build)
}