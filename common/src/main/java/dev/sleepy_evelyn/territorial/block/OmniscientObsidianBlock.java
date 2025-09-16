package dev.sleepy_evelyn.territorial.block;

import dev.sleepy_evelyn.territorial.registry.TerritorialBlocks;
import dev.sleepy_evelyn.territorial.registry.dynamic.TerritorialDamageSources;
import dev.sleepy_evelyn.territorial.util.MovementUtils;
import net.minecraft.client.DeltaTracker;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.behavior.CountDownCooldownTicks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Properties;
import java.util.function.Predicate;

public class OmniscientObsidianBlock extends Block implements BlockBreakCancellable {

    public static final BooleanProperty ANGRY = BooleanProperty.create("angry");

    private static final int SPREAD_ATTEMPTS = 3;

    private int prevAngryTimeTicks = 0;

    private static final Predicate<Iterable<ItemStack>> pumpkinHelmetPredicate = armorItemStacks -> {
        for (var itemStack : armorItemStacks) {
            if (itemStack.getItem().equals(Items.CARVED_PUMPKIN)) return true;
        }
        return false;
    };

    public OmniscientObsidianBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN).randomTicks());
        this.registerDefaultState(getStateDefinition().any()
                .setValue(ANGRY, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ANGRY);
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
        if(!level.isClientSide && random.nextDouble() < 0.0280D) {
            level.setBlockAndUpdate(pos, state.setValue(ANGRY, false));
            tickSpread(state, level, pos, random, Blocks.OBSIDIAN,false, 3);
        }
    }

    private void tickSpread(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, Block matchBlock, boolean angry, int spreadAttempts) {
        BlockPos spreadPos;
        for (int i = 0; i < spreadAttempts; i++) {
            spreadPos = pos.offset(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1);
            if (level.getBlockState(spreadPos).getBlock() == matchBlock) {
                level.setBlockAndUpdate(spreadPos, angry ? state.setValue(ANGRY, true) : state);
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
        // TODO - Maybe add some functionality here
        return true;
    }

    @Override
    protected void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            if (isPlayerVisible(serverPlayer)) {
                var random = RandomSource.create();
                var serverLevel = (ServerLevel) level;

                player.hurt(TerritorialDamageSources.observed(level), 6F);
                level.setBlockAndUpdate(pos, state.setValue(ANGRY, true));
                tickSpread(state, serverLevel, pos, random, this.asBlock(), true, 10);

                if (random.nextDouble() < 0.5)
                    knockBackPlayer(level, serverPlayer, random);
                else
                    MovementUtils.randomTeleport((ServerLevel) level, serverPlayer, 2, 10,
                            true, SoundEvents.CHORUS_FRUIT_TELEPORT);
            }
        }
        super.attack(state, level, pos, player);
    }

    private void knockBackPlayer(Level level, ServerPlayer player, RandomSource random) {
        var direction = player.getDirection().getNormal();
        float randomPitch = random.nextFloat() / 2;
        float randomKnockback = 0.3F + (random.nextFloat() / 2);

        level.playSound(null, player.blockPosition(), SoundEvents.ENDERMAN_SCREAM, SoundSource.BLOCKS,
                0.1F, randomPitch);
        player.knockback(randomKnockback, direction.getX() * ((random.nextDouble() / 2)),
                direction.getZ() * ((random.nextDouble() / 2)));
    }

    private static boolean isPlayerVisible(ServerPlayer player) {
        return !(player.isInvisible() || pumpkinHelmetPredicate.test(player.getArmorSlots()));
    }
}
