package dev.sleepy_evelyn.territorial.config;

import dev.sleepy_evelyn.territorial.Territorial;
import me.fzzyhmstrs.fzzy_config.api.FileType;
import me.fzzyhmstrs.fzzy_config.config.Config;
import org.jetbrains.annotations.NotNull;

public class TerritorialConfig extends Config {
    public TerritorialConfig() {
        super(Territorial.id("common"));
    }

    public int testInteger = 5;
    public boolean testBoolean = false;

    @Override
    public @NotNull FileType fileType() {
        return FileType.JSON5;
    }

    @Override
    public int defaultPermLevel() {
        return 3; // Required to be an admin to make changes
    }
}
