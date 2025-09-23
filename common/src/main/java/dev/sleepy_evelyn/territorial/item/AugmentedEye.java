package dev.sleepy_evelyn.territorial.item;

import dev.sleepy_evelyn.territorial.util.ColourUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor.ARGB32;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;

public class AugmentedEye extends BundleItem {

    public static final int OVERLAY_ALPHA = 220;

    public enum Colours {
        DEFAULT_OVERLAY(OVERLAY_ALPHA, 124, 242, 245),
        DEFAULT_PUPIL(OVERLAY_ALPHA, 60, 60, 60),
        DARK_PUPIL(50, 160, 160, 160),
        LIGHT_PUPIL(25, 255, 255, 255),
        BAR_COLOUR_WHITE(225, 220, 220, 220);

        private final int colour;

        Colours(int a, int r, int g, int b) { colour = ARGB32.color(a, r, g, b); }
        public int get() { return colour; }
    }

    public AugmentedEye() {
        super(new Item.Properties()
                .stacksTo(1)
                .component(DataComponents.BUNDLE_CONTENTS, BundleContents.EMPTY)
        );
    }

    @Override
    public int getBarColor(ItemStack stack) {
        var dyedColour = stack.get(DataComponents.DYED_COLOR);

        if (dyedColour != null) {
            int r = ARGB32.red(dyedColour.rgb());
            int g = ARGB32.green(dyedColour.rgb());
            int b = ARGB32.blue(dyedColour.rgb());
            int lightness = r + g + b;

            return lightness > 240 ? ColourUtils.brighten(dyedColour.rgb(), 1.35) :
                    Colours.BAR_COLOUR_WHITE.get();
        }
        return Colours.DEFAULT_OVERLAY.get();
    }
}
