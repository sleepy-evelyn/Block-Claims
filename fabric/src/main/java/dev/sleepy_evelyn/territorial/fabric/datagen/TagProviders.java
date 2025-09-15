package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

import static dev.sleepy_evelyn.territorial.Territorial.mcId;

class TagProviders {

    TagProviders() {}

    static class ItemTags extends FabricTagProvider.ItemTagProvider {

        private final TerritorialItems ITEMS = TerritorialItems.INSTANCE;

        ItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {}
    }

    static class BlockTags extends FabricTagProvider.BlockTagProvider {

        private final TerritorialBlocks BLOCKS = TerritorialBlocks.INSTANCE;

        private final TagKey<Block> PICKAXE_MINEABLE = TagKey.create(Registries.BLOCK, mcId("mineable/pickaxe"));

        BlockTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            getOrCreateTagBuilder(PICKAXE_MINEABLE).add(
                    BLOCKS.OMNISCIENT_OBSIDIAN.get()
            );
        }
    }
}
