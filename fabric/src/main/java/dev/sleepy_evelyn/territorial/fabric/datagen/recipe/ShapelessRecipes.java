package dev.sleepy_evelyn.territorial.fabric.datagen.recipe;

import dev.sleepy_evelyn.territorial.Territorial;
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
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static dev.sleepy_evelyn.territorial.Territorial.commonId;
import static dev.sleepy_evelyn.territorial.registry.TerritorialBlocks.BLOCKS;
import static dev.sleepy_evelyn.territorial.registry.TerritorialItems.ITEMS;

public class ShapelessRecipes extends FabricRecipeProvider {

    private final TagKey<Item> SLIMEBALLS_C_TAG = TagKey.create(Registries.ITEM, commonId("slime_balls"));

    public ShapelessRecipes(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        var recipesBuilder = new ShapelessRecipesBuilder(exporter);

        // Omniscient Obsidian
        recipesBuilder.startNew(BLOCKS.OMNISCIENT_OBSIDIAN.get(), 1)
                .requires(Blocks.CRYING_OBSIDIAN, Blocks.PLAYER_HEAD)
                .requires(List.of(TerritorialTags.XP_ITEMS))
                .unlockedByInputs(BLOCKS.OMNISCIENT_OBSIDIAN.get());

        // Gloop Ball
        recipesBuilder.startNew(ITEMS.GLOOP_BALL.get(), 1)
                .requires(List.of(SLIMEBALLS_C_TAG))
                .requires(Items.FERMENTED_SPIDER_EYE)
                .unlockedByInputs(Items.FERMENTED_SPIDER_EYE, Items.SLIME_BALL);

        recipesBuilder.saveAll();
    }

    @Override
    public @NotNull String getName() {
        return Territorial.MOD_NAME + " Shapeless Recipes Provider";
    }
}
