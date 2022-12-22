package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.JsonAction
import net.dfplots.dfscript_dsl.json.JsonActionOrEvent

sealed interface Block {
    fun toSerializable(): List<JsonActionOrEvent>
}

fun List<Block>.toSerializable(): List<JsonActionOrEvent> {
    return flatMap { it.toSerializable() }
}

class ConditionalBlock(
    var mainBranch: List<Block> = listOf(),
    var elseBranch: List<Block> = listOf()
): Block {
    override fun toSerializable(): List<JsonActionOrEvent> {
        return if (elseBranch.isEmpty()) { // if no need for else
            mainBranch.toSerializable() + listOf(JsonAction("CLOSE_BRACKET", listOf()))
        } else {
            mainBranch.toSerializable() +
                    listOf(
                        JsonAction("CLOSE_BRACKET", listOf()),
                        JsonAction("ELSE", listOf())
                    ) +
                    elseBranch.toSerializable() +
                    listOf(JsonAction("CLOSE_BRACKET", listOf()))
        }
    }
}

class ActionBlock(val name: String, vararg val arguments: Value<AnyType>) : Block {
    override fun toSerializable(): List<JsonActionOrEvent> {
        return listOf(JsonAction(name, arguments.map { it.toSerializable() }))
    }
}

class FlipBlock(
    val name: String,
    val otherName: String,
    vararg val arguments: Value<AnyType>,
    var flipped: Boolean = false
): Block {
    fun not() {
        flipped = true
    }

    override fun toSerializable(): List<JsonActionOrEvent> {
        return listOf(JsonAction(if (!flipped) name else otherName, arguments.map { it.toSerializable() }))
    }
}