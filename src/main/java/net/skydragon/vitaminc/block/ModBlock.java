package net.skydragon.vitaminc.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.skydragon.vitaminc.Item.ModItemGroup;
import net.skydragon.vitaminc.VitaminC;
import net.skydragon.vitaminc.block.custom.*;
import net.skydragon.vitaminc.world.feature.tree.OrangeSaplingGenerator;

public class ModBlock {


    public static final Block ORANGE_LOG = registerBlock("orange_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(3f).requiresTool()), ModItemGroup.VITAMINC);

    public static final Block ORANGE_WOOD = registerBlock("orange_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(3f).requiresTool()), ModItemGroup.VITAMINC);

    public static final Block STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(3f).requiresTool()), ModItemGroup.VITAMINC);

    public static final Block STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(3f).requiresTool()), ModItemGroup.VITAMINC);

    public static final Block ORANGE_PLANKS = registerBlock("orange_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(3f).requiresTool()), ModItemGroup.VITAMINC);

    public static final Block ORANGE_LEAVES = registerBlock("orange_leaves",
            new OrangeLeaves(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()), ModItemGroup.VITAMINC);

    public static final Block BOTANIC_BLOCK = registerBlock("botanic_block",
            new BotanicBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2f)), ModItemGroup.VITAMINC);

    public static final Block ORANGE_SAPLING = registerBlock("orange_sapling",
            new ModSaplingBlock(new OrangeSaplingGenerator(),FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModItemGroup.VITAMINC);

    public static final Block ORANGE_LAMP = registerBlock("orange_lamp",
            new OrangeLamp(FabricBlockSettings.of(Material.REDSTONE_LAMP).strength(3f).luminance(state -> state.get(OrangeLamp.LIT) ? 15: 0)), ModItemGroup.VITAMINC);

    public static final Block ALOEVERA_CROP = registerBlock("aloevera_crop",
            new AloeVeraBlock(FabricBlockSettings.copyOf(Blocks.POTATOES).nonOpaque()), ModItemGroup.VITAMINC);


    private static Item registerBlockItem(String name, Block block, ItemGroup tab){

        return Registry.register(Registry.ITEM, new Identifier(VitaminC.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(VitaminC.MOD_ID, name), block);

    }
    public static void registerModItems(){

        VitaminC.LOGGER.info("Block Mod Register" + VitaminC.MOD_ID);
    }
}
