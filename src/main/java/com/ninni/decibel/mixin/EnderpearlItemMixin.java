package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import com.ninni.decibel.Decibel;
import com.ninni.decibel.sound.DecibelSounds;
import net.minecraft.world.item.EnderpearlItem;

@Mixin(EnderpearlItem.class)
public abstract class EnderpearlItemMixin {

    @ModifyArgs(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"))
    private void D$playSound(Args args) {
        if (Decibel.getConfig().updateEnderPearlThrowSound) {
            args.set(4, DecibelSounds.ENDER_PEARL_THROW);
            args.set(6, 1F);
            args.set(7, 1F);
        }
    }
}