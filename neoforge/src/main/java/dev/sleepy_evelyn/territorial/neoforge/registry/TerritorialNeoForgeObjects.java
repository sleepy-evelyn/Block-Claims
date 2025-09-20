package dev.sleepy_evelyn.territorial.neoforge.registry;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TerritorialNeoForgeObjects {

    private static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(
            BuiltInRegistries.CREATIVE_MODE_TAB, Territorial.MOD_ID);

    public static final List<Supplier<Item>> CREATIVE_TAB_ITEMS = new ArrayList<>();

    private static final Supplier<CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register(
            "main", () -> CreativeModeTab.builder()
                    .title(Component.translatable("creative_tab." + Territorial.MOD_ID))
                    .icon(() -> new ItemStack(TerritorialBlocks.BLOCKS.OMNISCIENT_OBSIDIAN.get()))
                    .displayItems((params, output) -> CREATIVE_TAB_ITEMS.forEach(
                            itemSupplier -> output.accept(itemSupplier.get())))
                    .build()
    );

    public static void registerAll(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
