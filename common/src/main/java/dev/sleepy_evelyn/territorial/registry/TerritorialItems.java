package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.TerritorialPlatform;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static dev.sleepy_evelyn.territorial.Territorial.MOD_ID;

public class TerritorialItems {

    public static final ResourceKey<CreativeModeTab> CREATIVE_TAB_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB, Territorial.id("creative_tab"));

    /* Instance required for Fzzy Translations */
    public static TerritorialItems INSTANCE = new TerritorialItems();

    public Registrar<Item> ITEMS = ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.ITEM);

    public RegistrySupplier<Item> registerItem(String path, Supplier<Item> item) {
        var registeredItem = ITEMS.register(path, item);
        TerritorialPlatform.addToCreativeTab(registeredItem);
        return registeredItem;
    }

    public void init() {
        ITEMS.init();
    }
}
