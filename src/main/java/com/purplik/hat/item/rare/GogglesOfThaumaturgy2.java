package com.purplik.hat.item.rare;

import com.purplik.hat.HatTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GogglesOfThaumaturgy2 extends Item {

    public GogglesOfThaumaturgy2(Properties pProperties) {
        super(pProperties.tab(HatTab.COSMETICS_TAB).stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.hat.goggles_of_thaumaturgy_2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.hat.rare.tooltip"));
    }

}
