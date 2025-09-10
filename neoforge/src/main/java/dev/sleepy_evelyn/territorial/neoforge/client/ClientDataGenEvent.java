package dev.sleepy_evelyn.territorial.neoforge.client;

import dev.sleepy_evelyn.territorial.Territorial;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Territorial.MOD_ID)
public class ClientDataGenEvent {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        // Call event.createDatapackRegistryObjects(...) first if adding datapack objects
        event.createProvider(EnUsLangNeoForge::new);
    }
}
