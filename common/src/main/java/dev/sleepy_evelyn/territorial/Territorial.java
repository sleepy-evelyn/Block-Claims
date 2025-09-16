package dev.sleepy_evelyn.territorial;

import dev.sleepy_evelyn.territorial.compat.Mods;
import dev.sleepy_evelyn.territorial.config.TerritorialConfig;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import dev.sleepy_evelyn.territorial.registry.dynamic.TerritorialDamageSources;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Territorial {
    public static final String MOD_ID = "territorial";
    public static final String MOD_NAME = "Territorial Block Claims";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    public static TerritorialConfig config = ConfigApiJava.registerAndLoadConfig(TerritorialConfig::new);

    public static void init() {
        TerritorialItems.INSTANCE.init();
        TerritorialBlocks.INSTANCE.init();
        Mods.EMI.executeIfInstalled(() -> () -> LOGGER.info("EMI is loaded"));
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static ResourceLocation mcId(String path) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", path);
    }
}
