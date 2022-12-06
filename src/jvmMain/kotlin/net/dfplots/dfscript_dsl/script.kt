package net.dfplots.dfscript_dsl

fun cool_script(): String {
    return script {
        sendChat {
            display_chat("some", "chat")
        }
    }
}

@DslMarker
annotation class ScriptMarker