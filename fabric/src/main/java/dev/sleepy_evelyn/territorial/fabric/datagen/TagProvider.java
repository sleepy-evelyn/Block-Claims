package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.registry.BlocksRegistry;
import dev.sleepy_evelyn.territorial.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

class TagProvider {

    private static final TagKey<Block> PICKAXE_MINEABLE = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("minecraft", "mineable/pickaxe"));

    TagProvider() {}

    static class ItemTags extends FabricTagProvider.ItemTagProvider {

        private final ItemsRegistry items;

        ItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
            this.items = ItemsRegistry.INSTANCE;
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {}
    }

    static class BlockTags extends FabricTagProvider.BlockTagProvider {

        private final BlocksRegistry blocks;

        BlockTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
            this.blocks = BlocksRegistry.INSTANCE;
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            getOrCreateTagBuilder(PICKAXE_MINEABLE).add(
                    blocks.OMNISCIENT_OBSIDIAN.get()
            );
        }
    }
}
