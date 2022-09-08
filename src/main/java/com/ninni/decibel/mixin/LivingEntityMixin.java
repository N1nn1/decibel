package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.ninni.decibel.sound.ItemSoundModifications;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    private final LivingEntity mob = (LivingEntity) (Object) this;

    // dunno if this works in multiplayer atm, needs to be tested
    @Inject(at = @At("TAIL"), method = "setCurrentHand", cancellable = true)
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
}