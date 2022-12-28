package net.dfplots.dfscript_dsl.dsl

// why not an enum? the types of the values vary so a unifying enum would be tricky

fun EventBuilder<BaseEvent>.timestamp(): ClientValue<NumberType> = ClientValue("TIMESTAMP")
fun EventBuilder<BaseEvent>.clipboard(): ClientValue<NumberType> = ClientValue("CLIPBOARD")
fun EventBuilder<BaseEvent>.selectedSlot(): ClientValue<NumberType> = ClientValue("SELECTED_SLOT")
fun EventBuilder<BaseEvent>.gameMode(): ClientValue<TextType> = ClientValue("GAME_MODE")
fun EventBuilder<BaseEvent>.windowWidth(): ClientValue<NumberType> = ClientValue("WINDOW_WIDTH")
fun EventBuilder<BaseEvent>.windowHeight(): ClientValue<NumberType> = ClientValue("WINDOW_HEIGHT")
fun EventBuilder<BaseEvent>.playerUUID(): ClientValue<TextType> = ClientValue("PLAYER_UUID")
fun EventBuilder<BaseEvent>.playerName(): ClientValue<TextType> = ClientValue("PLAYER_NAME")

fun EventBuilder<KeyPressEvent>.keyPressed(): ClientValue<NumberType> = ClientValue("EVENT_KEY")
fun EventBuilder<KeyPressEvent>.keyAction(): ClientValue<NumberType> = ClientValue("EVENT_KEY_ACTION")

fun EventBuilder<ReceiveChatEvent>.receivedMessage(): ClientValue<TextType> = ClientValue("EVENT_MESSAGE")

fun EventBuilder<SendChatEvent>.enteredMessage(): ClientValue<TextType> = ClientValue("EVENT_MESSAGE")

fun EventBuilder<MenuClickButtonEvent>.menuElementIdentifier(): ClientValue<TextType> = ClientValue("MENU_ELEMENT_IDENTIFIER")

fun EventBuilder<ReceiveSoundEvent>.receivedSound(): ClientValue<TextType> = ClientValue("EVENT_SOUND")
fun EventBuilder<ReceiveSoundEvent>.receivedSoundVolume(): ClientValue<NumberType> = ClientValue("EVENT_VOLUME")
fun EventBuilder<ReceiveSoundEvent>.receivedSoundPitch(): ClientValue<NumberType> = ClientValue("EVENT_PITCH")
