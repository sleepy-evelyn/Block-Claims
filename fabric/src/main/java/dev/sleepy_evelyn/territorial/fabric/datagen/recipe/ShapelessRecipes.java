package dev.sleepy_evelyn.territorial.fabric.datagen.recipe;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.compat.Mods;
import dev.sleepy_evelyn.territorial.fabric.datagen.recipe.builders.ShapelessRecipesBuilder;
import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import dev.sleepy_evelyn.territorial.registry.TerritorialTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static dev.sleepy_evelyn.territorial.Territorial.commonId;
import static dev.sleepy_evelyn.territorial.registry.TerritorialBlocks.BLOCKS;
import static dev.sleepy_evelyn.territorial.registry.TerritorialItems.ITEMS;

public class ShapelessRecipes extends FabricRecipeProvider {

    public ShapelessRecipes(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        var recipesBuilder = new ShapelessRecipesBuilder(exporter);

        // Omniscient Obsidian
        recipesBuilder.startNew(BLOCKS.OMNISCIENT_OBSIDIAN.get(), 1)
                .requires(Blocks.CRYING_OBSIDIAN, Blocks.PLAYER_HEAD)
                .requires(TerritorialTags.XP_ITEMS)
                .unlockedByInputs(BLOCKS.OMNISCIENT_OBSIDIAN.get());

        // Gloop Ball
        recipesBuilder.startNew(ITEMS.GLOOP_BALL.get(), 1)
                .requires(Items.FERMENTED_SPIDER_EYE)
                .requires(Items.MAGMA_CREAM)
                .unlockedByInputs(Items.FERMENTED_SPIDER_EYE, Items.MAGMA_CREAM);

        recipesBuilder.saveAll();
    }

    @Override
    public @NotNull String getName() {
        return Territorial.MOD_NAME + " Shapeless Recipes Provider";
    }
}
