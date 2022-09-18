package com.curiouslad.hat.util

import com.curiouslad.hat.trinkets.GupTrinket
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object HatRegistry {

    fun registerItem(name: String, item: Item){
        Registry.register(Registry.ITEM, HatHelper().locate(name), item)
    }

    fun register() {
        registerItem("gup", GupTrinket())
    }
}