package net.skydragon.vitaminc.entity.custom;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.skydragon.vitaminc.VitaminC;

public class ModEntities {

        public static final EntityType<OrangeDudeEntity> ORANGE_DUDE = Registry.register(
                Registry.ENTITY_TYPE, new Identifier(VitaminC.MOD_ID, "orange_dude"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, OrangeDudeEntity::new)
                        .dimensions(EntityDimensions.fixed(1f, 1f)).build());
}
