package dev.sleepy_evelyn.territorial.config;

import dev.sleepy_evelyn.territorial.Territorial;
import me.fzzyhmstrs.fzzy_config.annotations.*;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.config.ConfigGroup;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import me.fzzyhmstrs.fzzy_config.util.Translatable;

import static dev.sleepy_evelyn.territorial.Territorial.id;

@RootConfig
@Version(version = 1)
public class TerritorialConfig extends Config {

    public enum Rate {
        Fast,
        Default,
        Slow
    }

    public TerritorialConfig() {
        super(id("common"));
    }

    @Translatable.Name("Omniscient Obsidian")
    public OmniscientObsidianSection omniscientObsidian = new OmniscientObsidianSection();
    public static class OmniscientObsidianSection extends ConfigSection {

        @Translatable.Name("Allow Spread")
        @Translatable.Desc("Gradually propagate to other Obsidian blocks")
        public boolean allowSpread = true;

        @Translatable.Name("Spread Rate")
        @Translatable.Desc("")
        @Comment("Options: Default, Slow, Fast")
        public Rate spreadRate = Rate.Default;

        @Translatable.Name("Attacks Player")
        @Translatable.Desc("Attack if the block is hit while the player is visible")
        public boolean attacksPlayer = true;
    }

    @Translatable.Name("Enable Pumpkin Polly")
    @Translatable.Desc("")
    @RequiresAction(action = Action.RESTART)
    public boolean enablePollyThePumpkin = false;

    @Override
    public int defaultPermLevel() {
        return 3; // Required to be an admin to make changes
    }
}
