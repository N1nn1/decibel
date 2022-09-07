package com.ninni.decibel.mixin;

import com.ninni.decibel.sound.BlockSoundModifications;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(at = @At("HEAD"), method = "getSoundGroup", cancellable = true)
    private void getModifiedSoundgroup(BlockState state, CallbackInfoReturnable<BlockSoundGroup> cir) {
        Block that = (Block) (Object) this;
        if (BlockSoundModifications.SOUND_GROUP_MAP.containsKey(that)) {
            cir.setReturnValue(BlockSoundModifications.SOUND_GROUP_MAP.get(that));
        }
    }
}
