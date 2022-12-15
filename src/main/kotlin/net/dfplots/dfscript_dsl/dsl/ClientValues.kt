package net.dfplots.dfscript_dsl.dsl

// why not an enum? the types of the values vary so a unifying enum would be tricky

fun keyPressed(): ClientValue<NumberType> = ClientValue("EVENT_KEY")
fun receivedMessage(): ClientValue<TextType> = ClientValue("EVENT_MESSAGE")
