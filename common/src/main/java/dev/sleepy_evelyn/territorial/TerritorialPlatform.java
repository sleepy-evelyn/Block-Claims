package dev.sleepy_evelyn.territorial;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;

public class TerritorialPlatform {

    @ExpectPlatform
    public static void addToCreativeTab(Item item) {
        throw new AssertionError();
    }
}
