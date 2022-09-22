package net.skydragon.vitaminc.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.skydragon.vitaminc.block.ModBlock;

public class ModRegistries {

    public static void registerMod(){
        registerFuels();
        registerFlammable();
        registerStrippables();

    }

    private static void registerFuels() {
        FuelRegistry fRegistry = FuelRegistry.INSTANCE;
        //fRegistry.add(Adicione o Combustível aqui, valor do combustível)

    }

    private static void registerStrippables(){

        StrippableBlockRegistry.register(ModBlock.ORANGE_LOG, ModBlock.STRIPPED_ORANGE_LOG);
        StrippableBlockRegistry.register(ModBlock.ORANGE_WOOD, ModBlock.STRIPPED_ORANGE_WOOD);
    }

    private static void registerFlammable() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();
        instance.add(ModBlock.ORANGE_LOG,4,4);
        instance.add(ModBlock.ORANGE_WOOD,4,4);
        instance.add(ModBlock.ORANGE_PLANKS,6,20);
        instance.add(ModBlock.STRIPPED_ORANGE_LOG,5,5);
        instance.add(ModBlock.STRIPPED_ORANGE_WOOD,5,5);
        instance.add(ModBlock.ORANGE_LEAVES, 30, 60);
    }
}
