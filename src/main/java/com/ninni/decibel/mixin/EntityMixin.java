package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ninni.decibel.Decibel;
import com.ninni.decibel.sound.ArmorSoundModifications;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;

@Mixin(Entity.class)
public class EntityMixin {

    @Unique
    private final Entity entity = (Entity) (Object) this;

    @Inject(at = @At("HEAD"), method = "playStepSound")
    public void D$playStepSound(BlockPos pos, BlockState state, CallbackInfo ci) {
        entity.getArmorSlots().forEach((stack) -> {
            if (Decibel.getConfig().addArmorStepSounds)
            if (state.getCollisionShape(entity.getLevel(), entity.blockPosition()) != Shapes.empty())
            if (stack.getItem() instanceof ArmorItem item && ArmorSoundModifications.SOUND_MAP.containsKey(item.getMaterial())) {
                entity.playSound(ArmorSoundModifications.SOUND_MAP.get(item.getMaterial()), Decibel.getConfig().armorStepVolume, 1);
            } 
        });
    }
}