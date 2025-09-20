package dev.sleepy_evelyn.territorial.fabric.datagen.recipe.builders;

import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class ShapelessRecipesBuilder extends BaseRecipesBuilder<ShapelessRecipeBuilder> {

    public ShapelessRecipesBuilder(@NotNull RecipeOutput recipeOutput) {
        super(recipeOutput);
    }

    @Override
    public ShapelessRecipesBuilder start(ItemLike output, int amount) {
        this.pushBuilder();
        currentBuilder = new ShapelessRecipeBuilder(category, output, amount);
        return this;
    }

    public ShapelessRecipesBuilder requires(ItemLike... itemLikeInputs) {
        for (var itemLike : itemLikeInputs) currentBuilder.requires(itemLike);
        return this;
    }

    public ShapelessRecipesBuilder requires(List<TagKey<Item>> itemTags) {
        for (var tag : itemTags) currentBuilder.requires(tag);
        return this;
    }

    public ShapelessRecipesBuilder requires(Ingredient... ingredients) {
        for (var ingredient : ingredients) currentBuilder.requires(ingredient);
        return this;
    }
}
