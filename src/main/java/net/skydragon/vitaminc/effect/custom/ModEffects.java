package net.skydragon.vitaminc.effect.custom;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.skydragon.vitaminc.VitaminC;

import java.awt.*;

public class ModEffects {

    public static StatusEffect SCURVY;

    public static StatusEffect registerStatusEffect(String name) {

        return Registry.register(Registry.STATUS_EFFECT, new Identifier(VitaminC.MOD_ID, name),
                new ScurvyEffect(StatusEffectCategory.HARMFUL, 9500058));
    }

        public static void registerEffects(){

            SCURVY = registerStatusEffect("scurvy");
        }
    }


