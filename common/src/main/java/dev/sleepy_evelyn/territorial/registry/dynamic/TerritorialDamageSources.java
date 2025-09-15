package dev.sleepy_evelyn.territorial.registry.dynamic;

import dev.sleepy_evelyn.territorial.Territorial;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class TerritorialDamageSources {

    public static final ResourceKey<DamageType> OBSERVED_DAMAGE_TYPE =
            ResourceKey.create(Registries.DAMAGE_TYPE, Territorial.id("observed"));

    public static DamageSource observed(Level level) {
        return TerritorialDamageSources.create(level, OBSERVED_DAMAGE_TYPE);
    }

    private static DamageSource create(Level level, ResourceKey<DamageType> key) {
        return create(level, key, null, null);
    }

    public static DamageSource create(Level level, ResourceKey<DamageType> key, @Nullable Entity source, @Nullable Entity attacker) {
        return level.registryAccess()
                .registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolder(key)
                .map((type) -> new DamageSource(type, source, attacker))
                .orElse(level.damageSources().generic()); // Fallback, should never reach this
    }
}
