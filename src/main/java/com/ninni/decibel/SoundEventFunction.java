package com.ninni.decibel;

import net.minecraft.sound.SoundEvent;

@FunctionalInterface
public interface SoundEventFunction<T> {
    SoundEvent get(T value);
}