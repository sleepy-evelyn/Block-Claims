package dev.sleepy_evelyn.territorial.fabric.datagen;

import dev.sleepy_evelyn.territorial.block.ClaimControllerBlock;
import dev.sleepy_evelyn.territorial.block.OmniscientObsidianBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.List;
import java.util.function.Supplier;

import static dev.sleepy_evelyn.territorial.Territorial.id;
import static dev.sleepy_evelyn.territorial.registry.TerritorialBlocks.BLOCKS;
import static dev.sleepy_evelyn.territorial.registry.TerritorialItems.ITEMS;

class ModelProvider extends FabricModelProvider {

    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        generator.createTrivialCube(BLOCKS.OMNISCIENT_OBSIDIAN_DECAYED.get());
        generator.createNonTemplateHorizontalBlock(BLOCKS.PUMPKIN_POLLY.get());

        generator.blockStateOutput.accept(booleanModelState(BLOCKS.CLAIM_CONTROLLER.get(),
                ClaimControllerBlock.ENABLED));
        generator.blockStateOutput.accept(booleanModelState(BLOCKS.OMNISCIENT_OBSIDIAN.get(),
                OmniscientObsidianBlock.ANGRY));
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(ITEMS.GLOOP_BALL.get(), ModelTemplates.FLAT_ITEM);
        generateAugmentItems(generator,
                ITEMS.COMPUTERCRAFT_AUGMENT.get(),
                ITEMS.NUMISMATICS_AUGMENT.get()
        );
    }

    private MultiVariantGenerator booleanModelState(Block block, BooleanProperty booleanProperty) {
        var propertyName = booleanProperty.getName();
        var modelFalse = ModelLocationUtils.getModelLocation(block);
        var modelTrue = ModelLocationUtils.getModelLocation(block, "_" + propertyName);

        return MultiVariantGenerator.multiVariant(block)
                .with(PropertyDispatch.property(booleanProperty)
                        .select(false, Variant.variant().with(VariantProperties.MODEL, modelFalse))
                        .select(true, Variant.variant().with(VariantProperties.MODEL, modelTrue))
                );
    }

    private void generateAugmentItems(ItemModelGenerators generator, Item... augments) {
        generator.generateLayeredItem(
                ModelLocationUtils.getModelLocation(ITEMS.AUGMENTED_EYE.get()),
                id("item/augmented_eye"),
                id("item/augmented_eye_overlay"),
                id("item/augmented_eye_pupil")
        );
        for (var augment : augments)
            generator.generateFlatItem(augment, ModelTemplates.FLAT_ITEM);
    }
}
