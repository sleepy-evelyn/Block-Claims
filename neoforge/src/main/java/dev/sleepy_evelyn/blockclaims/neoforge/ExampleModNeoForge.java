package dev.sleepy_evelyn.blockclaims.neoforge;

import net.neoforged.fml.common.Mod;

import dev.sleepy_evelyn.blockclaims.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
