package dev.sleepy_evelyn.territorial.util;

import net.minecraft.util.FastColor.ARGB32;

public final class ColourUtils {

    public static int brighten(int colour, double factor) {
        return brighten(ARGB32.alpha(colour), ARGB32.red(colour), ARGB32.green(colour), ARGB32.blue(colour), factor);
    }

    public static int brighten(int a, int r, int g, int b, double factor) {
        int nr = Math.min(255, (int) (r * factor));
        int ng = Math.min(255, (int) (g * factor));
        int nb = Math.min(255, (int) (b * factor));
        return ARGB32.color(a, nr, ng, nb);
    }
}
