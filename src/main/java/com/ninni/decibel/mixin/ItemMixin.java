package com.ninni.decibel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.ninni.decibel.sound.ItemSoundModifications;

import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Inject(at = @At("HEAD"), method = "getEatSound", cancellable = true)
    private void getModifiedEatingSound(CallbackInfoReturnable<SoundEvent> cir) {
        Item item = (Item) (Object) this;
        if (ItemSoundModifications.EATING_MAP.containsKey(item)) {
            cir.setReturnValue(ItemSoundModifications.EATING_MAP.get(item));
        }
    }
}