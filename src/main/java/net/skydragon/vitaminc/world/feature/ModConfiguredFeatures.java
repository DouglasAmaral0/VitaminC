package net.skydragon.vitaminc.world.feature;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.skydragon.vitaminc.VitaminC;
import net.skydragon.vitaminc.block.ModBlock;

import java.util.List;


public class ModConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ORANGE_TREE =
            ConfiguredFeatures.register("orange_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlock.ORANGE_LOG),
                    new StraightTrunkPlacer(2, 3, 2),
                    BlockStateProvider.of(ModBlock.ORANGE_LEAVES),
                    new BlobFoliagePlacer(
                            ConstantIntProvider.create(3),
                            ConstantIntProvider.create(3),
                            3
                    ),
                    new TwoLayersFeatureSize(1, 0, 1)).build());

    public static final RegistryEntry<PlacedFeature> ORANGE_CHECKED =
            PlacedFeatures.register("orange_checked", ORANGE_TREE,
                    PlacedFeatures.wouldSurvive(ModBlock.ORANGE_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ORANGE_SPAWN =
            ConfiguredFeatures.register("orange_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(ORANGE_CHECKED, 0.3f)),
                            ORANGE_CHECKED));


    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + VitaminC.MOD_ID);
    }
}
