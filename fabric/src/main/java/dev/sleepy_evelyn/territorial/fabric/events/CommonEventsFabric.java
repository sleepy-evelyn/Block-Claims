package dev.sleepy_evelyn.territorial.fabric.events;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.event.CommonEvents;
import dev.sleepy_evelyn.territorial.fabric.platform.LootTableModifierFabric;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.fabricmc.fabric.api.networking.v1.EntityTrackingEvents;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.storage.loot.LootTable;

public class CommonEventsFabric {

    private static final ResourceLocation EARLY_PHASE = Territorial.id("early");

    public static void init() {
        PlayerBlockBreakEvents.BEFORE.addPhaseOrdering(EARLY_PHASE, Event.DEFAULT_PHASE);
        PlayerBlockBreakEvents.BEFORE.register(CommonEvents::beforeBlockBreak);
        LootTableEvents.MODIFY.register(CommonEventsFabric::onLootTableModify);
        ServerLivingEntityEvents.AFTER_DEATH.register(CommonEvents::afterDeath);
    }

    private static void onLootTableModify(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider provider) {
        CommonEvents.onLootTableModify(key, new LootTableModifierFabric(tableBuilder), provider, source == LootTableSource.VANILLA);
    }
}
