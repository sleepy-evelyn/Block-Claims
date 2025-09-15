package dev.sleepy_evelyn.territorial.event;

import dev.sleepy_evelyn.territorial.block.BlockBreakCancellable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CommonEvents {

    public static boolean beforeBlockBreak(Level level, Player player, BlockPos pos, BlockState state, BlockEntity entity) {
        if (state.getBlock() instanceof BlockBreakCancellable block)
            return block.beforeBreakBlock(level, player, pos, state, entity);
        return true;
    }

}
