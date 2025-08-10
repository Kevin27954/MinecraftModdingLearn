package com.kevinsmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class CoolLamp extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public CoolLamp(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));
        System.out.println("I WAS CREATED COOL LAMP");
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            boolean currState = state.getValue(CLICKED);
            level.setBlockAndUpdate(pos, state.setValue(CLICKED, !currState));
        }

        return InteractionResult.SUCCESS;
    }

    /**
     * This part here is important if you want to register a new block state to the game. Without this, the game would not know if they should do it or not.
     * @param builder
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }
}
