package dev.sleepy_evelyn.territorial.neoforge.client;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.config.TerritorialClientConfig;
import dev.sleepy_evelyn.territorial.registry.BlocksRegistry;
import dev.sleepy_evelyn.territorial.registry.ItemsRegistry;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnUsLangNeoForge extends LanguageProvider {
    public EnUsLangNeoForge(PackOutput output) {
        super(output, Territorial.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("this.is.a.test", "Testy Thing");
        // Config Translations
        ConfigApiJava.buildTranslations(TerritorialClientConfig.class, Territorial.id("client"), "en_us", true, this::add);
        // Registration Translations
        ConfigApiJava.platform().buildRegistryTranslations(BlocksRegistry.INSTANCE, "block", "en_us", true, this::add);
        ConfigApiJava.platform().buildRegistryTranslations(ItemsRegistry.INSTANCE, "item", "en_us", true, this::add);
    }
}
