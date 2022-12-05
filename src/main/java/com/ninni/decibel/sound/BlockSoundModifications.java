package com.ninni.decibel.sound;

import java.util.Map;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import com.google.common.collect.Maps;
import com.ninni.decibel.SoundGroupFunction;

public class BlockSoundModifications {

    public static final Map<Block, SoundGroupFunction<BlockState>> SOUND_GROUP_MAP = Maps.newHashMap();

    static void addBlock(Block block, SoundGroupFunction<BlockState> function) {
        SOUND_GROUP_MAP.put(block, function);
    }

    static void addBlock(Block block, SoundType soundGroup) {
        SOUND_GROUP_MAP.put(block, (state) -> soundGroup);
    }

    static void addSapling(Block block) {
        addBlock(block, DecibelSoundGroups.SAPLING);
    }

    public static void init() {
        addBlock(Blocks.GRASS, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.DEAD_BUSH, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.TALL_GRASS, DecibelSoundGroups.LARGE_PLANT);

        addBlock(Blocks.ALLIUM, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.AZURE_BLUET, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.BLUE_ORCHID, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.CORNFLOWER, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.DANDELION, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.LILY_OF_THE_VALLEY, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.ORANGE_TULIP, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.OXEYE_DAISY, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.PINK_TULIP, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.POPPY, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.RED_TULIP, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.WHITE_TULIP, DecibelSoundGroups.SMALL_PLANT);
        addBlock(Blocks.WITHER_ROSE, DecibelSoundGroups.SMALL_PLANT);

        addBlock(Blocks.LILAC, DecibelSoundGroups.LARGE_PLANT);
        addBlock(Blocks.PEONY, DecibelSoundGroups.LARGE_PLANT);
        addBlock(Blocks.ROSE_BUSH, DecibelSoundGroups.LARGE_PLANT);
        addBlock(Blocks.SUNFLOWER, DecibelSoundGroups.LARGE_PLANT);

        addBlock(Blocks.FERN, DecibelSoundGroups.GENERIC_LEAVES);
        addBlock(Blocks.LARGE_FERN, DecibelSoundGroups.GENERIC_LEAVES);

        addBlock(Blocks.CACTUS, DecibelSoundGroups.CACTUS);

        addBlock(Blocks.GRASS_BLOCK, DecibelSoundGroups.GRASS_BLOCK);
        addBlock(Blocks.COARSE_DIRT, DecibelSoundGroups.COARSE_DIRT);
        addBlock(Blocks.SAND, DecibelSoundGroups.SAND);
        addBlock(Blocks.RED_SAND, DecibelSoundGroups.SAND);


        addBlock(Blocks.DIRT, DecibelSoundGroups.DIRT);
        addBlock(Blocks.DIRT_PATH, DecibelSoundGroups.DIRT);
        addBlock(Blocks.PODZOL, DecibelSoundGroups.PODZOL);

        addBlock(Blocks.FARMLAND, (state) -> state.getValue(FarmBlock.MOISTURE) == 7 ? DecibelSoundGroups.WET_FARMLAND : DecibelSoundGroups.FARMLAND);

        addBlock(Blocks.CLAY, DecibelSoundGroups.CLAY);
        addBlock(Blocks.GRAVEL, DecibelSoundGroups.GRAVEL);

        addBlock(Blocks.COBWEB, DecibelSoundGroups.COBWEB);

        addBlock(Blocks.GOLD_BLOCK, DecibelSoundGroups.METAL);
        addBlock(Blocks.IRON_BLOCK, DecibelSoundGroups.METAL);

        addSapling(Blocks.ACACIA_SAPLING);
        addSapling(Blocks.BIRCH_SAPLING);
        addSapling(Blocks.DARK_OAK_SAPLING);
        addSapling(Blocks.JUNGLE_SAPLING);
        addSapling(Blocks.MANGROVE_PROPAGULE);
        addSapling(Blocks.OAK_SAPLING);
        addSapling(Blocks.SPRUCE_SAPLING);
    }
}