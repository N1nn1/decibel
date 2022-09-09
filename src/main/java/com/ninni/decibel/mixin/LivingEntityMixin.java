package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.ninni.decibel.sound.ItemSoundModifications;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    private final LivingEntity mob = (LivingEntity) (Object) this;

    @Shadow
    protected abstract int getHandSwingDuration();

    // dunno if this works in multiplayer atm, needs to be tested
    @Inject(at = @At("TAIL"), method = "setCurrentHand")
    public void setCurrentHand(Hand hand, CallbackInfo info) {
        ItemStack stack = mob.getStackInHand(hand);
        if (ItemSoundModifications.USING_MAP.containsKey(stack.getItem())) {
            mob.playSound(ItemSoundModifications.USING_MAP.get(stack.getItem()).get(stack), 1, 1);
        }
    }

    @Inject(at = @At("TAIL"), method = "getEatSound", cancellable = true)
    public void modifyEatSound(ItemStack stack, CallbackInfoReturnable<SoundEvent> info) {
        if (ItemSoundModifications.EATING_MAP.containsKey(stack.getItem())) {
            info.setReturnValue(ItemSoundModifications.EATING_MAP.get(stack.getItem()).get(stack));
        }
    }

    @Inject(at = @At("TAIL"), method = "Lnet/minecraft/entity/LivingEntity;swingHand(Lnet/minecraft/util/Hand;Z)V", cancellable = true)
    public void addSwingSound(Hand hand, boolean fromServerPlayer, CallbackInfo info) {
        if ((!mob.handSwinging || mob.handSwingTicks >= getHandSwingDuration() / 2 || mob.handSwingTicks < 0) && mob.world instanceof ServerWorld) {
            HitResult result = mob.raycast(5.5, 0, false);
            if (result.getType() != HitResult.Type.BLOCK) {
                ItemStack stack = mob.getStackInHand(hand);
                if (ItemSoundModifications.SWINGING_MAP.containsKey(stack.getItem())) {
                    SoundEvent sound = ItemSoundModifications.SWINGING_MAP.get(stack.getItem()).get(stack);
                    mob.getWorld().playSound(null, mob.getX(), mob.getY(), mob.getZ(), sound, mob.getSoundCategory(), 1, 1);
                }
            }
        }
    }
}