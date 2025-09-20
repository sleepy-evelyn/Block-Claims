package dev.sleepy_evelyn.territorial.fabric.registry;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static dev.sleepy_evelyn.territorial.registry.TerritorialItems.CREATIVE_TAB_KEY;

public class TerritorialFabricObjects {

    private static final CreativeModeTab CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(TerritorialBlocks.BLOCKS.OMNISCIENT_OBSIDIAN.get()))
            .title(Component.translatable("creative_tab." + Territorial.MOD_ID))
            .build();

    public static void registerAll() {
        Registry.registerForHolder(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_TAB_KEY, CREATIVE_TAB);
    }
}
