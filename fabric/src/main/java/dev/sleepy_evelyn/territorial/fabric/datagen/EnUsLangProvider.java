package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.config.TerritorialClientConfig;
import dev.sleepy_evelyn.territorial.config.TerritorialConfig;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static dev.sleepy_evelyn.territorial.util.LangUtils.damageTypeKey;
import static dev.sleepy_evelyn.territorial.registry.dynamic.TerritorialDamageSources.OBSERVED_DAMAGE_TYPE;

class EnUsLangProvider extends FabricLanguageProvider {

    EnUsLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> lookup) {
        super(dataOutput, "en_us", lookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {
        addFzzyTranslations(builder);
        addDatapackTranslations(builder);
        builder.add("creative_tab." + Territorial.MOD_ID, "Territorial");
    }

    private void addFzzyTranslations(TranslationBuilder builder) {
        ConfigApiJava.buildTranslations(TerritorialClientConfig.class, Territorial.id("client"),
                "en_us", true, builder::add);
        ConfigApiJava.buildTranslations(TerritorialConfig.class, Territorial.id("common"),
                "en_us", true, builder::add);
        ConfigApiJava.platform().buildRegistryTranslations(TerritorialBlocks.BLOCKS, "block",
                "en_us", true, builder::add);
        ConfigApiJava.platform().buildRegistryTranslations(TerritorialItems.ITEMS, "item",
                "en_us", true, builder::add);
    }

    private void addDatapackTranslations(TranslationBuilder builder) {
        builder.add(damageTypeKey(OBSERVED_DAMAGE_TYPE), "%s was observed by Omniscient Obsidian");
    }
}
