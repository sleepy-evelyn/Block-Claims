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

    /* Instance required for Fzzy Translations */
    public static TerritorialItems INSTANCE = new TerritorialItems();

    public static final ResourceKey<CreativeModeTab> CREATIVE_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
            Territorial.id("territorial"));

    public Registrar<Item> ITEMS = ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.ITEM);

    RegistrySupplier<Item> registerItem(String path, Supplier<Item> item) {
        var itemSupplier = ITEMS.register(path, item);
        TerritorialPlatform.addToCreativeTab(itemSupplier.get());
        return itemSupplier;
    }

    public void init() {
        ITEMS.init();
    }
}
