package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.JsonActionOrEvent

class EventBuilder (
    val name: String,
    val actions: MutableList<BuilderBlock> = mutableListOf()
): ActionReceiver, BuilderBlock {
    override fun toSerializable(): List<JsonActionOrEvent> {
        // an event is really just an action - create a new list headed by this
//        return listOf(JsonEvent(name)) + actions
        TODO("Not yet implemented")
    }

    override fun addBlock(block: BuilderBlock) {
        actions += block
    }
}