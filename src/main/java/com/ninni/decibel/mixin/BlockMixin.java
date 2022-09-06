package com.ninni.decibel.mixin;

import com.ninni.decibel.sound.RevampedBlockSoundGroups;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Block.class)
public class BlockMixin {


    @Inject(at = @At("HEAD"), method = "getSoundGroup", cancellable = true)
    private void GE$getSoundGroup(BlockState state, CallbackInfoReturnable<BlockSoundGroup> cir) {
        for (Block id : RevampedBlockSoundGroups.SOUND_GROUP_MAP.keySet()) {
            if (Registry.BLOCK.getId(id).equals(Registry.BLOCK.getId(state.getBlock()))) {
                cir.setReturnValue(RevampedBlockSoundGroups.SOUND_GROUP_MAP.get(id));
            }
        }
    }

}
