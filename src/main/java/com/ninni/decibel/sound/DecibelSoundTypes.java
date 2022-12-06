package com.ninni.decibel.sound;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class DecibelSoundTypes {

    public static final SoundType CACTUS = Type.of("cactus");
    public static final SoundType CLAY = Type.of("clay");
    public static final SoundType COARSE_DIRT = Type.of("coarse_dirt");
    public static final SoundType PODZOL = Type.of("podzol");
    public static final SoundType DIRT = Type.of("dirt");
    public static final SoundType FARMLAND = Type.of("farmland");
    public static final SoundType GENERIC_LEAVES = Type.of("generic_leaves");
    public static final SoundType SAPLING = Type.of("sapling");
    public static final SoundType GLASS = Type.of("glass");
    public static final SoundType GRASS_BLOCK = Type.of("grass_block");
    public static final SoundType SMALL_PLANT = Type.of("small_plant");
    public static final SoundType LARGE_PLANT = Type.of("large_plant");
    public static final SoundType COBWEB = Type.of("cobweb");
    public static final SoundType GRAVEL = Type.of("gravel");
    public static final SoundType METAL = Type.of("metal");
    public static final SoundType WET_FARMLAND = Type.of("wet_farmland");
    public static final SoundType SAND = Type.of("sand");
    public static final SoundType SUGAR_CANE = Type.of("sugar_cane");

    private static class Type extends SoundType {
        private Type(String name) {
            super(1, 1, register(name, "break"), register(name, "step"), register(name, "place"), register(name, "hit"), register(name, "fall"));
        }
    
        private static SoundEvent register(String name, String type) {
            return DecibelSounds.register("block." + name + "." + type);
        }

        public static Type of(String name) {
            return new Type(name);
        }
    }
}