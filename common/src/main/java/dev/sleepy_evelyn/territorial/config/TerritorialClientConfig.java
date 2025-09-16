package dev.sleepy_evelyn.territorial.config;

import dev.sleepy_evelyn.territorial.Territorial;

import me.fzzyhmstrs.fzzy_config.api.FileType;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.util.Translatable;
import org.jetbrains.annotations.NotNull;

@Translatable.Name("Territorial Client Config")
public class TerritorialClientConfig extends Config {
    public TerritorialClientConfig() {
        super(Territorial.id("client_config"));
    }

    @Translatable.Name("Pretty cool text Integer")
    public int clientTestInt = 100;

    @Override
    public @NotNull FileType fileType() {
        return FileType.JSON5;
    }
}
