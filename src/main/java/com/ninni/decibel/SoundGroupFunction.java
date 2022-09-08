package com.ninni.decibel;

import net.minecraft.sound.BlockSoundGroup;

@FunctionalInterface
public interface SoundGroupFunction<T> {
    BlockSoundGroup get(T value);
}