package com.kevinsmod.block;

import java.util.function.Supplier;

import com.kevinsmod.KevinsMod;
import com.kevinsmod.item.SimpleItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SimpleBlocks {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(KevinsMod.MODID);

	// Note that this is called the builder pattern.
	public static final DeferredBlock<Block> COOL_BLOCK = registerBlock("cool_block", () -> new Block(
			BlockBehaviour.Properties.of().destroyTime(1.0f).explosionResistance(5.0f).lightLevel(state -> 10).sound(SoundType.DRIPSTONE_BLOCK)));

	public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
		DeferredBlock<T> blockToReturn = BLOCKS.register(name, block);
		registerBlockitem(name, blockToReturn);
		return blockToReturn;
	}

	// Everytime a block is registered in blocks, there also need to be a item
	// version of that block too.
	private static <T extends Block> void registerBlockitem(String name, DeferredBlock<T> block) {
		SimpleItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}

}
