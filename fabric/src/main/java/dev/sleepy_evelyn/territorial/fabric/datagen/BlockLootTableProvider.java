package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

class BlockLootTableProvider extends FabricBlockLootTableProvider {

    final TerritorialBlocks blocks;

    protected BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
        this.blocks = TerritorialBlocks.INSTANCE;
    }

    @Override
    public void generate() {
        dropSelf(blocks.OMNISCIENT_OBSIDIAN.get());
    }
}
