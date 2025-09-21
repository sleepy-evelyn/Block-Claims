package dev.sleepy_evelyn.territorial.client;

import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.DyedItemColor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TerritorialColourProviders {

    public static final Map<ItemColor, List<RegistrySupplier<Item>>> ITEM_COLOURS_MAP = new HashMap<>();

    public static void init() {
        ITEM_COLOURS_MAP.put(
                (stack, tintIdx) ->
                        tintIdx != 1 ? -1 : DyedItemColor.getOrDefault(stack, 0),
                List.of(
                    TerritorialItems.ITEMS.AUGMENTED_EYE
                )
        );
    }
}
