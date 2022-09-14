package com.curiouslad.hat.util

import com.curiouslad.hat.Hat
import net.minecraft.util.Identifier

const val MOD_ID = "hat"

class HatHelper {
    fun locate(name: String): Identifier {
        return Identifier(MOD_ID, name)
    }
}