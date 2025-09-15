package dev.sleepy_evelyn.territorial.util;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.Nullable;

public class MovementUtils {

    public static void randomTeleport(ServerLevel level, ServerPlayer player) {
        randomTeleport(level, player, 0, 16, true, SoundEvents.CHORUS_FRUIT_TELEPORT);
    }

    public static void randomTeleport(ServerLevel level, ServerPlayer player, int minRange, int maxRange, boolean particleEffects, @Nullable SoundEvent soundEvent) {
        double xTpPos, yTpPos, zTpPos;

        for(int i = 0; i < 16; ++i) {
            xTpPos = player.getX() + (player.getRandom().nextDouble() - 0.5D) * (maxRange - minRange);
            yTpPos = Math.clamp(player.getY() + (player.getRandom().nextInt(16) - 8), level.getMinBuildHeight(), (level.getMinBuildHeight() + level.getLogicalHeight() - 1));
            zTpPos = player.getZ() + (player.getRandom().nextDouble() - 0.5D) * (maxRange - minRange);

            if (player.isPassenger()) player.stopRiding();
            if (player.randomTeleport(xTpPos, yTpPos, zTpPos, particleEffects)) {
                if (soundEvent != null) {
                    level.playSound(null, xTpPos, yTpPos, zTpPos, soundEvent, SoundSource.PLAYERS, 1F, 1F);
                    player.playSound(soundEvent, 1F, 1F);
                }
                break;
            }
        }
    }
}
