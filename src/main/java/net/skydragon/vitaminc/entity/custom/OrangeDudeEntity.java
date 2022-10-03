package net.skydragon.vitaminc.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;


public class OrangeDudeEntity extends HostileEntity implements IAnimatable, Angerable {

    public AnimationFactory factory = new AnimationFactory(this);
    public static UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    EntityType<PlayerEntity> user = EntityType.PLAYER;
    @Nullable
    private UUID angryAt;
    private int angerTime;

    public OrangeDudeEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.run", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.walk", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void initGoals(){
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 16.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
        //this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, 10, true, false,this::shouldAngerAt));
        this.targetSelector.add(3, new UniversalAngerGoal(this, true));
        this.targetSelector.add(4,new ActiveTargetGoal<>(this, PlayerEntity.class, false));
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_DOLPHIN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_AXOLOTL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_AXOLOTL_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.10f, 1.0f);
    }

    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    public void setAngryAt(@Nullable UUID angryAt) {

        this.angryAt = angryAt;
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angryAt;
    }
    public boolean isAngryAt(PlayerEntity player) {

        return this.shouldAngerAt(player);
    }


    public boolean shouldAngerAt(LivingEntity entity) {
     if (!this.canTarget(entity)) {
         return false;
     } else {
         return entity.getType() == EntityType.PLAYER && this.isUniversallyAngry(entity.world) ? true : false;
     }
 }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }
}
