package dev.sleepy_evelyn.territorial.neoforge;

import dev.sleepy_evelyn.territorial.neoforge.registry.TerritorialNeoForgeObjects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class TerritorialPlatformImpl {

    public static void addToCreativeTab(Supplier<Item> itemSupplier) {
        TerritorialNeoForgeObjects.CREATIVE_TAB_ITEMS.add(itemSupplier);
    }
}
