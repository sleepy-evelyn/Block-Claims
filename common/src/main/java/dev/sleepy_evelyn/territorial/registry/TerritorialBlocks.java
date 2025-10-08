package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.Territorial;
import dev.sleepy_evelyn.territorial.block.ClaimControllerBlock;
import dev.sleepy_evelyn.territorial.block.OmniscientObsidianBlock;
import dev.sleepy_evelyn.territorial.block.PumpkinPollyBlock;
import dev.sleepy_evelyn.territorial.util.PlatformUtils;
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
                    new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)), () -> true, false);

    @Translatable.Name("Claim Controller")
    public RegistrySupplier<Block> CLAIM_CONTROLLER =
            registerBlockWithItem("claim_controller", ClaimControllerBlock::new);

    @Translatable.Name("Pumpkin Polly")
    public RegistrySupplier<Block> PUMPKIN_POLLY =
            registerBlockWithItem("pumpkin_polly", PumpkinPollyBlock::new,
                    () -> Territorial.CONFIG.enablePollyThePumpkin, false);

    private RegistrySupplier<Block> registerBlockWithItem(String path, Supplier<@NotNull Block> block) {
        return registerBlockWithItem(path, block, new Item.Properties(), () -> true, true);
    }

    private RegistrySupplier<Block> registerBlockWithItem(String path, Supplier<@NotNull Block> block, Supplier<Boolean> condition, boolean addToCreativeTab) {
        return registerBlockWithItem(path, block, new Item.Properties(), condition, addToCreativeTab);
    }

    private RegistrySupplier<Block> registerBlockWithItem(String path, Supplier<@NotNull Block> block, Item.Properties properties, Supplier<Boolean> condition, boolean addToCreativeTab) {
        var blockSupplier = registerBlock(path, block, condition);
        TerritorialItems.ITEMS.registerItem(path, () -> new BlockItem(blockSupplier.get(), properties), condition, addToCreativeTab);
        return blockSupplier;
    }

    private RegistrySupplier<Block> registerBlock(String path, Supplier<Block> block, Supplier<Boolean> condition) {
        if (!condition.get() && !PlatformUtils.isDataGenEnv()) return null;
        return blocksRegistrar.register(path, block);
    }

    public void init() {
        blocksRegistrar.init();
    }
}
