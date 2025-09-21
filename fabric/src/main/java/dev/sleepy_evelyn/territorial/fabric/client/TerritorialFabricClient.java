package dev.sleepy_evelyn.territorial.fabric.client;

import dev.sleepy_evelyn.territorial.client.TerritorialClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public final class TerritorialFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TerritorialClient.init();
        ClientEventsFabric.init();
    }
}
