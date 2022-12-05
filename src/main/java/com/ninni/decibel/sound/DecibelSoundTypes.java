package com.ninni.decibel.sound;

import net.minecraft.world.level.block.SoundType;

public class DecibelSoundTypes {

    public static final SoundType CACTUS = register("cactus");
    public static final SoundType CLAY = register("clay");
    public static final SoundType COARSE_DIRT = register("coarse_dirt");
    public static final SoundType PODZOL = register("podzol");
    public static final SoundType DIRT = register("dirt");
    public static final SoundType FARMLAND = register("farmland");
    public static final SoundType GENERIC_LEAVES = register("generic_leaves");
    public static final SoundType SAPLING = register("sapling");
    public static final SoundType GLASS = register("glass");
    public static final SoundType GRASS_BLOCK = register("grass_block");
    public static final SoundType SMALL_PLANT = register("small_plant");
    public static final SoundType LARGE_PLANT = register("large_plant");
    public static final SoundType COBWEB = register("cobweb");
    public static final SoundType GRAVEL = register("gravel");
    public static final SoundType METAL = register("metal");
    public static final SoundType WET_FARMLAND = register("wet_farmland");
    public static final SoundType SAND = register("sand");

    private static SoundType register(String name) {
        return new SoundType(1, 1, DecibelSounds.register("block." + name + ".break"), DecibelSounds.register("block." + name + ".step"), DecibelSounds.register("block." + name + ".place"), DecibelSounds.register("block." + name + ".hit"), DecibelSounds.register("block." + name + ".fall"));
    }
}