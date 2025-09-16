package dev.sleepy_evelyn.territorial.fabric;

import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public class TerritorialPlatformImpl {

    public static void addToCreativeTab(Supplier<Item> item) {
        ItemGroupEvents.modifyEntriesEvent(TerritorialItems.CREATIVE_TAB_KEY)
                .register(entries -> entries.accept(item.get()));
    }
}
