package dev.sleepy_evelyn.territorial.fabric;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.fabric.events.CommonEventsFabric;
import dev.sleepy_evelyn.territorial.fabric.registry.TerritorialFabricObjects;
import net.fabricmc.api.ModInitializer;

public final class TerritorialFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Territorial.init();
        CommonEventsFabric.init();
        // Register creative mode tab
        TerritorialFabricObjects.registerAll();
    }
}
