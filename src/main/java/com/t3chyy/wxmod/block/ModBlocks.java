package com.t3chyy.wxmod.block;

import com.t3chyy.wxmod.WXMod;
import com.t3chyy.wxmod.WXTab;
import com.t3chyy.wxmod.block.radios.*;
import com.t3chyy.wxmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WXMod.MOD_ID);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    //Register blocks
    public static final RegistryObject<Block> MIDLAND_WR100 = registerBlock("midland_wr100",
            () -> new WR100(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion()), WXTab.WX_TAB);

    public static final RegistryObject<Block> MIDLAND_WR100BNS = registerBlock("midland_wr100bns",
            () -> new BNSWR100(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion()), WXTab.WX_TAB);

    public static final RegistryObject<Block> UNIDEN_WX100 = registerBlock("uniden_wx100",
            () -> new UnidenWX100(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion()), WXTab.WX_TAB);


    //------------------

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
