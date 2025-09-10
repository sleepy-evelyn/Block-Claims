package dev.sleepy_evelyn.territorial.registry;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static dev.sleepy_evelyn.territorial.Territorial.MOD_ID;

public class ItemsRegistry {

    /* Instance required for Fzzy Translations */
    public static ItemsRegistry INSTANCE = new ItemsRegistry();

    public Registrar<Item> ITEMS = ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.ITEM);

    RegistrySupplier<Item> registerItem(String path, Supplier<Item> item) {
        return ITEMS.register(path, item);
    }

    public void init() {
        ITEMS.init();
    }
}
