package com.t3chyy.wxmod;

import com.mojang.logging.LogUtils;
import com.t3chyy.wxmod.init.ModRadios;
import com.t3chyy.wxmod.init.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/*
    -----The Weather Radio Mod (WXmod)-----
    Created by t3chyy

    https://github.com/t3chyy/WeatherRadioMod
    https://twitter.com/t3chyyofficial

  ~ The v1.1 update was created to make the mod feel more complete for not only myself but for
    everyone.

    First created: October 19th, 2022
    Last updated: May 6th, 2023
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(eventBus);
        ModRadios.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("WXmod v2 by t3chyy, the final iteration");
        LOGGER.info("#t3chyyiscool");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        //register render type
        //this is awful to look at
        ItemBlockRenderTypes.setRenderLayer(ModRadios.MIDLAND_WR100.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.MIDLAND_WR100BNS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.MIDLAND_WR300.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.MIDLAND_WR400.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.MIDLAND_WR301.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.MIDLAND_WR120.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.MIDLAND_WR120_LEGACY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.UNIDEN_WX100.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.UNIDEN_WX500.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.SANGEAN_CL100.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.MIDLAND_WR300_V0.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModRadios.REECOM_R1630.get(), RenderType.translucent());
    }
}
