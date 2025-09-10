package dev.sleepy_evelyn.territorial.fabric.client.datagen;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.config.TerritorialClientConfig;
import dev.sleepy_evelyn.territorial.registry.BlocksRegistry;
import dev.sleepy_evelyn.territorial.registry.ItemsRegistry;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class EnUsLangFabric extends FabricLanguageProvider {
    protected EnUsLangFabric(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {
        // Config Translations
        ConfigApiJava.buildTranslations(TerritorialClientConfig.class, Territorial.id("client"), "en_us", true, builder::add);
        // Registration Translations
        ConfigApiJava.platform().buildRegistryTranslations(BlocksRegistry.INSTANCE, "block", "en_us", true, builder::add);
        ConfigApiJava.platform().buildRegistryTranslations(ItemsRegistry.INSTANCE, "item", "en_us", true, builder::add);
    }
}
