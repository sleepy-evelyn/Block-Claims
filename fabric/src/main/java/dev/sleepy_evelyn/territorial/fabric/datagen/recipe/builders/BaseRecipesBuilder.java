package dev.sleepy_evelyn.territorial.fabric.datagen.recipe.builders;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Queue;

public abstract class BaseRecipesBuilder<T extends RecipeBuilder> {

    protected final @NotNull RecipeOutput recipeOutput;
    protected final Queue<T> recipeBuilders = new ArrayDeque<>();

    protected @NotNull RecipeCategory category;
    protected T currentBuilder;

    public BaseRecipesBuilder(final @NotNull RecipeOutput recipeOutput) {
        this.recipeOutput = recipeOutput;
        this.category = RecipeCategory.MISC;
    }

    protected abstract BaseRecipesBuilder<T> startNew(ItemLike output, int amount);

    protected void pushBuilder() {
        if (currentBuilder != null) recipeBuilders.add(currentBuilder);
    }

    public BaseRecipesBuilder<T> unlockedByInputs(ItemLike... unlockedBy) {
        for (var unlockItem : unlockedBy)
            currentBuilder.unlockedBy(FabricRecipeProvider.getHasName(unlockItem), FabricRecipeProvider.has(unlockItem));
        return this;
    }

    public void setCategory(@NotNull RecipeCategory category) {
        this.category = category;
    }

    public void saveAll() {
        pushBuilder();
        for (var builder : recipeBuilders) builder.save(recipeOutput);
    }
}
