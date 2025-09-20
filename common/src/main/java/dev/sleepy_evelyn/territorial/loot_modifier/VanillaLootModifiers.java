package dev.sleepy_evelyn.territorial.loot_modifier;

import dev.sleepy_evelyn.territorial.platform.LootTableModifierShared;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class VanillaLootModifiers {

    private static final ResourceKey<LootTable> RUINED_PORTAL_LOOT_TABLE = BuiltInLootTables.RUINED_PORTAL;

    public static void onLootTableModify(ResourceKey<LootTable> key, LootTableModifierShared modifier, HolderLookup.Provider registries, boolean isVanilla) {
        if (isVanilla)
            if (key.equals(RUINED_PORTAL_LOOT_TABLE)) addOmniscientObsidianLoot(modifier);
    }

    private static void addOmniscientObsidianLoot(LootTableModifierShared modifier) {
        var omniscientObsidianItem = TerritorialBlocks.BLOCKS.OMNISCIENT_OBSIDIAN.get().asItem();
        var poolBuilder = LootPool.lootPool()
                .add(LootItem.lootTableItem(omniscientObsidianItem))
                .when(LootItemRandomChanceCondition.randomChance(0.5F))
                .build();
        modifier.addPool(poolBuilder);
    }
}
