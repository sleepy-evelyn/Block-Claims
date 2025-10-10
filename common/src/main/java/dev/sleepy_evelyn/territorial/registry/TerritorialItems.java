package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.TerritorialPlatform;
import dev.sleepy_evelyn.territorial.compat.Mods;
import dev.sleepy_evelyn.territorial.item.AugmentedEye;
import dev.sleepy_evelyn.territorial.util.PlatformUtils;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.Translatable;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

import static dev.sleepy_evelyn.territorial.Territorial.MOD_ID;
import static dev.sleepy_evelyn.territorial.Territorial.id;
import static dev.sleepy_evelyn.territorial.util.ObjectUtils.dummyItem;

public class TerritorialItems {

    public static final ResourceKey<CreativeModeTab> CREATIVE_TAB_KEY =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, id("creative_tab"));

    /* Instance required for Fzzy Translations */
    public static final TerritorialItems ITEMS = new TerritorialItems();

    private final Registrar<Item> itemsRegistrar =
            ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.ITEM);

    @Translatable.Name("Augmented Eye")
    public final RegistrySupplier<Item> AUGMENTED_EYE = registerItem("augmented_eye", AugmentedEye::new);

    @Translatable.Name("Numismatics Augment")
    public final RegistrySupplier<Item> NUMISMATICS_AUGMENT = registerItem("augments/augment_numismatics",
           dummyItem(), Mods.NUMISMATICS::isLoaded, true);

    @Translatable.Name("Computercraft Augment")
    public final RegistrySupplier<Item> COMPUTERCRAFT_AUGMENT = registerItem("augments/augment_computercraft",
            dummyItem(), Mods.COMPUTERCRAFT::isLoaded, true);

    @Translatable.Name("Gloop Ball")
    public final RegistrySupplier<Item> GLOOP_BALL = registerItem("gloop_ball", dummyItem());

    public RegistrySupplier<Item> registerItem(String path, Supplier<@NotNull Item> item) {
        return Objects.requireNonNull(registerItem(path, item, () -> true, true));
    }

    @Nullable
    public RegistrySupplier<Item> registerItem(String path, Supplier<@NotNull Item> item, Supplier<Boolean> condition, boolean addToCreativeTab) {
        if (!condition.get() && !PlatformUtils.isDataGenEnv()) return null;
        var registeredItem = itemsRegistrar.register(path, item);
        if (addToCreativeTab) TerritorialPlatform.addToCreativeTab(registeredItem);
        return registeredItem;
    }

    public void init() {
        itemsRegistrar.init();
    }
}
