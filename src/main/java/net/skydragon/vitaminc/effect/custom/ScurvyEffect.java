package net.skydragon.vitaminc.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;


public class ScurvyEffect extends StatusEffect {

    protected ScurvyEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }


    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {;
            if(!entity.world.isClient()) {
                entity.damage(DamageSource.MAGIC, 0.5f * amplifier);
            }
            super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 20 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }
}
