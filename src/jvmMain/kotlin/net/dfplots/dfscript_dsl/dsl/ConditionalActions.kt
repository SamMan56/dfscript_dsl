package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.ScriptMarker

fun EventBuilder.`if`(build: ConditionalBuilder.() -> Unit): ConditionalResult {
    val conditionalBuilder = ConditionalBuilder(this)
    conditionalBuilder.build()
    return ConditionalResult(this, 0)
}

/**
 * Should never be used in scripts, will be added automatically
 */
fun EventBuilder.closeBracket() {
    addAction("CLOSE_BRACKET")
}

/**
 * this is a seperate dsl layer to keep if var conditions away from normal conditions
 */
@ScriptMarker
class ConditionalBuilder(val eventBuilder: EventBuilder) {
    // unfortunately, this cannot check if types are equal at compile time
    // since it will automatically assume anytype equality if unspecified
    fun<T: ValueType> equals(x: Value<T>, y: Value<T>) {
        eventBuilder.addAction("IF_EQUALS", x.toSerializable(), y.toSerializable())
    }

    /**
     * Checks if a text contains a value.
     */
    fun textContains(text: Value<TextType>, subtext: Value<TextType>) {
        eventBuilder.addAction("IF_TEXT_CONTAINS", text.toSerializable(), subtext.toSerializable())
    }
}

class ConditionalResult(val eventBuilder: EventBuilder, val depth: Int) {
    fun then(build: EventBuilder.() -> Unit): ConditionalThenResult {
        eventBuilder.build()
        // add as many brackets that are needed to close
        // there will be 1 plus extra for depth
        eventBuilder.closeBracket()
        (1..depth).forEach { _ -> eventBuilder.closeBracket() }

        return ConditionalThenResult(eventBuilder, depth)
    }
}

class ConditionalThenResult(val eventBuilder: EventBuilder, val depth: Int) {
    // on an else if, its now known this is NOT the end of iteration
    fun else_if(build: ConditionalBuilder.() -> Unit): ConditionalResult {
        // add else
        // condition code gen
        // condition inner
        // close bracket

        // its not the nicest idea however the issue is that the final then (or else) needs to print enough code brackets
        // i couldnt find a way to have the compiler run particular code depending on whether this IS the last condition in the block
        // so, a then will ALWAYS print enough brackets as if it is the final condition
        // if its not (like now), just remove all the unneeded brackets
        eventBuilder.popActions(depth)
        // this will now append to the last if
        eventBuilder.addAction("ELSE")
        eventBuilder.`if`(build)

        // now further down
        return ConditionalResult(eventBuilder, depth + 1)
    }

    fun `else`(build: EventBuilder.() -> Unit) {
        // remove unneeded brackets
        eventBuilder.popActions(depth)

        eventBuilder.addAction("ELSE")
        eventBuilder.build()
        // add enough to finish
        // these will not be removed
        eventBuilder.closeBracket()
        (1..depth).forEach { _ -> eventBuilder.closeBracket() }
    }
}