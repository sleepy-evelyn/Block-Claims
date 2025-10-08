package dev.sleepy_evelyn.territorial.fabric.client;

import dev.sleepy_evelyn.territorial.client.TerritorialClient;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.RenderType;

public final class TerritorialFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TerritorialClient.init();
        ClientEventsFabric.init();
    }
}
