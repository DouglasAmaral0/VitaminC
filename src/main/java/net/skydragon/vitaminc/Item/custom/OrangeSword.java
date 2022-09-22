package net.skydragon.vitaminc.Item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.skydragon.vitaminc.effect.custom.ModEffects;
import net.skydragon.vitaminc.effect.custom.ScurvyEffect;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OrangeSword extends SwordItem {

    public OrangeSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(ModEffects.SCURVY, 120, 1));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.vitaminc.orange_sword.tooltip").formatted(Formatting.YELLOW));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
