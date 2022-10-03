package net.skydragon.vitaminc;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.skydragon.vitaminc.Item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.skydragon.vitaminc.block.ModBlock;
import net.skydragon.vitaminc.effect.custom.ModEffects;
import net.skydragon.vitaminc.entity.custom.ModEntities;
import net.skydragon.vitaminc.entity.custom.OrangeDudeEntity;
import net.skydragon.vitaminc.paintings.ModPaintings;
import net.skydragon.vitaminc.util.ModRegistries;
import net.skydragon.vitaminc.villager.ModVillagers;
import net.skydragon.vitaminc.world.feature.ModConfiguredFeatures;
import net.skydragon.vitaminc.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class VitaminC implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("vitaminc");
	public static final String MOD_ID ="vitaminc";

	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		ModBlock.registerModItems();
		ModEffects.registerEffects();
		ModItems.registerModItems();
		ModPaintings.registerPaintings();
		ModRegistries.registerMod();
		ModWorldGen.generateModWorldGen();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();
		VitaminST.registerStructureFeatures();
		FabricDefaultAttributeRegistry.register(ModEntities.ORANGE_DUDE, OrangeDudeEntity.setAttributes());


	}
}
