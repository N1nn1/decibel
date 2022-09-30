package com.ninni.decibel.mixin;


import com.ninni.decibel.sound.DecibelSoundGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ConcretePowderBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ConcretePowderBlock.class)
public class ConcretePowderMixin {
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FallingBlock;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V"))
    private static AbstractBlock.Settings adjustDefaultState(AbstractBlock.Settings settings) {
        return settings.sounds(DecibelSoundGroups.SAND);
    }
}