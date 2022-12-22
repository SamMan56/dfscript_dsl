package net.dfplots.dfscript_dsl.dsl

fun ActionReceiver.`if`(build: ConditionalBuilder.() -> Condition): ConditionalStarter {
    val conditionalBlock = ConditionalBlock()
    val innerBuilder = InnerConditionalBuilder(conditionalBlock)
    val conditionalBuilder = ConditionalBuilder(this, innerBuilder)
    conditionalBuilder.build()
    addBlock(conditionalBlock)
    return ConditionalStarter(innerBuilder)
}

@DFScriptDSL
class ConditionalBuilder(val actionReceiver: ActionReceiver, val innerBuilder: InnerConditionalBuilder)

sealed class Condition {
    abstract operator fun not(): Condition
}
class NullableCondition(val flipBlock: FlipBlock) : Condition() {
    override fun not(): NullableCondition {
        flipBlock.flipped = !flipBlock.flipped
        return NullableCondition(flipBlock)
    }
}

class NonNullableCondition(val innerBuilder: InnerConditionalBuilder) : Condition() {
    override fun not(): NonNullableCondition {
        innerBuilder.isInMainBranch = !innerBuilder.isInMainBranch
        return NonNullableCondition(innerBuilder)
    }
}

class InnerConditionalBuilder(
    private val block: ConditionalBlock,
    var isInMainBranch: Boolean = true
) : ActionReceiver {
    override fun addAction(name: String, vararg arguments: Value<AnyType>) {
        addBlock(ActionBlock(name, *arguments))
    }

    override fun addBlock(block: Block) {
        if (isInMainBranch)
            this.block.mainBranch += block
        else
            this.block.elseBranch += block
    }

    fun swapBranch() {
        isInMainBranch = !isInMainBranch // may already be negated
    }
}

class ConditionalStarter(private val builder: InnerConditionalBuilder) {
    fun then(build: InnerConditionalBuilder.() -> Unit): ConditionalResult {
        builder.build()
        return ConditionalResult(builder)
    }
}

class ConditionalResult(private val builder: InnerConditionalBuilder) {
    fun else_if(build: ConditionalBuilder.() -> Condition): ConditionalStarter {
        builder.swapBranch()
        val conditionalBlock = ConditionalBlock()
        val innerBuilder = InnerConditionalBuilder(conditionalBlock)
        val conditionalBuilder = ConditionalBuilder(builder, innerBuilder)
        conditionalBuilder.build()
        builder.addBlock(conditionalBlock)
        return ConditionalStarter(innerBuilder)
    }

    fun `else`(build: InnerConditionalBuilder.() -> Unit) {
        builder.swapBranch()
        builder.build()
    }
}