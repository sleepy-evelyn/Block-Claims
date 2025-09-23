package dev.sleepy_evelyn.territorial.block.entity;

import dev.sleepy_evelyn.territorial.registry.TerritorialBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ClaimControllerBlockEntity extends BlockEntity {

    public ClaimControllerBlockEntity(BlockPos pos, BlockState state) {
        super(TerritorialBlockEntities.CLAIM_CONTROLLER.get(), pos, state);
    }
}
