package com.ninni.decibel.sound;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;

public class BlockSoundModifications {

    public static final Map<Block, BlockSoundGroup> SOUND_GROUP_MAP = Maps.newHashMap();

    static BlockSoundGroup addLeaves(Block block) {
        return addBlock(block, DecibelSoundGroups.GENERIC_LEAVES);
    }

    static BlockSoundGroup addBlock(Block block, BlockSoundGroup soundGroup) {
        SOUND_GROUP_MAP.put(block, soundGroup);
        return soundGroup;
    }

    public static void init() {
        addBlock(Blocks.CLAY, DecibelSoundGroups.CLAY);
        addBlock(Blocks.COARSE_DIRT, DecibelSoundGroups.COARSE_DIRT);
        addBlock(Blocks.DIRT, DecibelSoundGroups.DIRT);
        addBlock(Blocks.DIRT_PATH, DecibelSoundGroups.DIRT);

        addBlock(Blocks.GRASS_BLOCK, DecibelSoundGroups.GRASS_BLOCK);
        addBlock(Blocks.GRAVEL, DecibelSoundGroups.GRAVEL);
        addBlock(Blocks.IRON_BLOCK, DecibelSoundGroups.METAL);
        addBlock(Blocks.GOLD_BLOCK, DecibelSoundGroups.METAL);

        addBlock(Blocks.GRASS, DecibelSoundGroups.GRASS_PLANT);
        addBlock(Blocks.TALL_GRASS, DecibelSoundGroups.GRASS_PLANT);
        addBlock(Blocks.FERN, DecibelSoundGroups.GRASS_PLANT);
        addBlock(Blocks.LARGE_FERN, DecibelSoundGroups.GRASS_PLANT);

        addLeaves(Blocks.OAK_LEAVES);
        addLeaves(Blocks.BIRCH_LEAVES);
        addLeaves(Blocks.JUNGLE_LEAVES);
        addLeaves(Blocks.MANGROVE_LEAVES);
        addLeaves(Blocks.SPRUCE_LEAVES);
        addLeaves(Blocks.DARK_OAK_LEAVES);
        addLeaves(Blocks.ACACIA_LEAVES);
    }
}