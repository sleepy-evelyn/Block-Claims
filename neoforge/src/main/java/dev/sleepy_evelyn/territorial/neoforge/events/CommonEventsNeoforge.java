package dev.sleepy_evelyn.territorial.neoforge.events;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.events.CommonEvents;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = Territorial.MOD_ID)
public final class CommonEventsNeoforge {

    @SubscribeEvent
    public static void onBreakEvent(BlockEvent.BreakEvent e) {
        var pos = e.getPos();
        var blockEntity = e.getLevel().getBlockEntity(pos);

        boolean breakProceeds = CommonEvents.beforeBlockBreak(
                (Level) e.getLevel(), e.getPlayer(), pos, e.getState(), blockEntity);
        e.setCanceled(!breakProceeds);
    }
}
