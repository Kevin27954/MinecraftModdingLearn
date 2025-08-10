package com.kevinsmod.CreativeMode;

import java.util.function.Supplier;

import com.kevinsmod.KevinsMod;
import com.kevinsmod.block.SimpleBlocks;

import com.kevinsmod.item.SimpleItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB = DeferredRegister
			.create(Registries.CREATIVE_MODE_TAB, KevinsMod.MODID);

	//TAB 1
	public static final Supplier<CreativeModeTab> COOL_ITEMS_TAB = CREATIVE_MOD_TAB.register("cool_items_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(SimpleItems.COOL_STICK.get()))
					.title(Component.translatable("creativetab.kevinsmod.cool_items"))
					.displayItems((itemDisplayParameters, output) -> {
						output.accept(SimpleItems.COOL_STICK);
						output.accept(SimpleItems.COOL_SPEAR);
						output.accept(SimpleItems.COOL_FOOD);
						output.accept(SimpleItems.COOL_FUEL);
						output.accept(SimpleItems.COOL_LEAF);
					}).build());

	// TAB 2
	public static final Supplier<CreativeModeTab> COOL_BLOCKS_TAB = CREATIVE_MOD_TAB.register("cool_blocks_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(SimpleBlocks.COOL_BLOCK.get()))
					.withTabsBefore(ResourceLocation.fromNamespaceAndPath(KevinsMod.MODID, "cool_items_tab"))
					.title(Component.translatable("creativetab.kevinsmod.cool_blocks"))
					.displayItems((itemDisplayParameters, output) -> {
						output.accept(SimpleBlocks.COOL_BLOCK);
						output.accept(SimpleBlocks.COOL_ORE);
						output.accept(SimpleBlocks.CUSTOM_BLOCK);
						output.accept(SimpleBlocks.COOL_LAMP);
					}).build());

	public static final Supplier<CreativeModeTab> COOL_NON_BLOCKS_TAB = CREATIVE_MOD_TAB.register("cool_non_blocks_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(SimpleBlocks.CUSTOM_DOOR.get()))
					.withTabsBefore(ResourceLocation.fromNamespaceAndPath(KevinsMod.MODID, "cool_blocks_tab"))
					.title(Component.translatable("creativetab.kevinsmod.cool_non_blocks"))
					.displayItems((itemDisplayParameters, output) -> {
						output.accept(SimpleBlocks.CUSTOM_DOOR);
						output.accept(SimpleBlocks.CUSTOM_TRAP_DOOR);
						output.accept(SimpleBlocks.CUSTOM_BUTTON);
						output.accept(SimpleBlocks.CUSTOM_SLAB_BLOCK);
						output.accept(SimpleBlocks.CUSTOM_STAIR_BLOCK);
						output.accept(SimpleBlocks.CUSTOM_PRESSURE_PLATE);
						output.accept(SimpleBlocks.CUSTOM_FENCE);
						output.accept(SimpleBlocks.CUSTOM_FENCE_GATE);
						output.accept(SimpleBlocks.CUSTOM_WALL);
					})
					.build()
			);

	public static void register(IEventBus eventBus) {
		CREATIVE_MOD_TAB.register(eventBus);
	}
}