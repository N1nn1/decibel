package com.ninni.decibel.resourcepacks;

import com.ninni.decibel.Decibel;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;

public class DecibelResourcePacks {

    static {
        FabricLoader.getInstance().getModContainer(Decibel.MOD_ID).ifPresent(container -> ResourceManagerHelper.registerBuiltinResourcePack(Decibel.id("classic_water"), container, "Classic Water", ResourcePackActivationType.NORMAL));
    }
}