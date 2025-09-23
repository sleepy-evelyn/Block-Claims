package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.block.ClaimControllerBlock;
import dev.sleepy_evelyn.territorial.block.OmniscientObsidianBlock;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.Translatable;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static dev.sleepy_evelyn.territorial.Territorial.MOD_ID;

public class TerritorialBlocks {

    /* Instance required for Fzzy Translations */
    public static TerritorialBlocks BLOCKS = new TerritorialBlocks();

    private final Registrar<Block> blocksRegistrar =
            ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.BLOCK);

    @Translatable.Name("Omniscient Obsidian")
    public RegistrySupplier<Block> OMNISCIENT_OBSIDIAN =
            registerBlockWithItem("omniscient_obsidian", OmniscientObsidianBlock::new);

    @Translatable.Name("Decayed Omniscient Obsidian")
    public RegistrySupplier<Block> OMNISCIENT_OBSIDIAN_DECAYED =
            registerBlockWithItem("omniscient_obsidian_decayed", () ->
                    new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)), false);

    @Translatable.Name("Claim Controller")
    public RegistrySupplier<Block> CLAIM_CONTROLLER =
            registerBlockWithItem("claim_controller", ClaimControllerBlock::new);

    private RegistrySupplier<Block> registerBlockWithItem(String path, Supplier<@NotNull Block> block) {
        return registerBlockWithItem(path, block, new Item.Properties(), true);
    }

    private RegistrySupplier<Block> registerBlockWithItem(String path, Supplier<@NotNull Block> block, boolean addToCreativeTab) {
        return registerBlockWithItem(path, block, new Item.Properties(), addToCreativeTab);
    }

    private RegistrySupplier<Block> registerBlockWithItem(String path, Supplier<@NotNull Block> block, Item.Properties properties, boolean addToCreativeTab) {
        var blockSupplier = registerBlock(path, block);
        TerritorialItems.ITEMS.registerItem(path, () -> new BlockItem(blockSupplier.get(), properties), addToCreativeTab);
        return blockSupplier;
    }

    private RegistrySupplier<Block> registerBlock(String path, Supplier<Block> block) {
        return blocksRegistrar.register(path, block);
    }

    public void init() {
        blocksRegistrar.init();
    }
}
