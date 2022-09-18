package com.curiouslad.hat.util

import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.PlayerEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.LivingEntity
import net.minecraft.util.Identifier
import net.minecraft.util.math.Vec3f


class HatHelper {
    val MOD_ID = "hat"
    fun locate(name: String): Identifier {
        return Identifier(MOD_ID, name)
    }

    fun translateToFace(
        matrices: MatrixStack, model: EntityModel<out LivingEntity?>,
        entity: LivingEntity, headYaw: Float, headPitch: Float
    ) {
        if (entity.isInSwimmingPose || entity.isFallFlying) {
            if (model is PlayerEntityModel<*>) {

                matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(model.head.roll))
            }
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(headYaw))
            matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-45.0f))
        } else {
            if (entity.isInSneakingPose && !model.riding) {
                matrices.translate(0.0, 0.25, 0.0)
            }
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(headYaw))
            matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(headPitch))
        }
        matrices.translate(0.0, -0.25, -0.3)
    }
}