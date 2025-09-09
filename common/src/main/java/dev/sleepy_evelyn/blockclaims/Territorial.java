package dev.sleepy_evelyn.blockclaims;

import dev.sleepy_evelyn.blockclaims.compat.Mods;
import dev.sleepy_evelyn.blockclaims.registry.ObjectsRegistry;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Territorial {
    public static final String MOD_ID = "territorial";
    public static final String MOD_NAME = "Territorial Block Claims";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    //public static TerritorialConfig config = ConfigApiJava.registerAndLoadConfig(TerritorialConfig::new);

    public static void init() {

        ObjectsRegistry.init();
        Mods.EMI.executeIfInstalled(() -> () -> LOGGER.info("EMI is loaded"));
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
