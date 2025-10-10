package dev.sleepy_evelyn.territorial.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static dev.sleepy_evelyn.territorial.registry.TerritorialBlocks.BLOCKS;

class BlockLootTableProvider extends FabricBlockLootTableProvider {

    BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(BLOCKS.OMNISCIENT_OBSIDIAN.get());
        dropSelf(BLOCKS.OMNISCIENT_OBSIDIAN_DECAYED.get());
        dropSelf(BLOCKS.CLAIM_CONTROLLER.get());
        dropSelf(BLOCKS.PUMPKIN_POLLY.get());
    }
}
