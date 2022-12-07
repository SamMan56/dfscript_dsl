package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.JsonNumberValue
import net.dfplots.dfscript_dsl.json.JsonTextValue
import net.dfplots.dfscript_dsl.json.JsonValue
import net.dfplots.dfscript_dsl.json.JsonVariableValue

sealed class Value<T: ValueType> {
    abstract fun toSerializable(): JsonValue
}
class TextValue(val value: String) : Value<TextType>() {
    override fun toSerializable(): JsonValue {
        return JsonTextValue(value)
    }
}
class NumberValue(val value: Double) : Value<NumberType>() {
    override fun toSerializable(): JsonNumberValue {
        return JsonNumberValue(value)
    }
}
class VariableValue<T: ValueType>(val name: String) : Value<T>() {
    override fun toSerializable(): JsonVariableValue {
        return JsonVariableValue(name)
    }
}

sealed class ValueType
class TextType(val value: String) : ValueType()
class NumberType(val value: Double) : ValueType()