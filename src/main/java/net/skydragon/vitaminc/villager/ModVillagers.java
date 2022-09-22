package net.skydragon.vitaminc.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.skydragon.vitaminc.Item.ModItems;
import net.skydragon.vitaminc.VitaminC;
import net.skydragon.vitaminc.block.ModBlock;
import net.skydragon.vitaminc.block.custom.BotanicBlock;

public class ModVillagers {

    public static final PointOfInterestType BOTANIC_POI = registerPointOfInterest("botanic_poi", ModBlock.BOTANIC_BLOCK);
    public static final VillagerProfession BOTANIC_MASTER = registerProfession("botanic_master",RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY,
            new Identifier(VitaminC.MOD_ID, "botanic_poi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(VitaminC.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(VitaminC.MOD_ID, name))
                        .workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_FARMER).build());
    }

    public static PointOfInterestType registerPointOfInterest (String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(VitaminC.MOD_ID, name), 2, 1,
                ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerTrades(){

        TradeOfferHelper.registerVillagerOffers(BOTANIC_MASTER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.ORANGE, 2), 10, 2, 0.01f));
        });
    }
    public static void registerVillagers() {
        VitaminC.LOGGER.debug("Registering Villagers of " + VitaminC.MOD_ID);


    }
}
