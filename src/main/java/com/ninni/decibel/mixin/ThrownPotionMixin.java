package com.ninni.decibel.mixin;

import  com.ninni.decibel.sound.DecibelSounds;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownPotion.class)
public class ThrownPotionMixin {

    @Inject(method = "onHit", at = @At("HEAD"))
    public void onHit(HitResult result, CallbackInfo info) {
        ThrownPotion potion = ThrownPotion.class.cast(this);

            potion.playSound(DecibelSounds.POTION_SPLASH, 1.0F, 1.0F);
            if (!PotionUtils.getMobEffects(potion.getItem()).isEmpty()) {
                potion.playSound(DecibelSounds.POTION_MAGIC, 1.0F, 1.0F + (potion.level.random.nextFloat() * 0.2F));
                if (this.isLingering()) {
                    potion.playSound(DecibelSounds.POTION_LINGER, 1.0F, 1.0F + (potion.level.random.nextFloat() * 0.2F));
                }
            }
    }

    @Shadow
    private boolean isLingering() {
        throw new AssertionError("Mixin injection failed - Decibel ThrownPotionMixin");
    }
}