package com.t3chyy.wxmod.block;

import com.t3chyy.wxmod.WXMod;
import com.t3chyy.wxmod.WXTab;
import com.t3chyy.wxmod.block.radios.*;
import com.t3chyy.wxmod.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WXMod.MOD_ID);

    /*
        Registering the radios here
        Goes in chronological order
     */

    //MIDLAND
    public static final RegistryObject<Block> MIDLAND_WR100 = registerBlock("midland_wr100",
            () -> new WR100(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion().instabreak()), WXTab.WX_TAB,
            "tooltip.wxmod.block.midland_wr100");

    public static final RegistryObject<Block> MIDLAND_WR100BNS = registerBlock("midland_wr100bns",
            () -> new BNSWR100(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion().instabreak()), WXTab.WX_TAB,
            "tooltip.wxmod.block.midland_wr100bns");

    public static final RegistryObject<Block> MIDLAND_WR300 = registerBlock("midland_wr300",
            () -> new MidlandWR300(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion().instabreak()), WXTab.WX_TAB,
            "tooltip.wxmod.block.midland_wr300");

    public static final RegistryObject<Block> MIDLAND_WR301 = registerBlock("midland_wr301",
            () -> new MidlandWR301(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion().instabreak()), WXTab.WX_TAB,
            "tooltip.wxmod.block.midland_wr301");

    public static final RegistryObject<Block> MIDLAND_WR300_V0 = registerBlock("midland_wr300_v0",
            () -> new MidlandWR300V0(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion().instabreak()), WXTab.WX_TAB,
            "tooltip.wxmod.block.midland_wr300_v0");


    //UNIDEN
    public static final RegistryObject<Block> UNIDEN_WX100 = registerBlock("uniden_wx100",
            () -> new UnidenWX100(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion().instabreak()), WXTab.WX_TAB,
            "tooltip.wxmod.block.uniden_wx100");

    public static final RegistryObject<Block> UNIDEN_WX500 = registerBlock("uniden_wx500",
            () -> new UnidenWX500(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion().instabreak()), WXTab.WX_TAB,
            "tooltip.wxmod.block.uniden_wx500");


    //SANGEAN
    public static final RegistryObject<Block> SANGEAN_CL100 = registerBlock("sangean_cl100",
            () -> new SangeanCL100(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion().instabreak()), WXTab.WX_TAB,
            "tooltip.wxmod.block.sangean_cl100");

    //------------------

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab).stacksTo(1)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                if(Screen.hasShiftDown()) {
                    pTooltip.add(new TranslatableComponent(tooltipKey));
                } else {
                    pTooltip.add(new TranslatableComponent("tooltip.shift"));
                }
            }
        });

    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
