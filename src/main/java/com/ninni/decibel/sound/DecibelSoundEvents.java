package com.ninni.decibel.sound;

import static com.ninni.decibel.Decibel.MOD_ID;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DecibelSoundEvents {

    public static SoundEvent ITEM_APPLE_EAT = createItemSound("apple", "eat");
    public static SoundEvent ITEM_GOLDEN_APPLE_EAT = createItemSound("golden_apple", "eat");

    public static SoundEvent createItemSound(String item, String type) {
        Identifier identifier = new Identifier(MOD_ID, "item." + item + "." + type);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }
}