package dev.sleepy_evelyn.territorial.neoforge.client;

import dev.sleepy_evelyn.blockclaims.Territorial;
import dev.sleepy_evelyn.blockclaims.client.TerritorialClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

public final class TerritorialNeoForgeClient {
    public TerritorialNeoForgeClient(IEventBus modBus) {
        TerritorialClient.init();
    }
}
