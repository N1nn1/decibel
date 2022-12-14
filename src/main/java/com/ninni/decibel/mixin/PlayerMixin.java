package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ninni.decibel.Decibel;
import com.ninni.decibel.sound.ItemSoundModifications;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

@Mixin(Player.class)
public abstract class PlayerMixin {

    @Unique
    private final Player mob = (Player) (Object) this;

    @Inject(at = @At("TAIL"), method = "attack", cancellable = true)
    public void D$playAttackSound(Entity target, CallbackInfo info) {
        ItemStack stack = mob.getItemInHand(InteractionHand.MAIN_HAND);
        if (Decibel.getConfig().addWeaponSwingSounds && ItemSoundModifications.ATTACK_SOUNDS.containsKey(stack.getItem())) {
            SoundEvent sound = ItemSoundModifications.ATTACK_SOUNDS.get(stack.getItem()).get(stack);
            mob.getLevel().playSound(null, mob.getX(), mob.getY(), mob.getZ(), sound, mob.getSoundSource(), 1, 1);
        }
    }
}