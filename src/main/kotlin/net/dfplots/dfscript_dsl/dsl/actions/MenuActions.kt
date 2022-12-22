package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*

fun ActionReceiver.openMenu(width: Value<NumberType>, height: Value<NumberType>) {
    addAction("OPEN_MENU", width, height)
}

/**
 * Adds a button to an open custom menu.
 */
fun ActionReceiver.addMenuButton(
    x: Value<NumberType>,
    y: Value<NumberType>,
    width: Value<NumberType>,
    height: Value<NumberType>,
    text: Value<TextType>,
    identifier: Value<TextType>
) {
    addAction("ADD_MENU_BUTTON", x, y, width, height, text, identifier)
}


/**
 * Adds text to an open custom menu.
 */
fun ActionReceiver.addMenuText(
    x: Value<NumberType>,
    y: Value<NumberType>,
    text: Value<TextType>,
    identifier: Value<TextType>
) {
    addAction("ADD_MENU_TEXT", x, y, text, identifier)
}


/**
 * Adds a text field to an open custom menu.
 */
fun ActionReceiver.addMenuTextField(
    x: Value<NumberType>,
    y: Value<NumberType>,
    width: Value<NumberType>,
    height: Value<NumberType>,
    identifier: Value<TextType>
) {
    addAction("ADD_MENU_TEXT_FIELD", x, y, width, height, identifier)
}

/**
 * Removes an element from an open custom menu.
 */
fun ActionReceiver.removeMenuElement(identifier: Value<TextType>) {
    addAction("REMOVE_MENU_ELEMENT", identifier)
}

/**
 * Gets the text inside a text field in an open custom menu.
 */
fun ActionReceiver.getMenuTextFieldValue(result: VariableValue<TextType>, identifier: Value<TextType>) {
    addAction("GET_MENU_TEXT_FIELD_VALUE", result, identifier)
}

/**
 * Gets the text inside a text field in an open custom menu.
 */
fun ActionReceiver.setMenuTextFieldValue(identifier: Value<TextType>, value: Value<TextType>) {
    addAction("SET_MENU_TEXT_FIELD_VALUE", identifier, value)
}

