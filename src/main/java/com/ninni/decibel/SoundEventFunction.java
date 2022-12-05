package com.ninni.decibel;

import net.minecraft.sounds.SoundEvent;

@FunctionalInterface
public interface SoundEventFunction<T> {
    SoundEvent get(T value);
}