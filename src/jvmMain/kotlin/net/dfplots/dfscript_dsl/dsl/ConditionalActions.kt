package net.dfplots.dfscript_dsl.dsl

fun EventBuilder.`if`(build: ConditionalBuilder.() -> Unit): ConditionalResult {
    val conditionalBuilder = ConditionalBuilder(this)
    conditionalBuilder.build()
    return ConditionalResult(this)
}

/**
 * this is a seperate dsl layer to keep if var conditions away from normal conditions
 */
class ConditionalBuilder(val eventBuilder: EventBuilder) {
    fun<T: ValueType> equals(x: Value<T>, y: Value<T>) {
        eventBuilder.add_action("IF_EQUALS", x.toSerializable(), y.toSerializable())
    }
}

class ConditionalResult(val eventBuilder: EventBuilder) {
    fun then(build: EventBuilder.() -> Unit): ConditionalThenResult {
        eventBuilder.build()
        eventBuilder.add_action("CLOSE_BRACKET")
        return ConditionalThenResult(eventBuilder)
    }
}

class ConditionalThenResult(val eventBuilder: EventBuilder) {
    // i couldnt find a clean implementation for this due to the way its structured right now
    // ie else_if only has a condition but needs to add a bracket far later
//    fun else_if(build: ConditionalBuilder.() -> Unit): ConditionalResult {
//        // add else
//        // condition code gen
//        // condition inner
//        // close bracket
//        eventBuilder.add_action("ELSE")
//        eventBuilder.`if`(buildbuild)
//        return ConditionalResult(eventBuilder)
//    }

    fun `else`(build: EventBuilder.() -> Unit) {
        eventBuilder.add_action("ELSE")
        eventBuilder.build()
        eventBuilder.add_action("CLOSE_BRACKET")
    }
}