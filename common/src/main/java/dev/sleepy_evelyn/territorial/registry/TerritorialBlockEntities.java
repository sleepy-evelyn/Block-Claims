package dev.sleepy_evelyn.territorial.registry;

import dev.sleepy_evelyn.territorial.block.entity.ClaimControllerBlockEntity;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import static dev.sleepy_evelyn.territorial.Territorial.MOD_ID;

public class TerritorialBlockEntities {

    /* Instance required for Fzzy Translations */
    public static TerritorialBlockEntities BEs = new TerritorialBlockEntities();

    private final Registrar<BlockEntityType<?>> blockEntityTypeRegistrar =
            ConfigApiJava.platform().createRegistrar(MOD_ID, BuiltInRegistries.BLOCK_ENTITY_TYPE);

    public RegistrySupplier<BlockEntityType<?>> CLAIM_CONTROLLER =
            register("claim_controller", ClaimControllerBlockEntity::new,
                    TerritorialBlocks.BLOCKS.CLAIM_CONTROLLER.get());

    private RegistrySupplier<BlockEntityType<?>> register(String path, BlockEntityType.BlockEntitySupplier<?> blockEntity, Block... blocks) {
        return blockEntityTypeRegistrar.register(path, () -> BlockEntityType.Builder.of(blockEntity, blocks)
                .build(null));
    }

    public void init() {
        blockEntityTypeRegistrar.init();
    }
}
