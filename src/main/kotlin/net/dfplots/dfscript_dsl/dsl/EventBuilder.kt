package net.dfplots.dfscript_dsl.dsl

sealed class BaseEvent
object KeyPressEvent : BaseEvent()
object SendChatEvent : BaseEvent()
object ReceiveChatEvent : BaseEvent()
object MenuClickButtonEvent : BaseEvent()
object ReceiveSoundEvent : BaseEvent()

class EventBuilder<out T: BaseEvent> (
    val name: String,
    val actions: MutableList<Block> = mutableListOf()
): ActionReceiver {
    override fun addBlock(block: Block) {
        actions += block
    }
}