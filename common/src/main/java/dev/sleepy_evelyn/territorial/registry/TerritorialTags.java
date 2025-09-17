package dev.sleepy_evelyn.territorial.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static dev.sleepy_evelyn.territorial.Territorial.id;

public class TerritorialTags {

    public static final TagKey<Item> XP_ITEMS = TagKey.create(Registries.ITEM, id("xp_items"));
}
