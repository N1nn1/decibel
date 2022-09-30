package com.ninni.decibel;

import com.ninni.decibel.config.DecibelConfig;
import com.ninni.decibel.resourcepacks.ModResourcePacks;
import com.ninni.decibel.sound.ArmorSoundModifications;
import com.ninni.decibel.sound.BlockSoundModifications;
import com.ninni.decibel.sound.ItemSoundModifications;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Decibel implements ModInitializer {

	public static final String MOD_ID = "decibel";

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	public static DecibelConfig getConfig() {
		return AutoConfig.getConfigHolder(DecibelConfig.class).getConfig();
	}

	@Override
	public void onInitialize() {
		BlockSoundModifications.init();
		ItemSoundModifications.init();
		ArmorSoundModifications.init();
		ModResourcePacks.init();
		AutoConfig.register(DecibelConfig.class, JanksonConfigSerializer::new);
	}
}