package com.purplik.hat;

import com.purplik.hat.item.legendary.Gup;
import com.purplik.hat.model.legendarymodels.GupModel;
import com.purplik.hat.model.legendarymodels.TophatModel;
import com.purplik.hat.model.legendarymodels.UshankaModel;
import com.purplik.hat.model.raremodels.*;
import com.purplik.hat.renderer.*;
import com.purplik.hat.model.*;
import com.purplik.hat.renderer.legendaryrenderer.GupRenderer;
import com.purplik.hat.renderer.legendaryrenderer.TophatRenderer;
import com.purplik.hat.renderer.legendaryrenderer.UshankaRenderer;
import com.purplik.hat.renderer.rarerenderer.*;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod(Hat.MOD_ID)
public class Hat
{

    public static final String MOD_ID = "hat";

    public Hat() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registry.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::registerLayers);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        CuriosRendererRegistry.register(Registry.TOPHAT.get(), TophatRenderer::new);
        CuriosRendererRegistry.register(Registry.USHANKA.get(), UshankaRenderer::new);
        CuriosRendererRegistry.register(Registry.GUP.get(), GupRenderer::new);

        CuriosRendererRegistry.register(Registry.LABCOAT.get(), LabcoatRenderer::new);
        CuriosRendererRegistry.register(Registry.LAB_GOGGLES.get(), LabgogglesRenderer::new);
        CuriosRendererRegistry.register(Registry.GOGGLES_OF_THAUMATURGY.get(), GogglesOfThaumaturgyRenderer::new);
        CuriosRendererRegistry.register(Registry.BANDITS_HAT.get(), BanditsHatRenderer::new);
        //CuriosRendererRegistry.register(Registry.CAPTAINS_HAT.get(), CaptainsHatRenderer::new);

        CuriosRendererRegistry.register(Registry.ARMORERHAT.get(), () -> new VillagerHatRenderer("armorer"));
        CuriosRendererRegistry.register(Registry.BUTCHERHAT.get(), () -> new VillagerHatRenderer("butcher"));
        CuriosRendererRegistry.register(Registry.FARMERHAT.get(), () -> new VillagerHatRenderer("farmer"));
        CuriosRendererRegistry.register(Registry.FISHERHAT.get(), () -> new VillagerHatRenderer("fisherman"));
        CuriosRendererRegistry.register(Registry.FLETCHERHAT.get(), () -> new VillagerHatRenderer("fletcher"));

        CuriosRendererRegistry.register(Registry.ENGINEERS_HAT.get(), EngineersHatRenderer::new);
    }

    public void enqueueIMC(final InterModEnqueueEvent event) {

        SlotTypePreset[] slotTypes = {SlotTypePreset.HEAD, SlotTypePreset.BODY};

        for (SlotTypePreset slotType : slotTypes) {
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> slotType.getMessageBuilder().build());
        }

        /*
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("accessory").priority(220).build());
        */
    }

    private void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CosmeticLayerDefinitions.TOPHAT, TophatModel::createLayer);
        event.registerLayerDefinition(CosmeticLayerDefinitions.USHANKA, UshankaModel::createLayer);
        event.registerLayerDefinition(CosmeticLayerDefinitions.GUP, GupModel::createLayer);

        event.registerLayerDefinition(CosmeticLayerDefinitions.LABCOAT, LabcoatModel::createLayer);
        event.registerLayerDefinition(CosmeticLayerDefinitions.LAB_GOGGLES, LabgogglesModel::createLayer);
        event.registerLayerDefinition(CosmeticLayerDefinitions.GOGGLES_OF_THAUMATURGY, GogglesOfThaumaturgyModel::createLayer);
        event.registerLayerDefinition(CosmeticLayerDefinitions.BANDITS_HAT, BanditsHatModel::createLayer);
        event.registerLayerDefinition(CosmeticLayerDefinitions.CAPTAINS_HAT, CaptainsHatModel::createLayer);

        event.registerLayerDefinition(CosmeticLayerDefinitions.VILLAGER_HAT, VillagerHatTemplate::createLayer);

        event.registerLayerDefinition(CosmeticLayerDefinitions.ENGINEERS_HAT, EngineersHatModel::createLayer);

    }
}
