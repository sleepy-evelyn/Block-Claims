package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.Territorial;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class TerritorialLootTables {
    public static ResourceKey<LootTable> RUINED_PORTAL_LOOT = ResourceKey.create(Registries.LOOT_TABLE,
            Territorial.id("chests/ruined_portal_loot"));
}
