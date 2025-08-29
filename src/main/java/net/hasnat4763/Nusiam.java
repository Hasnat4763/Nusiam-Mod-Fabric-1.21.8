package net.hasnat4763;

import net.fabricmc.api.ModInitializer;

import net.hasnat4763.block.ModBlocks;
import net.hasnat4763.item.ModItemGroup;
import net.hasnat4763.item.ModItems;
import net.hasnat4763.item.ModToolMaterial;
import net.hasnat4763.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Nusiam implements ModInitializer {
	public static final String MOD_ID = "nusiam";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroup.RegisterItemGroup();
		ModSounds.registerSounds();

	}
}