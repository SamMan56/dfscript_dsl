package net.dfplots.dfscript_dsl.dsl

@DslMarker
annotation class DFScriptDSL

@DFScriptDSL
interface ActionReceiver {
    fun addBlock(block: Block)

    fun addAction(name: String, vararg arguments: Value<AnyType>) {
        addBlock(ActionBlock(name, *arguments))
    }
}