package dev.sleepy_evelyn.territorial.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BlockUtils {

    public static void spreadBlocks(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, Block matchBlock, int spreadAttempts) {
        BlockPos spreadPos;
        for (int i = 0; i < spreadAttempts; i++) {
            spreadPos = pos.offset(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1);
            if (level.getBlockState(spreadPos).getBlock() == matchBlock) {
                level.setBlockAndUpdate(spreadPos, state);
                break;
            }
        }
    }
}
