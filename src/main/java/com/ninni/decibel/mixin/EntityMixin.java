package com.ninni.decibel.mixin;

import com.ninni.decibel.sound.ArmorSoundModifications;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
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
            for (ArmorMaterial armorMaterial : ArmorSoundModifications.SOUND_MAP.keySet()) {
                if ((item instanceof ArmorItem armorItem) && armorMaterial == armorItem.getMaterial()) {
                    entity.playSound(ArmorSoundModifications.SOUND_MAP.get(armorMaterial).get(armorMaterial), 1, 1);
                }
            }
        }
    }
}
