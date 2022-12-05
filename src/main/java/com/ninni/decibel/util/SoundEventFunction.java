package com.ninni.decibel.util;

import net.minecraft.sounds.SoundEvent;

@FunctionalInterface
public interface SoundEventFunction<T> {
    SoundEvent get(T value);
}