package dev.sleepy_evelyn.territorial.compat;

import java.util.Locale;
import java.util.function.Supplier;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * For compatibility with and without another mod present, we have to define load conditions of the specific code
 */
public enum Mods {
    EMI;

    private final String id;

    Mods() {
        id = name().toLowerCase(Locale.ENGLISH);
    }

    /**
     * @return the mod id
     */
    public String id() {
        return id;
    }

    public ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(id, path);
    }

    public Block getBlock(String id) {
        return BuiltInRegistries.BLOCK.get(rl(id));
    }

    public Item getItem(String id) {
        return BuiltInRegistries.ITEM.get(rl(id));
    }

    /**
     * @return a boolean of whether the mod is loaded or not based on mod id
     */
    public Boolean isLoaded() {
        return ConfigApiJava.platform().isModLoaded(id);
    }

    /**
     * Simple hook to execute code if a mod is installed
     *
     * @param toExecute will be executed only if the mod is loaded
     */
    public void executeIfInstalled(Supplier<Runnable> toExecute) {
        if (isLoaded()) toExecute.get().run();
    }
}
