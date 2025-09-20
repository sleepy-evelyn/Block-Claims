package dev.sleepy_evelyn.territorial.fabric.datagen.recipe;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.fabric.datagen.recipe.builders.ShapedRecipesBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static dev.sleepy_evelyn.territorial.registry.TerritorialBlocks.BLOCKS;
import static dev.sleepy_evelyn.territorial.registry.TerritorialItems.ITEMS;

public class ShapedRecipes extends FabricRecipeProvider {

    public ShapedRecipes(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        var recipesBuilder = new ShapedRecipesBuilder(exporter);

        // Claim Controller
        recipesBuilder.start(BLOCKS.CLAIM_CONTROLLER.get(), 1)
                .pattern(" E ", "GOG", "OOO")
                .define('E', ITEMS.AUGMENTED_EYE.get())
                .define('G', TagKey.create(Registries.ITEM, Territorial.commonId("ingots/gold")))
                .define('O', Blocks.OBSIDIAN)
                .unlockedByInputs(Items.ENDER_EYE, BLOCKS.OMNISCIENT_OBSIDIAN.get());

        recipesBuilder.saveAll();
    }

    @Override
    public @NotNull String getName() {
        return Territorial.MOD_NAME + " Shaped Recipes Provider";
    }
}
