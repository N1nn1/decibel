package com.ninni.decibel.sound;

import static com.ninni.decibel.Decibel.MOD_ID;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class DecibelSoundEvents {
    
    public static final SoundEvent APPLE_EAT = createItemSound("apple", "eat");
    public static final SoundEvent GOLDEN_APPLE_EAT = createItemSound("golden_apple", "eat");
    public static final SoundEvent BREAD_EAT = createItemSound("bread", "eat");
    public static final SoundEvent CHORUS_EAT = createItemSound("chorus", "eat");
    public static final SoundEvent CHORUS_BURP = createItemSound("chorus", "burp");

    public static final SoundEvent BOW_PULL = createItemSound("bow", "pull");
    public static final SoundEvent BOW_PULL_FLAME = createItemSound("bow", "pull_flame");
    public static final SoundEvent BOW_PULL_FINISH = createItemSound("bow", "pull_finish");
    public static final SoundEvent BOW_PULL_FINISH_IGNITE = createItemSound("bow", "pull_finish_ignite");
    public static final SoundEvent BOW_SHOOT = createItemSound("bow", "shoot");
    public static final SoundEvent BOW_SHOOT_FLAME = createItemSound("bow", "shoot_flame");

    public static final SoundEvent SWORD_SWING = createItemSound("sword", "swing");
    public static final SoundEvent PICKAXE_SWING = createItemSound("pickaxe", "swing");
    public static final SoundEvent AXE_SWING = createItemSound("axe", "swing");
    public static final SoundEvent SHOVEL_SWING = createItemSound("shovel", "swing");
    public static final SoundEvent HOE_SWING = createItemSound("hoe", "swing");

    public static final SoundEvent SHIELD_USE = createItemSound("shield", "use");

    public static final SoundEvent ENDER_PEARL_THROW = createItemSound("ender_pearl", "throw");

    public static SoundEvent createItemSound(String item, String type) {
        ResourceLocation identifier = new ResourceLocation(MOD_ID, "item." + item + "." + type);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }
}