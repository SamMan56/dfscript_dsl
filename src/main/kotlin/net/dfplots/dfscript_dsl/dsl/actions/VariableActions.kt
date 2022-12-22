package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.ActionReceiver
import net.dfplots.dfscript_dsl.dsl.Value
import net.dfplots.dfscript_dsl.dsl.ValueType
import net.dfplots.dfscript_dsl.dsl.VariableValue


fun <T: ValueType> ActionReceiver.setVariable(variable: VariableValue<T>, value: Value<T>) {
    addAction("SET_VARIABLE", variable, value)
}