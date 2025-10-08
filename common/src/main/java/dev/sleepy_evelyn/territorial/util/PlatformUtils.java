package dev.sleepy_evelyn.territorial.util;

import dev.sleepy_evelyn.territorial.Territorial;

public final class PlatformUtils {

    public static boolean isDataGenEnv() {
        try {
            return Territorial.MOD_ID.equals(System.getProperty("fabric-api.datagen.modid"));
        } catch (SecurityException | IllegalArgumentException e) {
            Territorial.LOGGER.error("Unable to check if mod is running in data gen environment", e);
            return false;
        }
    }
}
