package dev.sleepy_evelyn.territorial.fabric.platform;

import dev.sleepy_evelyn.territorial.platform.LootTableModifierShared;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

public class LootTableModifierFabric implements LootTableModifierShared {

    private final LootTable.Builder tableBuilder;

    public LootTableModifierFabric(LootTable.Builder tableBuilder) {
        this.tableBuilder = tableBuilder;
    }

    @Override
    public void addPool(LootPool pool) {
        this.tableBuilder.pool(pool);
    }
}
