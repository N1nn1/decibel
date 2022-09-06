package com.ninni.decibel.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class DecibelBlockSoundGroups {

    public static final BlockSoundGroup FART = new BlockSoundGroup(
        1.0F, 1.0F,

        SoundEvents.BLOCK_STONE_BREAK,
        SoundEvents.BLOCK_ROOTED_DIRT_STEP,
        SoundEvents.BLOCK_STONE_PLACE,
        SoundEvents.BLOCK_STONE_HIT,
        SoundEvents.BLOCK_STONE_FALL
    );
}
