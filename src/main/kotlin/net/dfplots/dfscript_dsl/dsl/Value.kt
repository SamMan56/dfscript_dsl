package net.dfplots.dfscript_dsl.dsl

import net.dfplots.dfscript_dsl.json.*

abstract class Value<out T: ValueType> {
    abstract fun toSerializable(): JsonValue

    /**
     * Any var type may be represented as text
     */
    fun asText(): Value<TextType> {
        return object: Value<TextType>() {
            override fun toSerializable(): JsonValue {
                return this@Value.toSerializable()
            }
        }
    }
}

// defining a variable requires a literal to be inputted
// since a list will ALWAYS be a variable
// so need a common superclass for things that CAN be represented as literals (directly in the json)
sealed class LiteralValue<T: ValueType>() : Value<T>()

class TextValue(val value: String) : LiteralValue<TextType>() {
    override fun toSerializable(): JsonValue {
        return JsonTextValue(value)
    }
}

class NumberValue(val value: Double) : LiteralValue<NumberType>() {
    override fun toSerializable(): JsonNumberValue {
        return JsonNumberValue(value)
    }
}

class ConfigValue<T: ValueType>(val name: String) : LiteralValue<T>() {
    override fun toSerializable(): JsonConfigValue {
        return JsonConfigValue(name)
    }
}

class ClientValue<T: ValueType>(val name: String) : LiteralValue<T>() {
    override fun toSerializable(): JsonClientValue {
        return JsonClientValue(name)
    }
}

class VariableValue<T: ValueType>(val name: String) : Value<T>() {
    override fun toSerializable(): JsonVariableValue {
        return JsonVariableValue(name)
    }
}

sealed class ValueType
typealias AnyType = ValueType // more clear
object TextType : ValueType()
object NumberType : ValueType()
// will try single typed lists - i don't think there are any particular requirements otherwise
class ListType<T: ValueType> : ValueType()
class DictionaryType<K: ValueType, V: ValueType> : ValueType()
