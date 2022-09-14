package com.curiouslad.hat
import com.curiouslad.hat.util.HatHelper
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

@Suppress("UNUSED")
object Hat: ModInitializer {
    private const val MOD_ID = "hat"

    val COSMETICS_GROUP: ItemGroup = FabricItemGroupBuilder.build(HatHelper().locate("cosmetics_group"))
        { ItemStack(Items.SHIELD)}
    override fun onInitialize() {
        println("Example mod has been initialized.")
    }
}