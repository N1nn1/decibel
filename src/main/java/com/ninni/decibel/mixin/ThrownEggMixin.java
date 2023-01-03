package com.ninni.decibel.mixin;
import com.ninni.decibel.sound.DecibelSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownEgg.class)
public class ThrownEggMixin {

    @Inject(method = "onHit", at = @At("HEAD"))
    public void onHit(HitResult result, CallbackInfo info) {
        ThrownEgg egg = ThrownEgg.class.cast(this);
            egg.level.playSound(null, egg.getX(), egg.getY(), egg.getZ(), DecibelSounds.EGG_LAND, SoundSource.BLOCKS, 0.3F, 0.85F + (egg.level.random.nextFloat() * 0.2F));
        }
    }
