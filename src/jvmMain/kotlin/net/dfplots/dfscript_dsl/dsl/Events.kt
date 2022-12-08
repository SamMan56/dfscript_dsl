package net.dfplots.dfscript_dsl.dsl


fun ScriptBuilder.sendChat(build: EventBuilder.() -> Unit) {
    val builder = EventBuilder("SEND_CHAT")
    builder.build()

    events += builder
}