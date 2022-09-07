package com.ninni.decibel.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.ninni.decibel.Decibel.*;

public class DecibelSoundEvents {

    public static SoundEvent ITEM_APPLE_EAT  = apple("eat");
    public static SoundEvent apple(String type) { return createItemSound("apple", type); }


    public static SoundEvent createItemSound(String item, String type) {
        Identifier identifier = new Identifier(MOD_ID, "item." + item + "." + type);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }
}
