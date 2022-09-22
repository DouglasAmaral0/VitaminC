package net.skydragon.vitaminc.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.skydragon.vitaminc.world.feature.ModPlacedFeatures;

import static net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags.PLAINS;

public class ModTreeGeneration {

    public static void generateTrees() {

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGE_PLACED.getKey().get());
    }
}
