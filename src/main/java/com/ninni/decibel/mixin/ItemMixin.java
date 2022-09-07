package com.ninni.decibel.mixin;

import com.ninni.decibel.sound.ItemSoundModifications;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Item.class)
public abstract class ItemMixin {

    @Inject(at = @At("HEAD"), method = "getEatSound", cancellable = true)
    private void getModifiedEatingSound(CallbackInfoReturnable<SoundEvent> cir) {
        Item that = (Item) (Object) this;
        if (ItemSoundModifications.SOUND_GROUP_MAP.containsKey(that)) {
            cir.setReturnValue(ItemSoundModifications.SOUND_GROUP_MAP.get(that));
        }
    }

}
