package dev.sleepy_evelyn.territorial.mixin.common;

import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.RuinedPortalPiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(RuinedPortalPiece.class)
public class RuinedPortalPieceMixin extends TemplateStructurePiece {

    public RuinedPortalPieceMixin(StructurePieceType type, int length, StructureTemplateManager templateManager, ResourceLocation id, String template, StructurePlaceSettings placeSettings, BlockPos pos) {
        super(type, length, templateManager, id, template, placeSettings, pos);
    }

    @Inject(
            method = "postProcess",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/levelgen/structure/structures/RuinedPortalPiece;addNetherrackDripColumnsBelowPortal(Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/LevelAccessor;)V",
                    shift = At.Shift.AFTER
        )
    )
    public void postProcess(WorldGenLevel level, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox chunkBox, ChunkPos chunkPos, BlockPos pivot, CallbackInfo ci) {
        if (random.nextDouble() > 0.5) {
            BoundingBox bb = this.getBoundingBox();
            var minPos = new BlockPos(bb.minX(), bb.minY(), bb.minZ());
            var maxPos = new BlockPos(bb.maxX(), bb.maxY(), bb.maxZ());

            int numCryingObsidian = 0;
            List<BlockPos> obsidianPositions = new ArrayList<>();
            BlockState blockState;

            for (var pos : BlockPos.betweenClosed(minPos, maxPos)) {
                blockState = level.getBlockState(pos);
                if (blockState.is(Blocks.CRYING_OBSIDIAN))
                    numCryingObsidian++;
                else if (blockState.is(Blocks.OBSIDIAN)) {
                    obsidianPositions.add(pos.mutable());
                }
            }

            int numOmniscientObsidian = (numCryingObsidian + 1) / 2;
            for(int i=0; i < numOmniscientObsidian; i++) {
                int randomIdx = random.nextInt(obsidianPositions.size());
                level.setBlock(obsidianPositions.get(randomIdx),
                        TerritorialBlocks.BLOCKS.OMNISCIENT_OBSIDIAN.get().defaultBlockState(), 3);
            }
        }
    }

    @Override
    public void handleDataMarker(String metadata, BlockPos pos, ServerLevelAccessor level, RandomSource random, BoundingBox boundingBox) {}
}
