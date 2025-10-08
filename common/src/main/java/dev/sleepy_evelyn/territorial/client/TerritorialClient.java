package dev.sleepy_evelyn.territorial.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.DisplayRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.Display;

public class TerritorialClient {
    //public static TerritorialClientConfig config = ConfigApiJava.registerAndLoadConfig(TerritorialClientConfig::new, RegisterType.CLIENT);

    public static void init() {
        TerritorialColourProviders.init();
    }
}
