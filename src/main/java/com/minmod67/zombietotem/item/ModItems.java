package com.minmod67.zombietotem.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.minmod67.zombietotem.ZombieTotemMod;

public class ModItems {

	public static final Item ZOMBIE_TOTEM = registerItem("zombie_totem", new ZombieTotemItem(new Item.Settings().maxCount(1)));
	public static final Item NORMAL_TOTEM = Registries.ITEM.get(Identifier.ofVanilla("totem_of_undying"));

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(ZombieTotemMod.MOD_ID, name), item);
	}

	public static void registerItems() {
		// Items are registered when the class is loaded
	}
}
