package dev.sleepy_evelyn.territorial.fabric;

import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.Item;


public class TerritorialPlatformImpl {

    public static void addToCreativeTab(Item item) {
        ItemGroupEvents.modifyEntriesEvent(TerritorialItems.CREATIVE_TAB_KEY)
                .register(entries -> entries.accept(item));
    }
}
