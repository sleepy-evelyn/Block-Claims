package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.block.entity.ClaimControllerBlockEntity;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

import static dev.sleepy_evelyn.territorial.Territorial.MOD_ID;

public class TerritorialBlockEntities {

    private static final Registrar<BlockEntityType<?>> blockEntityTypeRegistrar =
            ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.BLOCK_ENTITY_TYPE);

    public static RegistrySupplier<BlockEntityType<?>> CLAIM_CONTROLLER =
            register("claim_controller", ClaimControllerBlockEntity::new, TerritorialBlocks.BLOCKS.CLAIM_CONTROLLER);

    @SafeVarargs
    private static RegistrySupplier<BlockEntityType<?>> register(String path, BlockEntityType.BlockEntitySupplier<?> blockEntity, RegistrySupplier<@NotNull Block>... blockSuppliers) {
        return blockEntityTypeRegistrar.register(path, () -> BlockEntityType.Builder.of(
                blockEntity, Stream.of(blockSuppliers).map(RegistrySupplier::get).toArray(Block[]::new)
        ).build(null));
    }

    public static void init() {
        blockEntityTypeRegistrar.init();
    }
}
