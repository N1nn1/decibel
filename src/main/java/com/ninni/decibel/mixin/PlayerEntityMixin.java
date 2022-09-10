package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ninni.decibel.sound.ItemSoundModifications;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    private final PlayerEntity mob = (PlayerEntity) (Object) this;

    @Inject(at = @At("TAIL"), method = "attack", cancellable = true)
    public void playAttackSound(Entity target, CallbackInfo info) {
        ItemStack stack = mob.getStackInHand(Hand.MAIN_HAND);
        if (ItemSoundModifications.SWINGING_MAP.containsKey(stack.getItem())) {
            SoundEvent sound = ItemSoundModifications.SWINGING_MAP.get(stack.getItem()).get(stack);
            mob.getWorld().playSound(null, mob.getX(), mob.getY(), mob.getZ(), sound, mob.getSoundCategory(), 1, 1);
        }
    }
}