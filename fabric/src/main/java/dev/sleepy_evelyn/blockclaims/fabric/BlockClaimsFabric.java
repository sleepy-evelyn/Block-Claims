package dev.sleepy_evelyn.blockclaims.fabric;

import net.fabricmc.api.ModInitializer;

import dev.sleepy_evelyn.blockclaims.BlockClaims;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.network.chat.Component;

public final class BlockClaimsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        BlockClaims.init();
    }
}
