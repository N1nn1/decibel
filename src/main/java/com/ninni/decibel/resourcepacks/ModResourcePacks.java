package com.ninni.decibel.resourcepacks;

import com.ninni.decibel.Decibel;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class ModResourcePacks {

    public static void init() {
        Identifier packId = new Identifier(Decibel.MOD_ID, "classic_water");


        FabricLoader.getInstance().getModContainer(Decibel.MOD_ID).ifPresent(container
                -> ResourceManagerHelper.registerBuiltinResourcePack(packId, container, "Classic Water", ResourcePackActivationType.NORMAL));

    }

}
