package dev.sleepy_evelyn.territorial.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Predicate;

public class OmniscientObsidianBlock extends Block implements BlockBreakCancellable {

    private static final int SPREAD_ATTEMPTS = 3;

    private static final Predicate<Iterable<ItemStack>> pumpkinHelmetPredicate = armorItemStacks -> {
        for (var itemStack : armorItemStacks) {
            if (itemStack.getItem().equals(Items.CARVED_PUMPKIN)) return true;
        }
        return false;
    };

    public OmniscientObsidianBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN).randomTicks());
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        double x = (pos.getX() + 0.5D) + (random.nextDouble() - 0.5D);
        double y = (pos.getY() + 0.5D) + (random.nextDouble() - 0.5D);
        double z = (pos.getZ() + 0.5D) + (random.nextDouble() - 0.5D);

        double vx = random.nextDouble() - 0.5D;
        double vy = random.nextDouble() - 0.5D;
        double vz = random.nextDouble() - 0.5D;
        level.addParticle(ParticleTypes.PORTAL, x, y, z, vx, vy, vz);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
       super.randomTick(state, level, pos, random);
        if(!level.isClientSide && random.nextDouble() < 0.0280D)
            tickSpread(state, level, pos, random);
    }

    private void tickSpread(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockPos spreadPos;
        for(int i=0; i < SPREAD_ATTEMPTS; i++) {
            spreadPos = pos.offset(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1);
            if(level.getBlockState(spreadPos).getBlock() == Blocks.OBSIDIAN) {
                level.setBlockAndUpdate(spreadPos, state);
                break;
            }
        }
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState state2, boolean bl) {
        super.onPlace(state, level, pos, state2, bl);
        if (!level.isClientSide)
            level.playSound(null, pos, SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.BLOCKS, 0.5F, 0.5F);
    }

    @Override
    public boolean beforeBreakBlock(Level level, Player player, BlockPos pos, BlockState state, BlockEntity entity) {
        if (!level.isClientSide) {
            if (player.isCreative()) return true;
            else if (isPlayerVisible(player)) {
                knockBackPlayer(player, RandomSource.create());
                return false;
            }
        }
        return true;
    }

    private void knockBackPlayer(Player player, RandomSource random) {
        var uniVec = player.getDirection().get2DDataValue();
        player.sendSystemMessage(Component.literal("You got knocked back!"));

        /*var unitVec = player.getHorizontalFacing().getUnitVector();
        var randomPitch = random.nextFloat() / 3;

        player.playSound(SoundEvents.ENTITY_ENDERMAN_SCREAM, SoundCategory.BLOCKS, 0.1F, randomPitch);
        player.takeKnockback(1, unitVec.x * ((random.nextDouble() / 2) + 0.5), unitVec.z * ((random.nextDouble() / 2) + 0.5));*/
    }

    private static boolean isPlayerVisible(Player player) {
        return !(player.isInvisible() || pumpkinHelmetPredicate.test(player.getArmorSlots()));
    }
}
