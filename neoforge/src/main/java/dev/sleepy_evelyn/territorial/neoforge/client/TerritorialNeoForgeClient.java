package dev.sleepy_evelyn.territorial.neoforge.client;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.client.TerritorialClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Territorial.MOD_ID, dist = Dist.CLIENT)
public final class TerritorialNeoForgeClient {

    public TerritorialNeoForgeClient(IEventBus modBus) {
        TerritorialClient.init();
    }
}
