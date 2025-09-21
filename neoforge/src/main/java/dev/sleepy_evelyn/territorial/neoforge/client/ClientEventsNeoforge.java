package dev.sleepy_evelyn.territorial.neoforge.client;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.client.TerritorialColourProviders;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = Territorial.MOD_ID, value = Dist.CLIENT)
public final class ClientEventsNeoforge {

    @SubscribeEvent
    public static void onRegisterColourHandlers(RegisterColorHandlersEvent.Item e) {
        for (var itemColourProviderEntry : TerritorialColourProviders.ITEM_COLOURS_MAP.entrySet()) {
            var itemColourProvider = itemColourProviderEntry.getKey();
            var itemSuppliers = itemColourProviderEntry.getValue();

            for (var itemSupplier : itemSuppliers)
                e.register(itemColourProvider, itemSupplier.get());
        }
    }
}
