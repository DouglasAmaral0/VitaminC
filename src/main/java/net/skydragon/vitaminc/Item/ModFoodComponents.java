package net.skydragon.vitaminc.Item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    /*    Exemplo de Comida com Efeito
        public static final FoodComponent ENCHANTED_GOLDEN_APPLE = new FoodComponent.Builder().hunger(4).saturationModifier(1.2f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0f).alwaysEdible().build();
    */
    public static final FoodComponent ORANGE = new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).build();
    public static final FoodComponent LEMON = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build();
    public static final FoodComponent TANGERINE = new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).build();

    public static final FoodComponent ORANGEJUICE = new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build();
}
