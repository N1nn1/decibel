package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ninni.decibel.Decibel;
import com.ninni.decibel.sound.DecibelSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends Item {
    public BowItemMixin(Properties settings) {
        super(settings);
    }

    @Unique
    private ItemStack lastStack;

    @Unique
    public void onUseTick(Level world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClientSide() && Decibel.getConfig().addBowReadySound) {
            float useTime = getUseDuration(stack) - remainingUseTicks;
            if (useTime == 18) {
                var soundEvent = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0 ? DecibelSoundEvents.BOW_PULL_FINISH_IGNITE : DecibelSoundEvents.BOW_PULL_FINISH;
                world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, SoundSource.PLAYERS, 1, 1);
            }
        }
    }

    @Inject(method = "releaseUsing", at = @At(value = "HEAD"))
    private void D$getStack(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        lastStack = stack;
    }

    @Inject(method = "releaseUsing", at = @At(value = "TAIL"))
    private void D$forgetStack(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        lastStack = null;
    }

    @ModifyArg(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"), index = 4)
    private SoundEvent D$changeSound(SoundEvent original) {
        if (!Decibel.getConfig().updateBowShootSound) return original;
        if (lastStack != null && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, lastStack) > 0) {
            return DecibelSoundEvents.BOW_SHOOT_FLAME;
        } else {
            return DecibelSoundEvents.BOW_SHOOT;
        }
    }
}