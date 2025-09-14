package dev.sleepy_evelyn.territorial.fabric.events;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.events.CommonEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.resources.ResourceLocation;

public final class CommonEventsFabric {

    private static final ResourceLocation EARLY_PHASE = Territorial.id("early");

    public static void init() {
        PlayerBlockBreakEvents.BEFORE.addPhaseOrdering(EARLY_PHASE, Event.DEFAULT_PHASE);
        PlayerBlockBreakEvents.BEFORE.register(CommonEvents::beforeBlockBreak);
    }
}
