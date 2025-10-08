package dev.sleepy_evelyn.territorial.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public final class ObjectUtils {

    public static void spreadBlocks(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, int spreadAttempts, Block... matchBlocks) {
        BlockPos spreadPos;

        for (int i = 0; i < spreadAttempts; i++) {
            spreadPos = pos.offset(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1);
            var currentBlock = level.getBlockState(spreadPos).getBlock();

            for (var matchBlock : matchBlocks) {
                if (currentBlock.equals(matchBlock)) {
                    level.setBlock(spreadPos, state, Block.UPDATE_CLIENTS);
                    break;
                }
            }
        }
    }

    public static Supplier<Item> dummyItem() {
        return () -> new Item(new Item.Properties());
    }
}
