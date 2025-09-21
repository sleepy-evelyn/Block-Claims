package dev.sleepy_evelyn.territorial.fabric.datagen.recipe.builders;

import dev.sleepy_evelyn.territorial.fabric.datagen.recipe.ShapedRecipes;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public final class ShapedRecipesBuilder extends BaseRecipesBuilder<ShapedRecipeBuilder> {

    public ShapedRecipesBuilder(@NotNull RecipeOutput recipeOutput) {
        super(recipeOutput);
    }

    @Override
    public ShapedRecipesBuilder startNew(ItemLike output, int amount) {
        this.pushBuilder();
        currentBuilder = new ShapedRecipeBuilder(category, output, amount);
        return this;
    }

    public ShapedRecipesBuilder pattern(String... pattern) {
        for (var row : pattern) currentBuilder.pattern(row);
        return this;
    }

    public ShapedRecipesBuilder define(Character character, TagKey<Item> tagKey) {
        return this.define(character, Ingredient.of(tagKey));
    }

    public ShapedRecipesBuilder define(Character character, ItemLike itemLike) {
        return this.define(character, Ingredient.of(new ItemLike[]{itemLike}));
    }

    public ShapedRecipesBuilder define(Character character, Ingredient ingredient) {
        currentBuilder.define(character, ingredient);
        return this;
    }
}
