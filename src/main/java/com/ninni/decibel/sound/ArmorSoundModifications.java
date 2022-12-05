package com.ninni.decibel.sound;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;

public class ArmorSoundModifications {

    public static final Map<ArmorMaterial, SoundEvent> SOUND_MAP = Maps.newHashMap();
    
    static {
        for (ArmorMaterial material : ArmorMaterials.values()) {
            SOUND_MAP.putIfAbsent(material, DecibelSounds.register("armor." + material.getName() + ".step"));
        }
    }
}