package dev.sleepy_evelyn.territorial.neoforge.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.logging.LogUtils;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.loading.DatagenModLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

/*
 * This is a modified version of Puzzle-libs Architectory datagen fix for Neoforge.
 * It allows the gradle task to exit early instead of hanging.
 *
 * The class has been modified only for the purposes of suppressing warnings within InteliJ
 *
 * SPDX-License-Identifier: MPL-2.0
 * Modified by: Sleepy-Evelyn on 2025-9
 * Link: https://github.com/Fuzss/puzzleslib/blob/main/src/main/java/com/fuzss/puzzleslib/PuzzleHelper.java
 *
 * Copyright (c) 2025 Fuzss
 */
@Mixin(value = DatagenModLoader.class, remap = false)
public class ArchDataGenFixMixin {

    @SuppressWarnings({"finally", "UnstableApiUsage"})
    @WrapOperation(method = "begin", at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/data/event/GatherDataEvent$DataGeneratorConfig;runAll()V"))
    private static void begin(GatherDataEvent.DataGeneratorConfig dataGeneratorConfig, Operation<Void> operation) {
        // Architectory loom does not exit the data run configuration, this will allow it to do so
        boolean isDevEnv   = !FMLEnvironment.production;
        boolean isDataGen  = isRunningDataGen();

        if (isDevEnv && isDataGen) {
            try {
                operation.call(dataGeneratorConfig);
            } catch (Throwable throwable) {
                LogUtils.getLogger().error("Data generation failed", throwable);
            } finally {
                System.exit(0);
            }
        } else {
            operation.call(dataGeneratorConfig);
        }
    }

    @Shadow
    public static boolean isRunningDataGen() {
        throw new RuntimeException();
    }
}
