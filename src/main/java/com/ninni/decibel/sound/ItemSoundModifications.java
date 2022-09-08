package com.ninni.decibel.sound;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;

public class ItemSoundModifications {

    public static final Map<Item, SoundEvent> EAT_SOUND_MAP = Maps.newHashMap();

    static void addFood(Item item, SoundEvent soundEvent) {
        EAT_SOUND_MAP.put(item, soundEvent);
    }

    public static void init() {
        addFood(Items.APPLE, DecibelSoundEvents.ITEM_APPLE_EAT);
        addFood(Items.GOLDEN_APPLE, DecibelSoundEvents.ITEM_GOLDEN_APPLE_EAT);
        addFood(Items.ENCHANTED_GOLDEN_APPLE, DecibelSoundEvents.ITEM_GOLDEN_APPLE_EAT);
    }
}