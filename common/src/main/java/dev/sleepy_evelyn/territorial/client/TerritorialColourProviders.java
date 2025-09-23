package dev.sleepy_evelyn.territorial.client;

import dev.sleepy_evelyn.territorial.item.AugmentedEye;
import dev.sleepy_evelyn.territorial.util.ColourUtils;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor.ARGB32;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dev.sleepy_evelyn.territorial.registry.TerritorialItems.ITEMS;

public class TerritorialColourProviders {

    public static final Map<ItemColor, List<RegistrySupplier<Item>>> ITEM_COLOURS_MAP = new HashMap<>();

    public static void init() {
        ITEM_COLOURS_MAP.put(
                TerritorialColourProviders::augmentedEyeProvider,
                List.of(ITEMS.AUGMENTED_EYE)
        );
    }

    private static int augmentedEyeProvider(ItemStack stack, int layer) {
        if (layer == 0) return -1; // Don't modify the base layer

        var dyedItemColour = stack.get(DataComponents.DYED_COLOR);
        if (dyedItemColour != null) {
            int r = ARGB32.red(dyedItemColour.rgb());
            int g = ARGB32.green(dyedItemColour.rgb());
            int b = ARGB32.blue(dyedItemColour.rgb());

            if (layer == 2) { // Coloured pupil layer
                var lightness = r + g + b;

                // Make pupil darker if overall darkness is high to provide contrast
                if (lightness > 383) return AugmentedEye.Colours.DARK_PUPIL.get();
                else return AugmentedEye.Colours.LIGHT_PUPIL.get();
            } else
                return ColourUtils.brighten(AugmentedEye.OVERLAY_ALPHA, r, g, b, 1.25);
        }
        // Default values if no colour exists yet
        else if (layer == 2) return AugmentedEye.Colours.DEFAULT_PUPIL.get();
        else return AugmentedEye.Colours.DEFAULT_OVERLAY.get();
    }


}
