package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.ninni.decibel.sound.BlockSoundModifications;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.BlockSoundGroup;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(at = @At("HEAD"), method = "getSoundGroup", cancellable = true)
    private void getModifiedSoundgroup(BlockState state, CallbackInfoReturnable<BlockSoundGroup> info) {
        Block block = (Block) (Object) this;
        if (BlockSoundModifications.SOUND_GROUP_MAP.containsKey(block)) {
            info.setReturnValue(BlockSoundModifications.SOUND_GROUP_MAP.get(block).get(state));
        }
    }
}