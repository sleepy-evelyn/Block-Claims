package dev.sleepy_evelyn.territorial.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public class AugmentedEye extends Item {

    public AugmentedEye() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext useOnContext) {
        useOnContext.getItemInHand().set(DataComponents.DYED_COLOR,
                new DyedItemColor(DyeColor.RED.getTextureDiffuseColor(), true));
        return super.useOn(useOnContext);
    }
}
