package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.Territorial;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class DatapackKeys {

    public static DatapackKeys INSTANCE = new DatapackKeys();

    public final ResourceKey<DamageType> OBSERVED_DAMAGE_TYPE =
            ResourceKey.create(Registries.DAMAGE_TYPE, Territorial.id("observed"));

    public void init() {}
}
