package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import com.ninni.decibel.sound.DecibelSoundEvents;

import net.minecraft.item.BowItem;
import net.minecraft.sound.SoundEvent;

@Mixin(BowItem.class)
public abstract class BowItemMixin {

    @ModifyArg(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"), index = 4)
    private SoundEvent changeSound(SoundEvent sound) {
        return DecibelSoundEvents.ITEM_BOW_SHOOT;
    }
}