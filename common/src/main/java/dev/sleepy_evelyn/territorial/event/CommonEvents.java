package dev.sleepy_evelyn.territorial.event;

import dev.sleepy_evelyn.territorial.block.BlockBreakCancellable;
import dev.sleepy_evelyn.territorial.block.OmniscientObsidianBlock;
import dev.sleepy_evelyn.territorial.loot_modifier.VanillaLootModifiers;
import dev.sleepy_evelyn.territorial.platform.LootTableModifierShared;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;

public class CommonEvents {

    public static boolean beforeBlockBreak(Level level, Player player, BlockPos pos, BlockState state, BlockEntity entity) {
        if (state.getBlock() instanceof BlockBreakCancellable block)
            return block.beforeBreakBlock(level, player, pos, state, entity);
        return true;
    }

    public static void onLootTableModify(ResourceKey<LootTable> key, LootTableModifierShared modifier, HolderLookup.Provider registries, boolean isVanilla) {
        VanillaLootModifiers.onLootTableModify(key, modifier, registries, isVanilla);
    }

    public static void afterDeath(LivingEntity entity, DamageSource source) {
        OmniscientObsidianBlock.afterDeath(entity, source);
    }
}
