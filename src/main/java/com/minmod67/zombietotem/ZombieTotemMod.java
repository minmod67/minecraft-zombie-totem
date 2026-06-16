package com.minmod67.zombietotem;

import net.fabricmc.api.ModInitializer;
import com.minmod67.zombietotem.item.ModItems;

public class ZombieTotemMod implements ModInitializer {

	public static final String MOD_ID = "zombie_totem_mod";

	@Override
	public void onInitialize() {
		ModItems.registerItems();
	}
}
