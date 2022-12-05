package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.ninni.decibel.Decibel;
import com.ninni.decibel.sound.ItemSoundModifications;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Unique
    private final LivingEntity mob = (LivingEntity) (Object) this;

    @Inject(at = @At("TAIL"), method = "startUsingItem")
    public void D$playUsingSound(InteractionHand hand, CallbackInfo info) {
        ItemStack stack = mob.getItemInHand(hand);
        if (Decibel.getConfig().addItemUseSounds && ItemSoundModifications.BEGIN_USING_SOUNDS.containsKey(stack.getItem())) {
            mob.playSound(ItemSoundModifications.BEGIN_USING_SOUNDS.get(stack.getItem()).get(stack), 1, 1);
        }
    }

    @Inject(at = @At("TAIL"), method = "getEatingSound", cancellable = true)
    public void D$modifyEatingSound(ItemStack stack, CallbackInfoReturnable<SoundEvent> info) {
        if (Decibel.getConfig().updateEatingSounds && ItemSoundModifications.EATING_SOUNDS.containsKey(stack.getItem())) {
            info.setReturnValue(ItemSoundModifications.EATING_SOUNDS.get(stack.getItem()).get(stack));
        }
    }
}