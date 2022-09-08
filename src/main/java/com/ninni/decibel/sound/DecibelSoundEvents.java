package com.ninni.decibel.sound;

import static com.ninni.decibel.Decibel.MOD_ID;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DecibelSoundEvents {
    
    public static final SoundEvent ITEM_APPLE_EAT = createItemSound("apple", "eat");
    public static final SoundEvent ITEM_BOW_PULL = createItemSound("bow", "pull");
    public static final SoundEvent ITEM_BOW_PULL_FLAME = createItemSound("bow", "pull_flame");
    public static final SoundEvent ITEM_BOW_PULL_FINISH = createItemSound("bow", "pull_finish");
    public static final SoundEvent ITEM_BOW_PULL_FINISH_IGNITE = createItemSound("bow", "pull_finish_ignite");
    public static final SoundEvent ITEM_BOW_SHOOT = createItemSound("bow", "shoot");
    public static final SoundEvent ITEM_BOW_SHOOT_FLAME = createItemSound("bow", "shoot_flame");
    public static final SoundEvent ITEM_SHIELD_USE = createItemSound("shield", "use");
    public static final SoundEvent ITEM_ENDER_PEARL_THROW = createItemSound("ender_pearl", "throw");
    public static final SoundEvent ITEM_GOLDEN_APPLE_EAT = createItemSound("golden_apple", "eat");

    public static SoundEvent createItemSound(String item, String type) {
        Identifier identifier = new Identifier(MOD_ID, "item." + item + "." + type);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }
}