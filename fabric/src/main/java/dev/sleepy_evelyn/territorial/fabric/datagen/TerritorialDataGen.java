package dev.sleepy_evelyn.territorial.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TerritorialDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        var pack = generator.createPack();
        // Language providers
        pack.addProvider(EnUsLangProvider::new);
        // Tags
        pack.addProvider(TagProviders.BlockTags::new);
        pack.addProvider(TagProviders.ItemTags::new);
        // Loot Tables
        pack.addProvider(BlockLootTableProvider::new);
        // Datapack provider
        pack.addProvider(DynamicRegistryProvider::new);
    }
}
