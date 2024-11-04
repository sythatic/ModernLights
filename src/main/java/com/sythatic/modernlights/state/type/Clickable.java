package com.sythatic.modernlights.state.type;

import com.sythatic.modernlights.data.BlockBehavior;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Clickable extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    protected Clickable(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(CLICKED, false));
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        BlockBehavior.makeClickSound(state, world, pos, Hand.MAIN_HAND, CLICKED);
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }

}
