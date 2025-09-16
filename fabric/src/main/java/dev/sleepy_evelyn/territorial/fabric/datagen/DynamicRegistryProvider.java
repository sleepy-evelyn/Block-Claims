package dev.sleepy_evelyn.territorial.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.damagesource.*;
import org.jetbrains.annotations.NotNull;

import static dev.sleepy_evelyn.territorial.registry.dynamic.TerritorialDamageSources.OBSERVED_DAMAGE_TYPE;
import static dev.sleepy_evelyn.territorial.util.LangUtils.langKey;

import java.util.concurrent.CompletableFuture;

class DynamicRegistryProvider extends FabricDynamicRegistryProvider {

    DynamicRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        addDamageTypes(entries);
    }

    private void addDamageTypes(Entries entries) {
        entries.add(OBSERVED_DAMAGE_TYPE, new DamageType(langKey(OBSERVED_DAMAGE_TYPE),
                DamageScaling.NEVER, 0.1F));
    }

    @Override
    public @NotNull String getName() {
        return "territorial_pack";
    }
}
