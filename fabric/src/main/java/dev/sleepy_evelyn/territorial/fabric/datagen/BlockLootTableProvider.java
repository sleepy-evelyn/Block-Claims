package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

class BlockLootTableProvider extends FabricBlockLootTableProvider {

    private final TerritorialBlocks BLOCKS;

    protected BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
        this.BLOCKS = TerritorialBlocks.BLOCKS;
    }

    @Override
    public void generate() {
        dropSelf(BLOCKS.OMNISCIENT_OBSIDIAN.get());
        dropSelf(BLOCKS.OMNISCIENT_OBSIDIAN_DECAYED.get());
    }
}
