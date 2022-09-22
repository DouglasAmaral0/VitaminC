package net.skydragon.vitaminc.Item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.skydragon.vitaminc.VitaminC;

public class ModItemGroup {

    public static final ItemGroup VITAMINC = FabricItemGroupBuilder.build(new Identifier(VitaminC.MOD_ID, "vitaminc"),
            () -> new ItemStack(ModItems.VITAMINC));

}
