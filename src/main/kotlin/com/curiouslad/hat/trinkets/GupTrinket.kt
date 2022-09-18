package com.curiouslad.hat.trinkets

import com.curiouslad.hat.util.HatHelper
import dev.emi.trinkets.api.SlotReference
import dev.emi.trinkets.api.TrinketItem
import dev.emi.trinkets.api.client.TrinketRenderer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.MinecraftClient
import net.minecraft.client.item.TooltipContext
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.item.ItemRenderer
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Rarity
import net.minecraft.world.World

class GupTrinket :
    TrinketItem(FabricItemSettings().rarity(Rarity.EPIC)), TrinketRenderer {
    override fun render(
        stack: ItemStack?,
        slotReference: SlotReference?,
        contextModel: EntityModel<out LivingEntity>?,
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider?,
        light: Int,
        entity: LivingEntity?,
        limbAngle: Float,
        limbDistance: Float,
        tickDelta: Float,
        animationProgress: Float,
        headYaw: Float,
        headPitch: Float
    ) {
        val itemRenderer: ItemRenderer = MinecraftClient.getInstance().itemRenderer
        HatHelper().translateToFace(matrices, contextModel!!, entity!!, headYaw, headPitch)
        matrices.scale(-1f, -1f, -1f)
        matrices.translate(0.0, 0.7, 0.3)
        itemRenderer.renderItem(
            stack,
            ModelTransformation.Mode.FIXED,
            light,
            OverlayTexture.DEFAULT_UV,
            matrices,
            vertexConsumers,
            0
        );
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        super.appendTooltip(stack, world, tooltip, context)
        tooltip!!.add(Text.of("cringe"))
    }

}