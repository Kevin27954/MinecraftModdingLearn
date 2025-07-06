package com.kevinsmod.util;

import com.kevinsmod.KevinsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static TagKey<Block> createBlocksTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(KevinsMod.MODID, name));
        }
    }


    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createItemTag("transformable_items");

        public static TagKey<Item> createItemTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(KevinsMod.MODID, name));

        }
    }

}
