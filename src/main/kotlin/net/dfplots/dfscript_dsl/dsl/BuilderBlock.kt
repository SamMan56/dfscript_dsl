package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.JsonAction
import net.dfplots.dfscript_dsl.json.JsonActionOrEvent

interface BuilderBlock {
    fun toSerializable(): List<JsonActionOrEvent>
}

class ConditionalBlock(
    var mainBranch: List<BuilderBlock> = listOf(),
    var elseBranch: List<BuilderBlock> = listOf()
): BuilderBlock {
    override fun toSerializable(): List<JsonActionOrEvent> {
        TODO("Not yet implemented")
    }
}

class ActionBlock(val name: String, vararg val arguments: Value<AnyType>) : BuilderBlock {
    override fun toSerializable(): List<JsonActionOrEvent> {
        return listOf(JsonAction(name, arguments.map { it.toSerializable() }))
    }
}