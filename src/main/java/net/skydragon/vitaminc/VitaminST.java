package net.skydragon.vitaminc;

import com.mojang.serialization.Codec;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import net.skydragon.vitaminc.structures.VitaminStructures;

public class VitaminST {

    public static StructureType<?> VITAMIN_STRUCTURES;

    /**
     * Registers the structure itself and sets what its path is. In this case, the
     * structure will have the Identifier of structure_tutorial:sky_structures.
     * It is always a good idea to register your Structures so that other mods and datapacks can
     * use them too directly from the registries. It's great for mod/datapacks compatibility.
     */
    public static void registerStructureFeatures() {
        VITAMIN_STRUCTURES = register(new Identifier(VitaminC.MOD_ID, "vitaminstructures"), VitaminStructures.CODEC);
    }

    // Helper method to register since compiler will complain about typing if we did () -> SkyStructures.CODEC directly.
    private static <S extends Structure> StructureType<S> register(Identifier id, Codec<S> codec) {
        return Registry.register(Registry.STRUCTURE_TYPE, id, () -> codec);
        }
    }
