package dev.sleepy_evelyn.territorial.platform;

import net.minecraft.world.level.storage.loot.LootPool;

@FunctionalInterface
public interface LootTableModifierShared {
    void addPool(LootPool pool);
}
