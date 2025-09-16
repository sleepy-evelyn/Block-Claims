package dev.sleepy_evelyn.territorial.neoforge.events;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.event.CommonEvents;
import dev.sleepy_evelyn.territorial.neoforge.platform.LootTableModifierNeoForge;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.packs.VanillaChestLoot;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = Territorial.MOD_ID)
public final class CommonEventsNeoforge {

    private static final ResourceKey<LootTable> RUINED_PORTAL_LOOT_TABLE = BuiltInLootTables.RUINED_PORTAL;

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onBreakEvent(BlockEvent.BreakEvent e) {
        var pos = e.getPos();
        var blockEntity = e.getLevel().getBlockEntity(pos);

        boolean breakProceeds = CommonEvents.beforeBlockBreak(
                (Level) e.getLevel(), e.getPlayer(), pos, e.getState(), blockEntity);
        e.setCanceled(!breakProceeds);
    }

    @SubscribeEvent
    public static void onLootModify(LootTableLoadEvent e) {
        boolean isVanilla = e.getName().getNamespace().equals("minecraft");
        CommonEvents.onLootTableModify(e.getKey(), new LootTableModifierNeoForge(e.getTable()),
                e.getRegistries(), isVanilla);
    }

    @SubscribeEvent
    public static void afterDeath(LivingDeathEvent e) {
        CommonEvents.afterDeath(e.getEntity(), e.getSource());
    }
}
