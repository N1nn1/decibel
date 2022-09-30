package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ninni.decibel.Decibel;
import com.ninni.decibel.sound.ArmorSoundModifications;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.math.BlockPos;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(at = @At("HEAD"), method = "playStepSound")
    public void modifyStepSound(BlockPos pos, BlockState state, CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        entity.getArmorItems().forEach((stack) -> {
            if (Decibel.getConfig().addArmorStepSounds && stack.getItem() instanceof ArmorItem item && ArmorSoundModifications.SOUND_MAP.containsKey(item.getMaterial())) {
                entity.playSound(ArmorSoundModifications.SOUND_MAP.get(item.getMaterial()).get(item.getMaterial()), 1, 1);
            } 
        });
    }
}