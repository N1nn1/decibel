package com.ninni.decibel.sound;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

@SuppressWarnings("unused")
public interface RevampedBlockSoundGroups {
    Map<Block, BlockSoundGroup> SOUND_GROUP_MAP = Maps.newHashMap();

    //Revamped Block Sound Groups

    //BlockSoundGroup CLAY = addBlock(
    //    Blocks.CLAY, new BlockSoundGroup(
    //        1.0f, 1.0f,
    //        SoundEvents.BLOCK_DEEPSLATE_BREAK,
    //        SoundEvents.BLOCK_DEEPSLATE_STEP,
    //        SoundEvents.BLOCK_DEEPSLATE_PLACE,
    //        SoundEvents.BLOCK_DEEPSLATE_HIT,
    //        SoundEvents.BLOCK_DEEPSLATE_FALL
    //    )
    //);

    BlockSoundGroup OAK_LEAVES = leaves(Blocks.OAK_LEAVES);
    BlockSoundGroup BIRCH_LEAVES = leaves(Blocks.BIRCH_LEAVES);
    BlockSoundGroup JUNGLE_LEAVES = leaves(Blocks.JUNGLE_LEAVES);
    BlockSoundGroup MANGROVE_LEAVES = leaves(Blocks.MANGROVE_LEAVES);
    BlockSoundGroup SPRUCE_LEAVES = leaves(Blocks.SPRUCE_LEAVES);
    BlockSoundGroup DARK_OAK_LEAVES = leaves(Blocks.DARK_OAK_LEAVES);
    BlockSoundGroup ACACIA__LEAVES = leaves(Blocks.ACACIA_LEAVES);

    //Util

    static BlockSoundGroup leaves(Block block) {
        return addBlock(block, new BlockSoundGroup(
                1.0f, 1.0f,
                SoundEvents.BLOCK_AZALEA_LEAVES_BREAK,
                SoundEvents.BLOCK_AZALEA_LEAVES_STEP,
                SoundEvents.BLOCK_AZALEA_LEAVES_PLACE,
                SoundEvents.BLOCK_AZALEA_LEAVES_HIT,
                SoundEvents.BLOCK_AZALEA_LEAVES_FALL
            )
        );
    }

    static BlockSoundGroup addBlock(Block block, BlockSoundGroup soundGroup) {
        SOUND_GROUP_MAP.put(block, soundGroup);
        return soundGroup;
    }
}
