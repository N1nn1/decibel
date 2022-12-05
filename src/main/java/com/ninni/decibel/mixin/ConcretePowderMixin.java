package com.ninni.decibel.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import com.ninni.decibel.sound.DecibelSoundTypes;

import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

@Mixin(ConcretePowderBlock.class)
public class ConcretePowderMixin {

    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/FallingBlock;<init>(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V"))
    private static BlockBehaviour.Properties adjustDefaultState(BlockBehaviour.Properties settings) {
        return settings.sound(DecibelSoundTypes.SAND);
    }
}