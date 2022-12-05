package com.ninni.decibel.sound;

import com.ninni.decibel.Decibel;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class DecibelSounds {

    public static final SoundEvent SOUL_FIRE_AMBIENT = DecibelSounds.register("block.soul_fire.ambient");
    
    public static final SoundEvent APPLE_EAT = DecibelSounds.register("item.apple.eat");
    public static final SoundEvent GOLDEN_APPLE_EAT = DecibelSounds.register("item.golden_apple.eat");
    public static final SoundEvent BREAD_EAT = DecibelSounds.register("item.bread.eat");
    public static final SoundEvent CHORUS_FRUIT_EAT = DecibelSounds.register("item.chorus_fruit.eat");
    public static final SoundEvent CHORUS_FRUIT_BURP = DecibelSounds.register("item.chorus_fruit.burp");

    public static final SoundEvent BOW_PULL = DecibelSounds.register("item.bow.pull");
    public static final SoundEvent BOW_PULL_FLAME = DecibelSounds.register("item.bow.pull_flame");
    public static final SoundEvent BOW_PULL_FINISH = DecibelSounds.register("item.bow.pull_finish");
    public static final SoundEvent BOW_PULL_FINISH_FLAME = DecibelSounds.register("item.bow.pull_finish_flame");
    public static final SoundEvent BOW_SHOOT = DecibelSounds.register("item.bow.shoot");
    public static final SoundEvent BOW_SHOOT_FLAME = DecibelSounds.register("item.bow.shoot_flame");

    public static final SoundEvent METAL_SWORD_SWING = DecibelSounds.register("item.metal_sword.swing");
    public static final SoundEvent METAL_PICKAXE_SWING = DecibelSounds.register("item.metal_pickaxe.swing");
    public static final SoundEvent METAL_AXE_SWING = DecibelSounds.register("item.metal_axe.swing");
    public static final SoundEvent METAL_SHOVEL_SWING = DecibelSounds.register("item.metal_shovel.swing");
    public static final SoundEvent METAL_HOE_SWING = DecibelSounds.register("item.metal_hoe.swing");

    public static final SoundEvent SHIELD_USE = DecibelSounds.register("item.shield.use");

    public static final SoundEvent ENDER_PEARL_THROW = DecibelSounds.register("item.ender_pearl.throw");
    public static final SoundEvent ENDER_PEARL_LAND = DecibelSounds.register("item.ender_pearl.land");

    public static SoundEvent register(String name) {
        ResourceLocation id = Decibel.id(name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}