package com.ninni.decibel.mixin;


import com.ninni.decibel.sound.DecibelSoundGroups;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;


@Mixin(Blocks.class)
public class BlocksMixin {


    @Redirect(method = "<clinit>", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/sound/BlockSoundGroup;GRASS:Lnet/minecraft/sound/BlockSoundGroup;",
            opcode = Opcodes.GETSTATIC
    ),
            slice = @Slice(
                    from = @At(value = "CONSTANT",
                            args = "stringValue=oak_leaves"
                    ),
                    to = @At(value = "FIELD",
                            target = "Lnet/minecraft/block/Blocks;MANGROVE_LEAVES:Lnet/minecraft/block/Block;",
                            opcode = Opcodes.PUTSTATIC
                    )
            )
    )
    private static BlockSoundGroup addLeaves() {
        return DecibelSoundGroups.GENERIC_LEAVES;
    }
}

