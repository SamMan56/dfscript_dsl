package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.*

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

class ConfigValue<T: ValueType>(val name: String) : Value<T>() {
    override fun toSerializable(): JsonConfigValue {
        return JsonConfigValue(name)
    }
}

class ClientValue<T: ValueType>(val name: String) : Value<T>() {
    override fun toSerializable(): JsonClientValue {
        return JsonClientValue(name)
    }
}

sealed class ValueType
object TextType : ValueType()
object NumberType : ValueType()
// will try single typed lists - i don't think there are any particular requirements otherwise
class ListType<T: ValueType> : ValueType()
class DictType<K: ValueType, V: ValueType> : ValueType()