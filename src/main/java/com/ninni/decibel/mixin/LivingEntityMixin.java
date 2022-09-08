package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ninni.decibel.sound.ItemSoundModifications;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    private final LivingEntity mob = (LivingEntity) (Object) this;

    // dunno if this works in multiplayer atm, needs to be tested
    @Inject(at = @At("TAIL"), method = "setCurrentHand", cancellable = true)
    public void setCurrentHand(Hand hand, CallbackInfo info) {
        Item item = mob.getStackInHand(hand).getItem();
        if (ItemSoundModifications.USING_MAP.containsKey(item)) {
            mob.playSound(ItemSoundModifications.USING_MAP.get(item), 1, 1);
        }
    }
}