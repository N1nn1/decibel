package com.ninni.decibel.sound;

import com.google.common.collect.Maps;
import com.ninni.decibel.SoundEventFunction;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.sound.SoundEvent;

import java.util.Map;

public class ArmorSoundModifications {

    public static final Map<ArmorMaterial, SoundEventFunction<ArmorMaterial>> SOUND_MAP = Maps.newHashMap();

    static void addArmor(ArmorMaterial material, SoundEvent sound) {
        SOUND_MAP.put(material, (state) -> sound);
    }

    public static void init() {
        addArmor(ArmorMaterials.IRON, DecibelSoundEvents.ARMOR_IRON_STEP);
        addArmor(ArmorMaterials.CHAIN, DecibelSoundEvents.ARMOR_CHAINMAIL_STEP);
        addArmor(ArmorMaterials.DIAMOND, DecibelSoundEvents.ARMOR_DIAMOND_STEP);
        addArmor(ArmorMaterials.LEATHER, DecibelSoundEvents.ARMOR_LEATHER_STEP);
        addArmor(ArmorMaterials.NETHERITE, DecibelSoundEvents.ARMOR_NETHERITE_STEP);
        addArmor(ArmorMaterials.GOLD, DecibelSoundEvents.ARMOR_GOLD_STEP);
    }

}
