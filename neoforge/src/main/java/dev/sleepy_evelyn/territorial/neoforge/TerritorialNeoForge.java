package dev.sleepy_evelyn.territorial.neoforge;

import dev.sleepy_evelyn.blockclaims.Territorial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Territorial.MOD_ID)
public final class TerritorialNeoForge {
    public TerritorialNeoForge(IEventBus modBus) {
        // Run our common setup
        Territorial.init();
    }
}
