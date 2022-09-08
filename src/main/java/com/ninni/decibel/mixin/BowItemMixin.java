package com.ninni.decibel.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import com.ninni.decibel.sound.DecibelSoundEvents;

import net.minecraft.item.BowItem;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BowItem.class)
public abstract class BowItemMixin {
    @Unique private ItemStack stack;


    @Inject(method = "onStoppedUsing", at = @At(value = "HEAD"))
    private void getStack(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        this.stack = stack;
    }

    @Inject(method = "onStoppedUsing", at = @At(value = "TAIL"))
    private void forgetStack(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        this.stack = null;
    }

    @ModifyArg(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"), index = 4)
    private SoundEvent changeSound(SoundEvent sound) {
        if (this.stack != null) {
            if (EnchantmentHelper.getLevel(Enchantments.FLAME, this.stack) > 0) {
                return DecibelSoundEvents.ITEM_BOW_SHOOT_FLAME;
            }
        }
        return DecibelSoundEvents.ITEM_BOW_SHOOT;

    }

}