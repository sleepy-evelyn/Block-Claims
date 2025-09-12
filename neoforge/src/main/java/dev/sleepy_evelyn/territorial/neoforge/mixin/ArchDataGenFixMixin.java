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
 * Copyright (c) 2025 Fuzss
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0.
 * A description of the license is available here: https://www.mozilla.org/en-US/MPL/2.0/.
 *
 * - Modified by: Sleepy-Evelyn on 2025-9
 * - Modifications: Restructured the class to prevent warnings in Intelij
 * - Source file: https://github.com/Fuzss/puzzleslib/blob/main/1.21.1/NeoForge/src/main/java/fuzs/puzzleslib/neoforge/mixin/DatagenModLoaderNeoForgeMixin.java
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
