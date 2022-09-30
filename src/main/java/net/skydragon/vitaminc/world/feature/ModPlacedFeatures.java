package net.skydragon.vitaminc.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> ORANGE_PLACED = PlacedFeatures.register("orange_placed",
            ModConfiguredFeatures.ORANGE_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.05f, 2)));

}
