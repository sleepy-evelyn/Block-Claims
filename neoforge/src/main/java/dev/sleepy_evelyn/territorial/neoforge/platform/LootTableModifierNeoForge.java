package dev.sleepy_evelyn.territorial.neoforge.platform;

import dev.sleepy_evelyn.territorial.platform.LootTableModifierShared;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

public class LootTableModifierNeoForge implements LootTableModifierShared {

    private final LootTable lootTable;

    public LootTableModifierNeoForge(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    @Override
    public void addPool(LootPool pool) {
        lootTable.addPool(pool);
    }
}
