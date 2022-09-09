package com.ninni.decibel.sound;

import static com.ninni.decibel.Decibel.MOD_ID;

import java.util.Map;

import com.google.common.collect.Maps;
import com.ninni.decibel.SoundEventFunction;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmorSoundModifications {

    public static final Map<ArmorMaterial, SoundEventFunction<ArmorMaterial>> SOUND_MAP = Maps.newHashMap();

    static void addArmor(ArmorMaterial material, SoundEvent sound) {
        SOUND_MAP.put(material, (state) -> sound);
    }

    public static SoundEvent createArmorSound(String armor, String type) {
        Identifier identifier = new Identifier(MOD_ID, "armor." + armor + "." + type);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }

    public static void init() {
        for (ArmorMaterial material : ArmorMaterials.values()) {
            if (SOUND_MAP.containsKey(material)) continue;
            addArmor(material, createArmorSound(material.getName(), "step"));
        }
    }
}