package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.config.TerritorialClientConfig;
import dev.sleepy_evelyn.territorial.util.LangUtils;
import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import dev.sleepy_evelyn.territorial.registry.TerritorialItems;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import java.util.concurrent.CompletableFuture;

import static dev.sleepy_evelyn.territorial.util.LangUtils.damageTypeKey;
import static dev.sleepy_evelyn.territorial.registry.dynamic.TerritorialDamageSources.OBSERVED_DAMAGE_TYPE;
import static dev.sleepy_evelyn.territorial.util.LangUtils.translationKey;

class EnUsLangProvider extends FabricLanguageProvider {

    protected EnUsLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> lookup) {
        super(dataOutput, "en_us", lookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {
        addFzzyTranslations(builder);
        addDatapackTranslations(builder);
        builder.add(translationKey("creative_tab"), "Territorial");
    }

    private void addFzzyTranslations(TranslationBuilder builder) {
        ConfigApiJava.buildTranslations(
                TerritorialClientConfig.class, Territorial.id("client"), "en_us",
                true, builder::add
        );
        ConfigApiJava.platform().buildRegistryTranslations(
                TerritorialBlocks.INSTANCE, "block", "en_us", true, builder::add
        );
        ConfigApiJava.platform().buildRegistryTranslations(
                TerritorialItems.INSTANCE, "item", "en_us", true, builder::add
        );
    }

    private void addDatapackTranslations(TranslationBuilder builder) {
        builder.add(damageTypeKey(OBSERVED_DAMAGE_TYPE), "%s was observed by Omniscient Obsidian");
    }
}
