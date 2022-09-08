package com.ninni.decibel.sound;

import java.util.Map;

import com.google.common.collect.Maps;
import com.ninni.decibel.SoundEventFunction;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;

public class ItemSoundModifications {

    public static final Map<Item, SoundEventFunction<ItemStack>> USING_MAP = Maps.newHashMap();
    public static final Map<Item, SoundEventFunction<ItemStack>> EATING_MAP = Maps.newHashMap();

    static void addUse(Item item, SoundEventFunction<ItemStack> function) {
        USING_MAP.put(item, function);
    }

    static void addUse(Item item, SoundEvent soundEvent) {
        USING_MAP.put(item, (stack) -> soundEvent);
    }

    static void addFood(Item item, SoundEventFunction<ItemStack> function) {
        EATING_MAP.put(item, function);
    }

    static void addFood(Item item, SoundEvent soundEvent) {
        EATING_MAP.put(item, (stack) -> soundEvent);
    }

    public static void init() {
        addUse(Items.BOW, (stack) -> EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0 ? DecibelSoundEvents.ITEM_BOW_PULL_FLAME : DecibelSoundEvents.ITEM_BOW_PULL);
        addUse(Items.SHIELD, DecibelSoundEvents.ITEM_SHIELD_USE);
        addFood(Items.APPLE, DecibelSoundEvents.ITEM_APPLE_EAT);
        addFood(Items.GOLDEN_APPLE, DecibelSoundEvents.ITEM_GOLDEN_APPLE_EAT);
        addFood(Items.ENCHANTED_GOLDEN_APPLE, DecibelSoundEvents.ITEM_GOLDEN_APPLE_EAT);
    }
}