package dev.sleepy_evelyn.territorial.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@FunctionalInterface
public interface BlockBreakCancellable {
    boolean beforeBreakBlock(Level level, Player player, BlockPos pos, BlockState state, BlockEntity entity);
}
