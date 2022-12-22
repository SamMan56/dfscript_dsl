package net.dfplots.dfscript_dsl.dsl

fun ActionReceiver.`if`(build: ConditionalBuilder.() -> Double): ConditionalStarter {
    val conditionalBuilder = ConditionalBuilder(this)
    conditionalBuilder.build()
    val conditionalBlock = ConditionalBlock()
    val innerBuilder = InnerConditionalBuilder(conditionalBlock)
    addBlock(conditionalBlock)
    return ConditionalStarter(innerBuilder)
}

@DFScriptDSL
class ConditionalBuilder(val actionReceiver: ActionReceiver)

class InnerConditionalBuilder(
    private val block: ConditionalBlock,
    private var isInMainBranch: Boolean = true
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
    fun else_if(build: ConditionalBuilder.() -> Unit): ConditionalStarter {
        builder.swapBranch()
        val conditionalBuilder = ConditionalBuilder(builder)
        conditionalBuilder.build()
        val conditionalBlock = ConditionalBlock()
        val innerBuilder = InnerConditionalBuilder(conditionalBlock)
        builder.addBlock(conditionalBlock)
        return ConditionalStarter(innerBuilder)
    }

    fun `else`(build: InnerConditionalBuilder.() -> Unit) {
        builder.swapBranch()
        builder.build()
    }
}