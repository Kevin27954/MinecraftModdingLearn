package com.kevinsmod.block;

import java.util.function.Supplier;

import com.kevinsmod.KevinsMod;
import com.kevinsmod.item.SimpleItems;

import com.kevinsmod.block.custom.CustomBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SimpleBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(KevinsMod.MODID);

    // Note that this is called the builder pattern.
    public static final DeferredBlock<Block> COOL_BLOCK = registerBlock("cool_block", () -> new Block(
            BlockBehaviour.Properties.of().destroyTime(1.0f).requiresCorrectToolForDrops().explosionResistance(5.0f).lightLevel(state -> 10).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<Block> COOL_LAMP = registerBlock("cool_lamp", () -> new CoolLamp(
       BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops().lightLevel(blockState -> blockState.getValue(CoolLamp.CLICKED) ? 15 : 0)
    ));


    public static final DeferredBlock<StairBlock> CUSTOM_STAIR_BLOCK = registerBlock("custom_stair_block", () -> new StairBlock(COOL_BLOCK.get().defaultBlockState(),
            BlockBehaviour.Properties.of().strength(1.0f).requiresCorrectToolForDrops()
    ));
    public static final DeferredBlock<SlabBlock> CUSTOM_SLAB_BLOCK = registerBlock("custom_slab_block", () -> new SlabBlock(
            BlockBehaviour.Properties.of().strength(1.0f).requiresCorrectToolForDrops()
    ));
    public static final DeferredBlock<PressurePlateBlock> CUSTOM_PRESSURE_PLATE = registerBlock("custom_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK,
            BlockBehaviour.Properties.of().strength(1.0f).requiresCorrectToolForDrops()
    ));
    public static final DeferredBlock<ButtonBlock> CUSTOM_BUTTON = registerBlock("custom_button", () -> new ButtonBlock(BlockSetType.OAK, 1,
            BlockBehaviour.Properties.of().strength(1.0f).noCollission().requiresCorrectToolForDrops()
    ));
    public static final DeferredBlock<FenceBlock> CUSTOM_FENCE = registerBlock("custom_fence", () -> new FenceBlock(
            BlockBehaviour.Properties.of().strength(1.0f).requiresCorrectToolForDrops()
    ));
    public static final DeferredBlock<FenceGateBlock> CUSTOM_FENCE_GATE = registerBlock("custom_fence_gate", () -> new FenceGateBlock(WoodType.OAK,
            BlockBehaviour.Properties.of().strength(1.0f).requiresCorrectToolForDrops()
    ));
    public static final DeferredBlock<WallBlock> CUSTOM_WALL = registerBlock("custom_wall", () -> new WallBlock(
            BlockBehaviour.Properties.of().strength(1.0f).requiresCorrectToolForDrops()
    ));
    public static final DeferredBlock<DoorBlock> CUSTOM_DOOR = registerBlock("custom_door", () -> new DoorBlock(BlockSetType.OAK,
            BlockBehaviour.Properties.of().strength(1.0f, 3.0f).requiresCorrectToolForDrops()
    ));
    public static final DeferredBlock<TrapDoorBlock> CUSTOM_TRAP_DOOR = registerBlock("custom_trap_door", () -> new TrapDoorBlock(BlockSetType.OAK,
            BlockBehaviour.Properties.of().strength(1.0f).noOcclusion().requiresCorrectToolForDrops()
    ));

    public static final DeferredBlock<Block> COOL_ORE = registerBlock("cool_ore", () -> new DropExperienceBlock(UniformInt.of(2, 6),
            BlockBehaviour.Properties.of().destroyTime(3.0f).requiresCorrectToolForDrops().explosionResistance(5.0f)
    ));
    public static final DeferredBlock<Block> CUSTOM_BLOCK = registerBlock("custom_block", () -> new CustomBlock(
            BlockBehaviour.Properties.of().destroyTime(3.0f).explosionResistance(5.0f).ignitedByLava()
    ));

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> blockToReturn = BLOCKS.register(name, block);
        registerBlockItem(name, blockToReturn);
        return blockToReturn;
    }

    // Everytime a block is registered in blocks, there also need to be a item
    // version of that block too.
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        SimpleItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
