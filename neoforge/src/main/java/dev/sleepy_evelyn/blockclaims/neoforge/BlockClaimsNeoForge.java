package dev.sleepy_evelyn.blockclaims.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import dev.sleepy_evelyn.blockclaims.BlockClaims;

@Mod(BlockClaims.MOD_ID)
public final class BlockClaimsNeoForge {
    public BlockClaimsNeoForge(IEventBus modBus) {
        // Run our common setup
        BlockClaims.init();
    }
}
