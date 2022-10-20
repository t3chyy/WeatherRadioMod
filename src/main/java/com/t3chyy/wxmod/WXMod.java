package com.t3chyy.wxmod;

import com.mojang.logging.LogUtils;
import com.t3chyy.wxmod.block.ModBlocks;
import com.t3chyy.wxmod.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/*
    -----The Weather Radio Mod (WXmod)-----
    Created by T3chyy

    https://github.com/T3chyyOfficial/WeatherRadioMod
    https://twitter.com/T3chyyOfficial

    October 19th, 2022
    ---------------------------------------
 */

@Mod(WXMod.MOD_ID)
public class WXMod
{
    public static final String MOD_ID = "wxmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public WXMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        //register render type
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIDLAND_WR100.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIDLAND_WR100BNS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIDLAND_WR300.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIDLAND_WR301.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.UNIDEN_WX100.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.UNIDEN_WX500.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SANGEAN_CL100.get(), RenderType.translucent());
    }
}
