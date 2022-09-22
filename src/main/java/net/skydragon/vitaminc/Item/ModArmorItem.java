package net.skydragon.vitaminc.Item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final  Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP_0 =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.ALOEI,
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 120, 0)).build();

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP_1 =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.ALOED,
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 240, 0)).build();

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP_2 =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.ALOEN,
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 480, 1)).build();

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    public int getCurrentArmorMaterial(PlayerEntity player){
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        if(breastplate.getMaterial() ==ModArmorMaterials.ALOEI ){
            return 0;
        }else if(breastplate.getMaterial() == ModArmorMaterials.ALOED){
            return 1;
        }
        else if(breastplate.getMaterial() == ModArmorMaterials.ALOEN){
            return 2;
        }
        return 3;
    }

    public void levelOfFireExtinguished (ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect , PlayerEntity player, int chanceLevelArmor){

        //Check if Player can extinguish fire by Level of Armor
        double randomChance = Math.random();

        if(hasAloeChestArmorOn(player) && hasCorrectArmorOn(mapArmorMaterial, player)  && player.isOnFire()
                && randomChance > (0.90f/chanceLevelArmor) && !player.hasStatusEffect(mapStatusEffect.getEffectType())) {
            addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
        }

        if(hasAloeChestArmorOn(player) && player.isOnFire() && hasCorrectArmorOn(mapArmorMaterial, player)
                && randomChance > (0.60f/chanceLevelArmor) && !player.hasStatusEffect(mapStatusEffect.getEffectType())) {
            player.extinguish();
        }

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                ArmorMaterial mapArmorMaterial = null;
                StatusEffectInstance mapStatusEffect = null;
                if (!player.getInventory().getArmorStack(2).isEmpty()) {
                    switch (getCurrentArmorMaterial(player)) {
                        case 0:
                            for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP_0.entrySet()) {
                                mapArmorMaterial = entry.getKey();
                                mapStatusEffect = entry.getValue();
                            }
                            levelOfFireExtinguished(mapArmorMaterial, mapStatusEffect, player, 1);
                        case 1:
                            for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP_1.entrySet()) {
                                mapArmorMaterial = entry.getKey();
                                mapStatusEffect = entry.getValue();
                            }
                            levelOfFireExtinguished(mapArmorMaterial, mapStatusEffect, player, 2);
                        case 2:
                            for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP_2.entrySet()) {
                                mapArmorMaterial = entry.getKey();
                                mapStatusEffect = entry.getValue();
                            }
                            levelOfFireExtinguished(mapArmorMaterial, mapStatusEffect, player, 3);
                    }

                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }



    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));



            // if(new Random().nextFloat() > 0.6f) { // 40% of damaging the armor! Possibly!
            //     player.getInventory().damageArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
            // }
        }
    }

    private boolean hasAloeChestArmorOn(PlayerEntity player) {
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        return !breastplate.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        return breastplate.getMaterial() == material;
    }

}
