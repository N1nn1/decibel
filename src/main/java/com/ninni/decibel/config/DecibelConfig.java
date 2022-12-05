package com.ninni.decibel.config;

import com.ninni.decibel.Decibel;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = Decibel.MOD_ID)
public class DecibelConfig implements ConfigData {

    public boolean addArmorStepSounds = true;
    public float armorStepVolume = 0.5F;

    public boolean addBowReadySound = true;
    public boolean addItemUseSounds = true;
    public boolean addWeaponSwingSounds = true;
    public boolean updateBlockSounds = true;
    public boolean updateBowShootSound = true;
    public boolean updateEatingSounds = true;
    public boolean updateEnderPearlThrowSound = true;
    
}