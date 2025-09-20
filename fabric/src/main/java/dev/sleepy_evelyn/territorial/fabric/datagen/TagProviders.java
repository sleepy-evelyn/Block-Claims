package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.compat.Mods;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import dev.sleepy_evelyn.territorial.registry.TerritorialTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static dev.sleepy_evelyn.territorial.registry.TerritorialBlocks.BLOCKS;

class TagProviders {

    TagProviders() {}

    static class ItemProvider extends FabricTagProvider.ItemTagProvider {

        ItemProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            // XP items
            getOrCreateTagBuilder(TerritorialTags.XP_ITEMS)
                    .add(Items.EXPERIENCE_BOTTLE)
                    .addOptional(Mods.CREATE.rl("experience_nugget"))
                    .addOptional(Mods.CREATE_ENCHANTMENT_INDUSTRY.rl("experience_bucket"));
        }
    }

    static class BlockProvider extends FabricTagProvider.BlockTagProvider {

        BlockProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(BLOCKS.OMNISCIENT_OBSIDIAN.get())
                    .add(BLOCKS.OMNISCIENT_OBSIDIAN_DECAYED.get());
        }
    }
}
