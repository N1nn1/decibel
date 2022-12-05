package com.ninni.decibel.util;

import net.minecraft.world.level.block.SoundType;

@FunctionalInterface
public interface SoundGroupFunction<T> {
    SoundType get(T value);
}