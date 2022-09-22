package net.skydragon.vitaminc.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.skydragon.vitaminc.VitaminC;

public class ModTags {

    public static class Blocks{
        private static TagKey<Block> createTag(String name){
            return TagKey.of(Registry.BLOCK_KEY,new Identifier(VitaminC.MOD_ID, name));
        }
        private static TagKey<Block> createCommonTag(String name){
            return TagKey.of(Registry.BLOCK_KEY,new Identifier("vitamintags", name));
        }
    }

    public static class Items{

        public static final TagKey<Item> ORANGE = createCommonTag("orange");


        private static TagKey<Item> createTag(String name){
            return TagKey.of(Registry.ITEM_KEY,new Identifier(VitaminC.MOD_ID, name));
        }
        private static TagKey<Item> createCommonTag(String name){
            return TagKey.of(Registry.ITEM_KEY,new Identifier("vitamintags", name));
        }

    }

}
