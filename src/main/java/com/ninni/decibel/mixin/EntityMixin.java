package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ninni.decibel.Decibel;
import com.ninni.decibel.sound.ArmorSoundModifications;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(at = @At("HEAD"), method = "playStepSound")
    public void D$playStepSound(BlockPos pos, BlockState state, CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        entity.getArmorSlots().forEach((stack) -> {
            if (!Decibel.getConfig().addArmorStepSounds) return;
            if (stack.getItem() instanceof ArmorItem item && ArmorSoundModifications.SOUND_MAP.containsKey(item.getMaterial())) {
                entity.playSound(ArmorSoundModifications.SOUND_MAP.get(item.getMaterial()), 1, 1);
            } 
        });
    }
}