package com.ninni.decibel;

import com.ninni.decibel.sound.ArmorSoundModifications;
import com.ninni.decibel.sound.BlockSoundModifications;
import com.ninni.decibel.sound.ItemSoundModifications;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Decibel implements ModInitializer {

	public static final String MOD_ID = "decibel";

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		BlockSoundModifications.init();
		ItemSoundModifications.init();
		ArmorSoundModifications.init();
	}
}