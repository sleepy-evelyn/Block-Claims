package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.registry.DatapackKeys;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

import java.util.concurrent.CompletableFuture;

class DynamicRegistryProvider extends FabricDynamicRegistryProvider {

    private final DatapackKeys datapackKeys;

    DynamicRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
        this.datapackKeys = DatapackKeys.INSTANCE;
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.add(Registries.DAMAGE_TYPE.registryKey(),
                new DamageType(datapackKeys.OBSERVED_DAMAGE_TYPE.toString(), DamageScaling.NEVER, 0.1f)
        );
    }

    @Override
    public String getName() {
        return "territorial_datapack";
    }
}
