package dev.sleepy_evelyn.blockclaims;

import dev.sleepy_evelyn.blockclaims.registry.ObjectsRegistry;
import net.minecraft.resources.ResourceLocation;

public final class BlockClaims {
    public static final String MOD_ID = "blockclaims";

    public static void init() {
        ObjectsRegistry.init();
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
