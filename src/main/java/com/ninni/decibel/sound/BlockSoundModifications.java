package com.ninni.decibel.sound;

import java.util.Map;

import com.google.common.collect.Maps;
import com.ninni.decibel.util.SoundGroupFunction;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class BlockSoundModifications {

    public static final Map<Block, SoundGroupFunction<BlockState>> SOUND_GROUP_MAP = Maps.newHashMap();

    static void addBlock(Block block, SoundGroupFunction<BlockState> function) {
        SOUND_GROUP_MAP.put(block, function);
    }

    static void addBlock(Block block, SoundType soundGroup) {
        SOUND_GROUP_MAP.put(block, (state) -> soundGroup);
    }

    static {
        addBlock(Blocks.GRASS, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.DEAD_BUSH, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.TALL_GRASS, DecibelSoundTypes.LARGE_PLANT);

        addBlock(Blocks.ALLIUM, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.AZURE_BLUET, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.BLUE_ORCHID, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.CORNFLOWER, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.DANDELION, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.LILY_OF_THE_VALLEY, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.ORANGE_TULIP, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.OXEYE_DAISY, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.PINK_TULIP, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.POPPY, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.RED_TULIP, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.WHITE_TULIP, DecibelSoundTypes.SMALL_PLANT);
        addBlock(Blocks.WITHER_ROSE, DecibelSoundTypes.SMALL_PLANT);

        addBlock(Blocks.LILAC, DecibelSoundTypes.LARGE_PLANT);
        addBlock(Blocks.PEONY, DecibelSoundTypes.LARGE_PLANT);
        addBlock(Blocks.ROSE_BUSH, DecibelSoundTypes.LARGE_PLANT);
        addBlock(Blocks.SUNFLOWER, DecibelSoundTypes.LARGE_PLANT);

        addBlock(Blocks.FERN, DecibelSoundTypes.GENERIC_LEAVES);
        addBlock(Blocks.LARGE_FERN, DecibelSoundTypes.GENERIC_LEAVES);

        addBlock(Blocks.CACTUS, DecibelSoundTypes.CACTUS);

        addBlock(Blocks.GRASS_BLOCK, DecibelSoundTypes.GRASS_BLOCK);
        addBlock(Blocks.COARSE_DIRT, DecibelSoundTypes.COARSE_DIRT);
        addBlock(Blocks.SAND, DecibelSoundTypes.SAND);
        addBlock(Blocks.RED_SAND, DecibelSoundTypes.SAND);

        addBlock(Blocks.DIRT, DecibelSoundTypes.DIRT);
        addBlock(Blocks.DIRT_PATH, DecibelSoundTypes.DIRT);
        addBlock(Blocks.PODZOL, DecibelSoundTypes.PODZOL);

        addBlock(Blocks.FARMLAND, (state) -> state.getValue(FarmBlock.MOISTURE) == 7 ? DecibelSoundTypes.WET_FARMLAND : DecibelSoundTypes.FARMLAND);

        addBlock(Blocks.CLAY, DecibelSoundTypes.CLAY);
        addBlock(Blocks.GRAVEL, DecibelSoundTypes.GRAVEL);

        addBlock(Blocks.COBWEB, DecibelSoundTypes.COBWEB);

        addBlock(Blocks.GOLD_BLOCK, DecibelSoundTypes.METAL);
        addBlock(Blocks.IRON_BLOCK, DecibelSoundTypes.METAL);

        addBlock(Blocks.ACACIA_SAPLING, DecibelSoundTypes.SAPLING);
        addBlock(Blocks.BIRCH_SAPLING, DecibelSoundTypes.SAPLING);
        addBlock(Blocks.DARK_OAK_SAPLING, DecibelSoundTypes.SAPLING);
        addBlock(Blocks.JUNGLE_SAPLING, DecibelSoundTypes.SAPLING);
        addBlock(Blocks.MANGROVE_PROPAGULE, DecibelSoundTypes.SAPLING);
        addBlock(Blocks.OAK_SAPLING, DecibelSoundTypes.SAPLING);
        addBlock(Blocks.SPRUCE_SAPLING, DecibelSoundTypes.SAPLING);

        addBlock(Blocks.SUGAR_CANE, DecibelSoundTypes.SUGAR_CANE);
    }
}