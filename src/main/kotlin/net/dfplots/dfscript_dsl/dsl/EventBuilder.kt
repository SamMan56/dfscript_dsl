package net.dfplots.dfscript_dsl.dsl

class EventBuilder (
    val name: String,
    val actions: MutableList<Block> = mutableListOf()
): ActionReceiver {
    override fun addBlock(block: Block) {
        actions += block
    }
}