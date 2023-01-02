package com.ninni.decibel.mixin;

import java.util.Collection;

import  com.ninni.decibel.sound.DecibelSounds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Creeper.class)
public final class CreeperMixin {
    @Inject(method = "spawnLingeringCloud", at = @At("HEAD"))
    public void spawnLingeringCloud(CallbackInfo info) {
        Creeper creeper = Creeper.class.cast(this);
        Collection<MobEffectInstance> collection = creeper.getActiveEffects();
            if (!collection.isEmpty()) {
                creeper.playSound(DecibelSounds.POTION_MAGIC, 1.0F, 1.0F + (creeper.level.random.nextFloat() * 0.2F));
                creeper.playSound(DecibelSounds.POTION_LINGER, 1.0F, 1.0F + (creeper.level.random.nextFloat() * 0.2F));
            }
    }

}