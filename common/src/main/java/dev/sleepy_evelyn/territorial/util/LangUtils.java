package dev.sleepy_evelyn.territorial.util;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class LangUtils {

    public static String damageTypeKey(ResourceKey<DamageType> key) {
        return "death.attack." + langKey(key);
    }

    public static <T> String langKey(ResourceKey<T> key) {
        return key.location().toLanguageKey();
    }
}
