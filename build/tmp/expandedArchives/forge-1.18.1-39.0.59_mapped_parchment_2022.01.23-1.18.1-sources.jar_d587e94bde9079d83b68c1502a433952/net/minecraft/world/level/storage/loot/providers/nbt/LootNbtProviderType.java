package net.minecraft.world.level.storage.loot.providers.nbt;

import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.SerializerType;

/**
 * The SerializerType for {@link NbtProvider}.
 */
public class LootNbtProviderType extends SerializerType<NbtProvider> {
   public LootNbtProviderType(Serializer<? extends NbtProvider> p_165621_) {
      super(p_165621_);
   }
}