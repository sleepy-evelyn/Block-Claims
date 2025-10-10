package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.fabric.datagen.recipe.ShapedRecipes;
import dev.sleepy_evelyn.territorial.fabric.datagen.recipe.ShapelessRecipes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TerritorialDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        var pack = generator.createPack();

        pack.addProvider(EnUsLangProvider::new);
        pack.addProvider(TagProviders.BlockProvider::new);
        pack.addProvider(TagProviders.ItemProvider::new);
        pack.addProvider(BlockLootTableProvider::new);
        pack.addProvider(DynamicRegistryProvider::new);
        pack.addProvider(ShapelessRecipes::new);
        pack.addProvider(ShapedRecipes::new);
        pack.addProvider(ModelProvider::new);
    }
}
