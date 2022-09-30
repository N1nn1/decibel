package com.ninni.decibel.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "decibel")
public class DecibelConfig implements ConfigData {

    public boolean addArmorStepSounds = true;
    public boolean addBowReadySound = true;
    public boolean addItemUseSounds = true;
    public boolean addWeaponSwingSounds = true;
    public boolean updateBlockSounds = true;
    public boolean updateBowShootSound = true;
    public boolean updateEatingSounds = true;
    public boolean updateEnderPearlThrowSound = true;
    
}
