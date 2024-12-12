package io.github.trashoflevillage.festivities.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FairyLightBlock extends Block {
    public static final EnumProperty<FairyLightColor> COLOR = EnumProperty.of("color", FairyLightColor.class);
    public static final BooleanProperty POWERED = Properties.POWERED;

    public FairyLightBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(POWERED);
        builder.add(COLOR);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = super.getPlacementState(ctx);
        return state.with(COLOR, FairyLightColor.RED).with(POWERED, false);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        cycleColors(state, world, pos);
        player.swingHand(Hand.MAIN_HAND);

        return ActionResult.SUCCESS;
    }

    private BlockState cycleColors(BlockState state, World world, BlockPos pos) {
        if (state.get(COLOR) == FairyLightColor.RED) {
            state = state.with(COLOR, FairyLightColor.GREEN);
        } else if (state.get(COLOR) == FairyLightColor.GREEN) {
            state = state.with(COLOR, FairyLightColor.BLUE);
        } else if (state.get(COLOR) == FairyLightColor.BLUE) {
            state = state.with(COLOR, FairyLightColor.RED);
        }
        world.setBlockState(pos, state);
        world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS, 1f, 1.5f, true);
        return state;
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.getBlock() != state.getBlock() && world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }
    }

    public void update(BlockState state, ServerWorld world, BlockPos pos) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != (Boolean)state.get(POWERED)) {
            BlockState blockState = state;
            if (!(Boolean)state.get(POWERED)) {
                blockState = cycleColors(state, world, pos);
            }

            world.setBlockState(pos, blockState.with(POWERED, Boolean.valueOf(bl)), Block.NOTIFY_ALL);
        }
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(COLOR).comparatorOutput;
    }

    public enum FairyLightColor implements StringIdentifiable {
        RED("red", 1), GREEN("green", 2), BLUE("blue", 3);

        private final String name;
        private final int comparatorOutput;

        FairyLightColor(final String name, int comparatorOutput) {
            this.name = name;
            this.comparatorOutput = comparatorOutput;
        }

        @Override
        public String asString() {
            return this.name;
        }
    }
}
