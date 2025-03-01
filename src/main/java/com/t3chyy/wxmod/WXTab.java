package com.t3chyy.wxmod;

import com.t3chyy.wxmod.init.ModRadios;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WXTab {
    public static final CreativeModeTab WX_TAB = new CreativeModeTab("wxmod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModRadios.MIDLAND_WR100.get());
        }
    };
}
