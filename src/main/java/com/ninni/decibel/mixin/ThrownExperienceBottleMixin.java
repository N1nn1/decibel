package com.ninni.decibel.mixin;

import com.ninni.decibel.sound.DecibelSounds;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownExperienceBottle.class)
public class ThrownExperienceBottleMixin {

    @Inject(method = "onHit", at = @At("HEAD"))
    public void onHit(HitResult result, CallbackInfo info) {
        ThrownExperienceBottle expBottle = ThrownExperienceBottle.class.cast(this);
            expBottle.playSound(DecibelSounds.EXP_SPLASH, 1.0F, 0.85F + (expBottle.level.random.nextFloat() * 0.2F));
        }
    }