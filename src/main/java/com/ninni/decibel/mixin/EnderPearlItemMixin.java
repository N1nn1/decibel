package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import com.ninni.decibel.Decibel;
import com.ninni.decibel.sound.DecibelSoundEvents;

import net.minecraft.item.EnderPearlItem;

@Mixin(EnderPearlItem.class)
public abstract class EnderPearlItemMixin {

    @ModifyArgs(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"))
    private void changeEnderPearlSound(Args args) {
        if (Decibel.getConfig().updateEnderPearlThrowSound) {
            args.set(4, DecibelSoundEvents.ITEM_ENDER_PEARL_THROW);
            args.set(6, 1F);
            args.set(7, 1F);
        }
    }
}