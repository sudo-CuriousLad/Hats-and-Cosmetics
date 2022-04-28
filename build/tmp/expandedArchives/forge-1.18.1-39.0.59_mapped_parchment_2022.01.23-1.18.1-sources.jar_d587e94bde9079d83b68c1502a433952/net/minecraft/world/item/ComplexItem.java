package net.minecraft.world.item;

import javax.annotation.Nullable;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ComplexItem extends Item {
   public ComplexItem(Item.Properties p_40743_) {
      super(p_40743_);
   }

   /**
    * Returns {@code true} if this is a complex item.
    */
   public boolean isComplex() {
      return true;
   }

   @Nullable
   public Packet<?> getUpdatePacket(ItemStack pStack, Level pLevel, Player pPlayer) {
      return null;
   }
}