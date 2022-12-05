package com.ninni.decibel.sound;

import java.util.Map;

import com.google.common.collect.Maps;
import com.ninni.decibel.util.DecibelUtil;
import com.ninni.decibel.util.SoundEventFunction;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ItemSoundModifications {

    public static final Map<Item, SoundEventFunction<ItemStack>> BEGIN_USING_SOUNDS = Maps.newHashMap();
    public static final Map<Item, SoundEventFunction<ItemStack>> EATING_SOUNDS = Maps.newHashMap();
    public static final Map<Item, SoundEventFunction<ItemStack>> ATTACK_SOUNDS = Maps.newHashMap();

    static void addBeginUsing(Item item, SoundEventFunction<ItemStack> function) {
        BEGIN_USING_SOUNDS.put(item, function);
    }

    static void addBeginUsing(Item item, SoundEvent sound) {
        addBeginUsing(item, (stack) -> sound);
    }

    static void addAttack(Item item, SoundEventFunction<ItemStack> function) {
        ATTACK_SOUNDS.put(item, function);
    }

    static void addAttack(Item item, SoundEvent sound) {
        addAttack(item, (stack) -> sound);
    }

    static void addEating(Item item, SoundEventFunction<ItemStack> function) {
        EATING_SOUNDS.put(item, function);
    }

    static void addEating(Item item, SoundEvent sound) {
        addEating(item, (stack) -> sound);
    }

    private static void addAttackSounds() {
        addAttack(Items.WOODEN_SWORD, DecibelSounds.METAL_SWORD_SWING);
        addAttack(Items.WOODEN_PICKAXE, DecibelSounds.METAL_PICKAXE_SWING);
        addAttack(Items.WOODEN_AXE, DecibelSounds.METAL_AXE_SWING);
        addAttack(Items.WOODEN_SHOVEL, DecibelSounds.METAL_SHOVEL_SWING);
        addAttack(Items.WOODEN_HOE, DecibelSounds.METAL_HOE_SWING);

        addAttack(Items.STONE_SWORD, DecibelSounds.METAL_SWORD_SWING);
        addAttack(Items.STONE_PICKAXE, DecibelSounds.METAL_PICKAXE_SWING);
        addAttack(Items.STONE_AXE, DecibelSounds.METAL_AXE_SWING);
        addAttack(Items.STONE_SHOVEL, DecibelSounds.METAL_SHOVEL_SWING);
        addAttack(Items.STONE_HOE, DecibelSounds.METAL_HOE_SWING);

        addAttack(Items.IRON_SWORD, DecibelSounds.METAL_SWORD_SWING);
        addAttack(Items.IRON_PICKAXE, DecibelSounds.METAL_PICKAXE_SWING);
        addAttack(Items.IRON_AXE, DecibelSounds.METAL_AXE_SWING);
        addAttack(Items.IRON_SHOVEL, DecibelSounds.METAL_SHOVEL_SWING);
        addAttack(Items.IRON_HOE, DecibelSounds.METAL_HOE_SWING);

        addAttack(Items.GOLDEN_SWORD, DecibelSounds.METAL_SWORD_SWING);
        addAttack(Items.GOLDEN_PICKAXE, DecibelSounds.METAL_PICKAXE_SWING);
        addAttack(Items.GOLDEN_AXE, DecibelSounds.METAL_AXE_SWING);
        addAttack(Items.GOLDEN_SHOVEL, DecibelSounds.METAL_SHOVEL_SWING);
        addAttack(Items.GOLDEN_HOE, DecibelSounds.METAL_HOE_SWING);

        addAttack(Items.DIAMOND_SWORD, DecibelSounds.METAL_SWORD_SWING);
        addAttack(Items.DIAMOND_PICKAXE, DecibelSounds.METAL_PICKAXE_SWING);
        addAttack(Items.DIAMOND_AXE, DecibelSounds.METAL_AXE_SWING);
        addAttack(Items.DIAMOND_SHOVEL, DecibelSounds.METAL_SHOVEL_SWING);
        addAttack(Items.DIAMOND_HOE, DecibelSounds.METAL_HOE_SWING);
        
        addAttack(Items.NETHERITE_SWORD, DecibelSounds.METAL_SWORD_SWING);
        addAttack(Items.NETHERITE_PICKAXE, DecibelSounds.METAL_PICKAXE_SWING);
        addAttack(Items.NETHERITE_AXE, DecibelSounds.METAL_AXE_SWING);
        addAttack(Items.NETHERITE_SHOVEL, DecibelSounds.METAL_SHOVEL_SWING);
        addAttack(Items.NETHERITE_HOE, DecibelSounds.METAL_HOE_SWING);
    }

    private static void addBeginUsingSounds() {
        addBeginUsing(Items.SHIELD, DecibelSounds.SHIELD_USE);
        addBeginUsing(Items.BOW, ((stack) -> DecibelUtil.hasFlame(stack) ? DecibelSounds.BOW_PULL_FLAME : DecibelSounds.BOW_PULL));
    }

    private static void addEatingSounds() {
        addEating(Items.APPLE, DecibelSounds.APPLE_EAT);
        addEating(Items.GOLDEN_APPLE, DecibelSounds.GOLDEN_APPLE_EAT);
        addEating(Items.ENCHANTED_GOLDEN_APPLE, DecibelSounds.GOLDEN_APPLE_EAT);

        addEating(Items.BREAD, DecibelSounds.BREAD_EAT);
        addEating(Items.CHORUS_FRUIT, DecibelSounds.CHORUS_FRUIT_EAT);
    }

    static {
        addAttackSounds();
        addBeginUsingSounds();
        addEatingSounds();
    }
}