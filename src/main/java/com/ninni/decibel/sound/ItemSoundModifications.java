package com.ninni.decibel.sound;

import java.util.Map;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import com.google.common.collect.Maps;
import com.ninni.decibel.SoundEventFunction;

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
        addSwing(Items.WOODEN_SWORD, DecibelSoundEvents.SWORD_SWING);
        addSwing(Items.WOODEN_PICKAXE, DecibelSoundEvents.PICKAXE_SWING);
        addSwing(Items.WOODEN_AXE, DecibelSoundEvents.AXE_SWING);
        addSwing(Items.WOODEN_SHOVEL, DecibelSoundEvents.SHOVEL_SWING);
        addSwing(Items.WOODEN_HOE, DecibelSoundEvents.HOE_SWING);

        addSwing(Items.STONE_SWORD, DecibelSoundEvents.SWORD_SWING);
        addSwing(Items.STONE_PICKAXE, DecibelSoundEvents.PICKAXE_SWING);
        addSwing(Items.STONE_AXE, DecibelSoundEvents.AXE_SWING);
        addSwing(Items.STONE_SHOVEL, DecibelSoundEvents.SHOVEL_SWING);
        addSwing(Items.STONE_HOE, DecibelSoundEvents.HOE_SWING);

        addSwing(Items.IRON_SWORD, DecibelSoundEvents.SWORD_SWING);
        addSwing(Items.IRON_PICKAXE, DecibelSoundEvents.PICKAXE_SWING);
        addSwing(Items.IRON_AXE, DecibelSoundEvents.AXE_SWING);
        addSwing(Items.IRON_SHOVEL, DecibelSoundEvents.SHOVEL_SWING);
        addSwing(Items.IRON_HOE, DecibelSoundEvents.HOE_SWING);

        addSwing(Items.GOLDEN_SWORD, DecibelSoundEvents.SWORD_SWING);
        addSwing(Items.GOLDEN_PICKAXE, DecibelSoundEvents.PICKAXE_SWING);
        addSwing(Items.GOLDEN_AXE, DecibelSoundEvents.AXE_SWING);
        addSwing(Items.GOLDEN_SHOVEL, DecibelSoundEvents.SHOVEL_SWING);
        addSwing(Items.GOLDEN_HOE, DecibelSoundEvents.HOE_SWING);

        addSwing(Items.DIAMOND_SWORD, DecibelSoundEvents.SWORD_SWING);
        addSwing(Items.DIAMOND_PICKAXE, DecibelSoundEvents.PICKAXE_SWING);
        addSwing(Items.DIAMOND_AXE, DecibelSoundEvents.AXE_SWING);
        addSwing(Items.DIAMOND_SHOVEL, DecibelSoundEvents.SHOVEL_SWING);
        addSwing(Items.DIAMOND_HOE, DecibelSoundEvents.HOE_SWING);
        
        addSwing(Items.NETHERITE_SWORD, DecibelSoundEvents.SWORD_SWING);
        addSwing(Items.NETHERITE_PICKAXE, DecibelSoundEvents.PICKAXE_SWING);
        addSwing(Items.NETHERITE_AXE, DecibelSoundEvents.AXE_SWING);
        addSwing(Items.NETHERITE_SHOVEL, DecibelSoundEvents.SHOVEL_SWING);
        addSwing(Items.NETHERITE_HOE, DecibelSoundEvents.HOE_SWING);

        addUse(Items.SHIELD, DecibelSoundEvents.SHIELD_USE);

        addUse(Items.BOW, ((stack) -> {
            if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) {
                return DecibelSoundEvents.BOW_PULL_FLAME;
            } else {
                return DecibelSoundEvents.BOW_PULL;
            }
        }));

        addFood(Items.APPLE, DecibelSoundEvents.APPLE_EAT);
        addFood(Items.GOLDEN_APPLE, DecibelSoundEvents.GOLDEN_APPLE_EAT);
        addFood(Items.ENCHANTED_GOLDEN_APPLE, DecibelSoundEvents.GOLDEN_APPLE_EAT);

        addFood(Items.BREAD, DecibelSoundEvents.BREAD_EAT);
        addFood(Items.CHORUS_FRUIT, DecibelSoundEvents.CHORUS_EAT);
    }
}