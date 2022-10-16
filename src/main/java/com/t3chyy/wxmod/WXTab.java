package com.t3chyy.wxmod;

import com.t3chyy.wxmod.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class WXTab {
    public static final CreativeModeTab WX_TAB = new CreativeModeTab("wxmod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.MIDLAND_WR100.get());
        }
    };
}
