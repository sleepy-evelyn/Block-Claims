package dev.sleepy_evelyn.territorial;

import dev.sleepy_evelyn.territorial.compat.Mods;
import dev.sleepy_evelyn.territorial.config.TerritorialConfig;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlockEntities;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Territorial {
    public static final String MOD_ID = "territorial";
    public static final String MOD_NAME = "Territorial Block Claims";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    public static TerritorialConfig CONFIG = ConfigApiJava.registerAndLoadConfig(TerritorialConfig::new);

    public static void init() {
        TerritorialItems.ITEMS.init();
        TerritorialBlocks.BLOCKS.init();
        TerritorialBlockEntities.init();
        Mods.EMI.executeIfInstalled(() -> () -> LOGGER.info("EMI is loaded"));
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static ResourceLocation mcId(String path) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", path);
    }

    public static ResourceLocation commonId(String path) {
        return ResourceLocation.fromNamespaceAndPath("c", path);
    }
}
