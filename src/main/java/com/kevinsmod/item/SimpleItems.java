package com.kevinsmod.item;

import com.kevinsmod.KevinsMod;

import com.kevinsmod.item.custom.CoolFuelItem;
import com.kevinsmod.item.custom.CoolSpearItem;
import com.kevinsmod.item.custom.ModFoodProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SimpleItems {
    // Creates a registry to have Neoforge prepare to register.
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KevinsMod.MODID);

    // At this point it has offically register my item "COOL STICK" into the game.
    // It has the name of cool_stick and default item properties?
    public static final DeferredItem<Item> COOL_STICK = ITEMS.register("cool_stick",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COOL_SPEAR = ITEMS.register("cool_spear",
            () -> new CoolSpearItem(new Item.Properties()));

    public static final DeferredItem<Item> COOL_FOOD = ITEMS.register("cool_food",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOL_FOOD)));

    public static final DeferredItem<Item> COOL_FUEL = ITEMS.register("cool_fuel",
            () -> new CoolFuelItem(new Item.Properties(), 800));

    public static final DeferredItem<Item> COOL_LEAF = ITEMS.register("cool_leaf",
            () -> new Item(new Item.Properties()));

    // This provides the method that then HAS to be called in the main file.
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
