package net.dfplots.dfscript_dsl.dsl.actions

import net.dfplots.dfscript_dsl.dsl.*

/**
 * Sets a hotbar item. (Requires Creative)
 */
fun ActionReceiver.setHotbarItem(slot: Value<NumberType>, item: Value<ItemType>) {
    addAction("SET_HOTBAR_ITEM", slot, item)
}

/**
 * Gives the player an item. (Requires Creative)
 */
fun ActionReceiver.giveItem(item: Value<ItemType>) {
    addAction("GIVE_ITEM", item)
}

