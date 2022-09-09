package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ninni.decibel.sound.DecibelSoundEvents;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends Item {
    public BowItemMixin(Settings settings) {
        super(settings);
    }

    @Unique
    private ItemStack lastStack;

    @Unique
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient()) {
            float useTime = getMaxUseTime(stack) - remainingUseTicks;
            if (useTime == 18) {
                var soundEvent = EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0 ? DecibelSoundEvents.ITEM_BOW_PULL_FINISH_IGNITE : DecibelSoundEvents.ITEM_BOW_PULL_FINISH;
                world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, SoundCategory.PLAYERS, 1, 1);
            }
        }
    }

    @Inject(method = "onStoppedUsing", at = @At(value = "HEAD"))
    private void getStack(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        lastStack = stack;
    }

    @Inject(method = "onStoppedUsing", at = @At(value = "TAIL"))
    private void forgetStack(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        lastStack = null;
    }

    @ModifyArg(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"), index = 4)
    private SoundEvent changeSound(SoundEvent sound) {
        if (lastStack != null && EnchantmentHelper.getLevel(Enchantments.FLAME, lastStack) > 0) {
            return DecibelSoundEvents.ITEM_BOW_SHOOT_FLAME;
        } else {
            return DecibelSoundEvents.ITEM_BOW_SHOOT;
        }
    }
}