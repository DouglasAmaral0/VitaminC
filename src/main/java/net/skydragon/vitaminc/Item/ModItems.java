package net.skydragon.vitaminc.Item;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.skydragon.vitaminc.Item.custom.AloeVera_Gel;
import net.skydragon.vitaminc.Item.custom.OrangeJuice;
import net.skydragon.vitaminc.Item.custom.OrangePackageItem;
import net.skydragon.vitaminc.Item.custom.OrangeSword;
import net.skydragon.vitaminc.VitaminC;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.skydragon.vitaminc.block.ModBlock;

public class ModItems extends Item {


    public static final Item ANTIBIOTIC = registerItem("antibiotic", new Item (new FabricItemSettings().group(ModItemGroup.VITAMINC)));
    public static final Item VITAMINC = registerItem("vitaminc", new Item (new FabricItemSettings().group(ModItemGroup.VITAMINC)));

    public static final Item ORANGEJUICE = registerItem("orangejuice", new OrangeJuice(new FabricItemSettings().food(ModFoodComponents.ORANGEJUICE).group(ModItemGroup.VITAMINC)));

    public static final Item ORANGE_PACKAGE_ITEM = registerItem("orange_package_item", new OrangePackageItem (new FabricItemSettings().group(ModItemGroup.VITAMINC)));
    public static final Item ORANGE = registerItem("orange", new Item (new FabricItemSettings().food(ModFoodComponents.ORANGE).group(ModItemGroup.VITAMINC)));

    public static final Item ORANGESWORD= registerItem("orange_sword", new OrangeSword(ToolMaterials.DIAMOND, 8,3f, new FabricItemSettings().group(ModItemGroup.VITAMINC)));

    public static final Item ALOEVERA = registerItem("aloevera", new AliasedBlockItem(ModBlock.ALOEVERA_CROP, new FabricItemSettings().group(ModItemGroup.VITAMINC)));

    public static final Item ALOEVERA_GEL = registerItem("aloevera_gel",  new AloeVera_Gel(new FabricItemSettings().group(ModItemGroup.VITAMINC)));

    public static final Item SLIMY_ALOE = registerItem("slimy_aloe",  new Item(new FabricItemSettings().group(ModItemGroup.VITAMINC)));

    public static final Item ALOEVERA_IRON_CHEST = registerItem("aloevera_iron_chest", new ModArmorItem(ModArmorMaterials.ALOEI,
            EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.VITAMINC)));

    /*public static final Item ALOEVERA_DIAMOND_CHEST = registerItem("aloevera_diamond_chest", new ArmorItem(ModArmorMaterials.IRON,
            EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.VITAMINC)));

    public static final Item ALOEVERA_NETHERITE_CHEST = registerItem("aloevera_netherite_chest", new ArmorItem(ModArmorMaterials.IRON,
            EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.VITAMINC)));*/

    public static final Item LEMON_SHIELD = registerItem("lemon_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1250).group(ModItemGroup.VITAMINC), 10, 10, ModItems.ORANGE)); // FabricShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)


    public ModItems(Settings settings) {
        super(settings);
    }


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(VitaminC.MOD_ID, name), item);
    }


    public static void registerModItems(){

        VitaminC.LOGGER.info("Registro dos Items do Mod" + VitaminC.MOD_ID);
    }

}
