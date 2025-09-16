package dev.sleepy_evelyn.territorial;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class TerritorialPlatform {

    @ExpectPlatform
    public static void addToCreativeTab(Supplier<Item> item) {
        throw new AssertionError();
    }
}
