package com.ninni.decibel.sound;

import com.ninni.decibel.Decibel;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DecibelSoundGroups {

    // can someone make a mixin to actually use this lmao
    public static final SoundEvent BLOCK_SOUL_FIRE_AMBIENT = register("block.soul_fire.ambient");

    public static final BlockSoundGroup CACTUS = register("cactus", 1, 1);
    public static final BlockSoundGroup CLAY = register("clay", 1, 1);
    public static final BlockSoundGroup COARSE_DIRT = register("coarse_dirt", 1, 1);
    public static final BlockSoundGroup DIRT = register("dirt", 1, 1);
    public static final BlockSoundGroup GENERIC_LEAVES = register("generic_leaves", 1, 1);
    public static final BlockSoundGroup SAPLING = register("sapling", 1, 1);
    public static final BlockSoundGroup GLASS = register("glass", 1, 1);
    public static final BlockSoundGroup GRASS_BLOCK = register("grass_block", 1, 1);
    public static final BlockSoundGroup SMALL_PLANT = register("small_plant", 1, 1);
    public static final BlockSoundGroup LARGE_PLANT = register("large_plant", 1, 1);
    public static final BlockSoundGroup COBWEB = register("cobweb", 1, 1);
    public static final BlockSoundGroup GRAVEL = register("gravel", 1, 1);
    public static final BlockSoundGroup METAL = register("metal", 1, 1);

    private static BlockSoundGroup register(String name, float volume, float pitch) {
        return new BlockSoundGroup(volume, pitch, register(block(name, "break")), register(block(name, "step")), register(block(name, "place")), register(block(name, "hit")), register(block(name, "fall")));
    }

    private static SoundEvent register(String name) {
        Identifier id = Decibel.id(name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    private static String block(String name, String append) {
        return "block." + name + "." + append;
    }
}