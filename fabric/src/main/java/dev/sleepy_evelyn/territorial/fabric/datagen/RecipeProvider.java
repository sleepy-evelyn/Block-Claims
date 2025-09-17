package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import dev.sleepy_evelyn.territorial.registry.TerritorialTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

class RecipeProvider extends FabricRecipeProvider {

    public RecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        // Omniscient Obsidian recipe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TerritorialBlocks.INSTANCE.OMNISCIENT_OBSIDIAN.get())
                .requires(Blocks.CRYING_OBSIDIAN)
                .requires(Blocks.PLAYER_HEAD)
                .requires(TerritorialTags.XP_ITEMS)
                .unlockedBy(FabricRecipeProvider.getHasName(Blocks.CRYING_OBSIDIAN),
                        FabricRecipeProvider.has(Blocks.CRYING_OBSIDIAN))
                .unlockedBy(FabricRecipeProvider.getHasName(Blocks.PLAYER_HEAD),
                        FabricRecipeProvider.has(Blocks.PLAYER_HEAD))
                .save(exporter);
    }
}
