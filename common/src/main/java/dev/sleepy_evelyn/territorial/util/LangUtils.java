package dev.sleepy_evelyn.territorial.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import org.jetbrains.annotations.Nullable;

import static dev.sleepy_evelyn.territorial.Territorial.MOD_ID;
import static dev.sleepy_evelyn.territorial.Territorial.langKey;

public class LangUtils {

    public static String translationKey(@Nullable String prefix) {
        return String.join(".", prefix, MOD_ID);
    }

    public static String translationKey(@Nullable String prefix, @Nullable String suffix) {
        return String.join(".", prefix, MOD_ID, suffix);
    }

    public static String damageTypeKey(ResourceKey<DamageType> key) {
        return "death.attack." + langKey(key);
    }
}
