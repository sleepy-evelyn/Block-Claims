package dev.sleepy_evelyn.blockclaims.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.sleepy_evelyn.blockclaims.BlockClaims;
import dev.sleepy_evelyn.blockclaims.blocks.OmniscientObsidianBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

import static dev.sleepy_evelyn.blockclaims.BlockClaims.MOD_ID;

public class ObjectsRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Block> OMNISCIENT_OBSIDIAN
            = registerBlockWithItem("omniscient_obsidian", OmniscientObsidianBlock::new);

    private static <T extends Block> RegistrySupplier<T> registerBlockWithItem(String path, Supplier<T> block) {
        var blockSupplier = registerBlock(path, block);
        registerItem(path, () -> new BlockItem(blockSupplier.get(), new Item.Properties()));
        return blockSupplier;
    }

    private static <T extends Block> RegistrySupplier<T> registerBlock(String path, Supplier<T> block) {
        return BLOCKS.register(BlockClaims.id(path), block);
    }

    private static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> item) {
        return ITEMS.register(BlockClaims.id(path), item);
    }

    public static void init() {
        BLOCKS.register();
        ITEMS.register();
    }
}
