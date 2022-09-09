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
    public static final Map<Item, SoundEventFunction<ItemStack>> SWINGING_MAP = Maps.newHashMap();

    static void addUse(Item item, SoundEventFunction<ItemStack> function) {
        USING_MAP.put(item, function);
    }

    static void addUse(Item item, SoundEvent soundEvent) {
        USING_MAP.put(item, (stack) -> soundEvent);
    }

    static void addSwing(Item item, SoundEventFunction<ItemStack> function) {
        SWINGING_MAP.put(item, function);
    }
    static void addSwing(Item item, SoundEvent soundEvent) {
        SWINGING_MAP.put(item, (stack) -> soundEvent);
    }

    static void addFood(Item item, SoundEventFunction<ItemStack> function) {
        EATING_MAP.put(item, function);
    }

    static void addFood(Item item, SoundEvent soundEvent) {
        EATING_MAP.put(item, (stack) -> soundEvent);
    }

    public static void init() {
        addSwing(Items.WOODEN_SWORD, DecibelSoundEvents.ITEM_SWORD_SWING);
        addSwing(Items.WOODEN_PICKAXE, DecibelSoundEvents.ITEM_PICKAXE_SWING);
        addSwing(Items.WOODEN_AXE, DecibelSoundEvents.ITEM_AXE_SWING);
        addSwing(Items.WOODEN_SHOVEL, DecibelSoundEvents.ITEM_SHOVEL_SWING);
        addSwing(Items.WOODEN_HOE, DecibelSoundEvents.ITEM_HOE_SWING);

        addSwing(Items.STONE_SWORD, DecibelSoundEvents.ITEM_SWORD_SWING);
        addSwing(Items.STONE_PICKAXE, DecibelSoundEvents.ITEM_PICKAXE_SWING);
        addSwing(Items.STONE_AXE, DecibelSoundEvents.ITEM_AXE_SWING);
        addSwing(Items.STONE_SHOVEL, DecibelSoundEvents.ITEM_SHOVEL_SWING);
        addSwing(Items.STONE_HOE, DecibelSoundEvents.ITEM_HOE_SWING);

        addSwing(Items.IRON_SWORD, DecibelSoundEvents.ITEM_SWORD_SWING);
        addSwing(Items.IRON_PICKAXE, DecibelSoundEvents.ITEM_PICKAXE_SWING);
        addSwing(Items.IRON_AXE, DecibelSoundEvents.ITEM_AXE_SWING);
        addSwing(Items.IRON_SHOVEL, DecibelSoundEvents.ITEM_SHOVEL_SWING);
        addSwing(Items.IRON_HOE, DecibelSoundEvents.ITEM_HOE_SWING);

        addSwing(Items.GOLDEN_SWORD, DecibelSoundEvents.ITEM_SWORD_SWING);
        addSwing(Items.GOLDEN_PICKAXE, DecibelSoundEvents.ITEM_PICKAXE_SWING);
        addSwing(Items.GOLDEN_AXE, DecibelSoundEvents.ITEM_AXE_SWING);
        addSwing(Items.GOLDEN_SHOVEL, DecibelSoundEvents.ITEM_SHOVEL_SWING);
        addSwing(Items.GOLDEN_HOE, DecibelSoundEvents.ITEM_HOE_SWING);

        addSwing(Items.DIAMOND_SWORD, DecibelSoundEvents.ITEM_SWORD_SWING);
        addSwing(Items.DIAMOND_PICKAXE, DecibelSoundEvents.ITEM_PICKAXE_SWING);
        addSwing(Items.DIAMOND_AXE, DecibelSoundEvents.ITEM_AXE_SWING);
        addSwing(Items.DIAMOND_SHOVEL, DecibelSoundEvents.ITEM_SHOVEL_SWING);
        addSwing(Items.DIAMOND_HOE, DecibelSoundEvents.ITEM_HOE_SWING);
        
        addSwing(Items.NETHERITE_SWORD, DecibelSoundEvents.ITEM_SWORD_SWING);
        addSwing(Items.NETHERITE_PICKAXE, DecibelSoundEvents.ITEM_PICKAXE_SWING);
        addSwing(Items.NETHERITE_AXE, DecibelSoundEvents.ITEM_AXE_SWING);
        addSwing(Items.NETHERITE_SHOVEL, DecibelSoundEvents.ITEM_SHOVEL_SWING);
        addSwing(Items.NETHERITE_HOE, DecibelSoundEvents.ITEM_HOE_SWING);

        addUse(Items.SHIELD, DecibelSoundEvents.ITEM_SHIELD_USE);

        addUse(Items.BOW, ((stack) -> {
            if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                return DecibelSoundEvents.ITEM_BOW_PULL_FLAME;
            } else {
                return DecibelSoundEvents.ITEM_BOW_PULL;
            }
        }));

        addFood(Items.APPLE, DecibelSoundEvents.ITEM_APPLE_EAT);
        addFood(Items.GOLDEN_APPLE, DecibelSoundEvents.ITEM_GOLDEN_APPLE_EAT);
        addFood(Items.ENCHANTED_GOLDEN_APPLE, DecibelSoundEvents.ITEM_GOLDEN_APPLE_EAT);
    }
}