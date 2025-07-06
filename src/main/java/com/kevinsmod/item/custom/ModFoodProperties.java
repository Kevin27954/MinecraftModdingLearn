package com.kevinsmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties COOL_FOOD = new FoodProperties.Builder().nutrition(6).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300), 0.5f).build();


}
