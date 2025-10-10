package dev.sleepy_evelyn.territorial.fabric.client;

import dev.sleepy_evelyn.territorial.client.TerritorialColourProviders;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class ClientEventsFabric {

    public static void init() {
        for (var itemColourProviderEntry : TerritorialColourProviders.ITEM_COLOURS_MAP.entrySet()) {
            var itemColourProvider = itemColourProviderEntry.getKey();
            var itemSuppliers = itemColourProviderEntry.getValue();

            for (var itemSupplier : itemSuppliers)
                ColorProviderRegistry.ITEM.register(itemColourProvider, itemSupplier.get());
        }
    }
}
