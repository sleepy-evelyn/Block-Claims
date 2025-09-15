package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.block.OmniscientObsidianBlock;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.Translatable;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static dev.sleepy_evelyn.territorial.Territorial.MOD_ID;

public class TerritorialBlocks {

    /* Instance required for Fzzy Translations */
    public static TerritorialBlocks INSTANCE = new TerritorialBlocks();

    public Registrar<Block> BLOCKS = ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.BLOCK);

    @Translatable.Name("Omniscient Obsidian")
    public RegistrySupplier<Block> OMNISCIENT_OBSIDIAN
            = registerBlockWithItem("omniscient_obsidian", OmniscientObsidianBlock::new);

    private RegistrySupplier<Block> registerBlockWithItem(String path, Supplier<Block> block) {
        var blockSupplier = registerBlock(path, block);
        TerritorialItems.INSTANCE.registerItem(path, () -> new BlockItem( blockSupplier.get(), new Item.Properties()));
        return blockSupplier;
    }

    private RegistrySupplier<Block> registerBlock(String path, Supplier<Block> block) {
        return BLOCKS.register(path, block);
    }

    public void init() {
        BLOCKS.init();
    }
}
