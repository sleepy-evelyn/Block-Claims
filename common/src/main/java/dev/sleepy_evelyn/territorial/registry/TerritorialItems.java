package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.TerritorialPlatform;
import dev.sleepy_evelyn.territorial.item.AugmentedEye;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.Translatable;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnderEyeItem;
import net.minecraft.world.item.Item;

import java.util.Properties;
import java.util.function.Supplier;

import static dev.sleepy_evelyn.territorial.Territorial.MOD_ID;

public class TerritorialItems {

    public static final ResourceKey<CreativeModeTab> CREATIVE_TAB_KEY =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, Territorial.id("creative_tab"));

    /* Instance required for Fzzy Translations */
    public static TerritorialItems ITEMS = new TerritorialItems();

    private final Registrar<Item> itemsRegistrar =
            ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.ITEM);

    @Translatable.Name("Augmented Eye")
    public RegistrySupplier<Item> AUGMENTED_EYE = registerItem("augmented_eye", AugmentedEye::new);

    @Translatable.Name("Numismatics Augment")
    public RegistrySupplier<Item> NUMISMATICS_AUGMENT = registerDummyItem("augments/augment_numismatics");

    @Translatable.Name("Computercraft Augment")
    public RegistrySupplier<Item> COMPUTERCRAFT_AUGMENT = registerDummyItem("augments/augment_computercraft");

    @Translatable.Name("Gloop Ball")
    public RegistrySupplier<Item> GLOOP_BALL = registerDummyItem("gloop_ball");

    public RegistrySupplier<Item> registerDummyItem(String path) {
        return registerItem(path, () -> new Item(new Item.Properties()), true);
    }

    public RegistrySupplier<Item> registerItem(String path, Supplier<Item> item) {
        return registerItem(path, item, true);
    }

    public RegistrySupplier<Item> registerItem(String path, Supplier<Item> item, boolean addToCreativeTab) {
        var registeredItem = itemsRegistrar.register(path, item);
        if (addToCreativeTab) TerritorialPlatform.addToCreativeTab(registeredItem);
        return registeredItem;
    }

    public void init() {
        itemsRegistrar.init();
    }
}
