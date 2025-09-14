package dev.sleepy_evelyn.territorial.fabric;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.fabric.events.CommonEventsFabric;
import net.fabricmc.api.ModInitializer;

public final class TerritorialFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Territorial.init();
        CommonEventsFabric.init();
    }
}
