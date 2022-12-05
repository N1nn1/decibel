package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.ninni.decibel.Decibel;
import com.ninni.decibel.sound.BlockSoundModifications;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(at = @At("HEAD"), method = "getSoundType", cancellable = true)
    private void D$modifySoundType(BlockState state, CallbackInfoReturnable<SoundType> info) {
        Block block = (Block) (Object) this;
        if (Decibel.getConfig().updateBlockSounds && BlockSoundModifications.SOUND_GROUP_MAP.containsKey(block)) {
            info.setReturnValue(BlockSoundModifications.SOUND_GROUP_MAP.get(block).get(state));
        }
    }
}