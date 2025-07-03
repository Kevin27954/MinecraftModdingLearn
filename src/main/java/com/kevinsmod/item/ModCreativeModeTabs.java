package com.kevinsmod.item;

import java.util.function.Supplier;

import com.kevinsmod.KevinsMod;
import com.kevinsmod.block.SimpleBlocks;

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
					}).build());

	// TAB 2
	public static final Supplier<CreativeModeTab> COOL_BLOCKS_TAB = CREATIVE_MOD_TAB.register("cool_blocks_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(SimpleBlocks.COOL_BLOCK.get()))
					.withTabsBefore(ResourceLocation.fromNamespaceAndPath(KevinsMod.MODID, "cool_items_tab"))
					.title(Component.translatable("creativetab.kevinsmod.cool_blocks"))
					.displayItems((itemDisplayParameters, output) -> {
						output.accept(SimpleBlocks.COOL_BLOCK);
					}).build());

	public static void register(IEventBus eventBus) {
		CREATIVE_MOD_TAB.register(eventBus);
	}
}