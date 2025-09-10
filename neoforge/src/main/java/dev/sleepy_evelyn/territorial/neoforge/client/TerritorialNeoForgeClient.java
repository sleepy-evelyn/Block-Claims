package dev.sleepy_evelyn.territorial.neoforge.client;

import dev.sleepy_evelyn.territorial.client.TerritorialClient;
import net.neoforged.bus.api.IEventBus;

public final class TerritorialNeoForgeClient {
    public TerritorialNeoForgeClient(IEventBus modBus) {
        TerritorialClient.init();
    }
}
