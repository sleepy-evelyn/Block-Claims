package dev.sleepy_evelyn.territorial.fabric.utils;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

import static dev.sleepy_evelyn.territorial.Territorial.langKey;

public class LangUtils {

    public static String damageTypeKey(ResourceKey<DamageType> key) {
        return "death.attack." + langKey(key);
    }
}
