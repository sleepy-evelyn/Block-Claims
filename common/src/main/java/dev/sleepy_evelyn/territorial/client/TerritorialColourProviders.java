package dev.sleepy_evelyn.territorial.client;

import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dev.sleepy_evelyn.territorial.registry.TerritorialItems.ITEMS;

public class TerritorialColourProviders {

    public static final Map<ItemColor, List<RegistrySupplier<Item>>> ITEM_COLOURS_MAP = new HashMap<>();

    private static class AugmentedEyeColours {
        private AugmentedEyeColours() {}
        static final int OVERLAY_ALPHA = 220;
        static final int DEFAULT_OVERLAY = FastColor.ARGB32.color(OVERLAY_ALPHA, 124, 242, 245);
        static final int DEFAULT_PUPIL = FastColor.ARGB32.color(OVERLAY_ALPHA, 60,60, 60);
        static final int DARK_PUPIL = FastColor.ARGB32.color(50, 160 ,160, 160);
        static final int LIGHT_PUPIL = FastColor.ARGB32.color(25, 255 ,255, 255);
    }

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
            int r = FastColor.ARGB32.red(dyedItemColour.rgb());
            int g = FastColor.ARGB32.green(dyedItemColour.rgb());
            int b = FastColor.ARGB32.blue(dyedItemColour.rgb());

            if (layer == 2) { // Coloured pupil layer
                var darkness = r + g + b;

                // Make pupil darker if overall darkness is high to provide contrast
                if (darkness > 383) return AugmentedEyeColours.DARK_PUPIL;
                else return AugmentedEyeColours.LIGHT_PUPIL;
            } else
                return brighten(AugmentedEyeColours.OVERLAY_ALPHA, r, g, b, 1.25);
        }
        // Default values if no colour exists yet
        else if (layer == 2) return AugmentedEyeColours.DEFAULT_PUPIL;
        else return AugmentedEyeColours.DEFAULT_OVERLAY;
    }

    private static int brighten(int a, int r, int g, int b, double factor) {
        int nr = Math.min(255, (int) (r * factor));
        int ng = Math.min(255, (int) (g * factor));
        int nb = Math.min(255, (int) (b * factor));
        return (a << 24) | (nr << 16) | (ng << 8) | nb;
    }
}
