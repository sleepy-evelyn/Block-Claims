package dev.sleepy_evelyn.blockclaims.registry;

import dev.sleepy_evelyn.blockclaims.blocks.OmniscientObsidianBlock;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static dev.sleepy_evelyn.blockclaims.Territorial.MOD_ID;

public class ObjectsRegistry {

    public static final Registrar<Block> BLOCKS = ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.BLOCK);
    public static final Registrar<Item> ITEMS = ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.ITEM);

    public static final RegistrySupplier<Block> OMNISCIENT_OBSIDIAN
            = registerBlockWithItem("omniscient_obsidian", OmniscientObsidianBlock::new);

    private static RegistrySupplier<Block> registerBlockWithItem(String path, Supplier<Block> block) {
        var blockSupplier = registerBlock(path, block);
        registerItem(path, () -> new BlockItem( blockSupplier.get(), new Item.Properties()));
        return blockSupplier;
    }

    private static RegistrySupplier<Block> registerBlock(String path, Supplier<Block> block) {
        return BLOCKS.register(path, block);
    }

    private static RegistrySupplier<Item> registerItem(String path, Supplier<Item> item) {
        return ITEMS.register(path, item);
    }

    public static void init() {
        BLOCKS.init();
        ITEMS.init();
    }
}
