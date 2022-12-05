package com.ninni.decibel.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

import com.ninni.decibel.sound.DecibelSoundGroups;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

@Mixin(Blocks.class)
public class BlocksMixin {

    @Redirect(method = "<clinit>", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/level/block/SoundType;GRASS:Lnet/minecraft/world/level/block/SoundType;",
            opcode = Opcodes.GETSTATIC
    ),
            slice = @Slice(
                    from = @At(value = "CONSTANT",
                            args = "stringValue=oak_leaves"
                    ),
                    to = @At(value = "FIELD",
                            target = "Lnet/minecraft/world/level/block/Blocks;MANGROVE_LEAVES:Lnet/minecraft/world/level/block/Block;",
                            opcode = Opcodes.PUTSTATIC
                    )
            )
    )
    private static SoundType D$AddLeaves() {
        return DecibelSoundGroups.GENERIC_LEAVES;
    }
}