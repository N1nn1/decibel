package com.ninni.decibel.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "decibel")
public class DecibelConfig implements ConfigData {

    public boolean toggleArmor = true;
}
