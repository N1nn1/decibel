package com.ninni.decibel.sound;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;

import java.util.Map;

public class ItemSoundModifications {

    public static final Map<Item, SoundEvent> SOUND_GROUP_MAP = Maps.newHashMap();

    static void addItem(Item item, SoundEvent soundEvent) {
        SOUND_GROUP_MAP.put(item, soundEvent);
    }

    public static void init() {
        addItem(Items.APPLE, DecibelSoundEvents.ITEM_APPLE_EAT);
        addItem(Items.GOLDEN_APPLE, DecibelSoundEvents.ITEM_APPLE_EAT);
        addItem(Items.ENCHANTED_GOLDEN_APPLE, DecibelSoundEvents.ITEM_APPLE_EAT);
    }
}
