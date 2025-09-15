package dev.sleepy_evelyn.territorial.fabric.client;

import dev.sleepy_evelyn.territorial.TerritorialClient;
import net.fabricmc.api.ClientModInitializer;

public final class TerritorialFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TerritorialClient.init();
    }
}
