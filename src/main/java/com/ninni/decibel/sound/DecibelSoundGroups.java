package com.ninni.decibel.sound;

import com.ninni.decibel.Decibel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class DecibelSoundGroups {

    // can someone make a mixin to actually use this lmao
    public static final SoundEvent BLOCK_SOUL_FIRE_AMBIENT = register("block.soul_fire.ambient");

    public static final SoundType CACTUS = register("cactus", 1, 1);
    public static final SoundType CLAY = register("clay", 1, 1);
    public static final SoundType COARSE_DIRT = register("coarse_dirt", 1, 1);
    public static final SoundType PODZOL = register("podzol", 1, 1);
    public static final SoundType DIRT = register("dirt", 1, 1);
    public static final SoundType FARMLAND = register("farmland", 1, 1);
    public static final SoundType GENERIC_LEAVES = register("generic_leaves", 1, 1);
    public static final SoundType SAPLING = register("sapling", 1, 1);
    public static final SoundType GLASS = register("glass", 1, 1);
    public static final SoundType GRASS_BLOCK = register("grass_block", 1, 1);
    public static final SoundType SMALL_PLANT = register("small_plant", 1, 1);
    public static final SoundType LARGE_PLANT = register("large_plant", 1, 1);
    public static final SoundType COBWEB = register("cobweb", 1, 1);
    public static final SoundType GRAVEL = register("gravel", 1, 1);
    public static final SoundType METAL = register("metal", 1, 1);
    public static final SoundType WET_FARMLAND = register("wet_farmland", 1, 1);
    public static final SoundType SAND = register("sand", 1, 1);

    private static SoundType register(String name, float volume, float pitch) {
        return new SoundType(volume, pitch, register(block(name, "break")), register(block(name, "step")), register(block(name, "place")), register(block(name, "hit")), register(block(name, "fall")));
    }

    private static SoundEvent register(String name) {
        ResourceLocation id = Decibel.id(name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    private static String block(String name, String append) {
        return "block." + name + "." + append;
    }
}