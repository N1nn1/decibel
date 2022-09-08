package com.ninni.decibel.mixin;

import com.ninni.decibel.sound.ArmorSoundModifications;
import com.ninni.decibel.sound.DecibelSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(at = @At("HEAD"), method = "playStepSound")
    public void modifyStepSound(BlockPos pos, BlockState state, CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        Iterable<ItemStack> iterable = entity.getArmorItems();

        for (ItemStack itemStack : iterable) {
            Item item = itemStack.getItem();
            if ((item instanceof ArmorItem armorItem) && ArmorSoundModifications.SOUND_MAP.containsKey((armorItem.getMaterial()))) {
                entity.playSound(DecibelSoundEvents.ARMOR_IRON_STEP, 0.25F, 1);
            }
        }

    }
}
