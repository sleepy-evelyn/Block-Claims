package dev.sleepy_evelyn.territorial.fabric;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.fabric.events.CommonEventsFabric;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static dev.sleepy_evelyn.territorial.registry.TerritorialItems.CREATIVE_TAB_KEY;

public final class TerritorialFabric implements ModInitializer {

    private static final CreativeModeTab CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(TerritorialBlocks.INSTANCE.OMNISCIENT_OBSIDIAN.get()))
            .title(Component.translatable("creative_tab." + Territorial.MOD_ID))
            .build();

    @Override
    public void onInitialize() {
        Territorial.init();
        CommonEventsFabric.init();
        // Register creative mode tab
        Registry.registerForHolder(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_TAB_KEY, CREATIVE_TAB);
    }
}
