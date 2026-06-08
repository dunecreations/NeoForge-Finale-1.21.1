package net.reianis.finale.block.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.reianis.finale.Finale;

public class FTags {
    public static class Blocks {
        public static final TagKey<Block> END_STONE_ORE_REPLACEABLES = createTag("end_stone_ore_replaceables");
        public static final TagKey<Block> DISMALENE_ORE_REPLACEABLES = createTag("dismalene_ore_replaceables");
        public static final TagKey<Block> STALESTONE_ORE_REPLACEABLES = createTag("stalestone_ore_replaceables");

        public static final TagKey<Block> IS_END_LICHEN = createTag("is_end_lichen");



        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Finale.MOD_ID, name));
        }
    }

    public static class Items {




        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Finale.MOD_ID, name));
        }
    }
}
