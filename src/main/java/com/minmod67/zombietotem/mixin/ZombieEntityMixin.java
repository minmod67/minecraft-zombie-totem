package com.minmod67.zombietotem.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import com.minmod67.zombietotem.ZombieTotemMod;

@Mixin(ZombieEntity.class)
public class ZombieEntityMixin {

	@Inject(method = "dropLoot", at = @At("TAIL"))
	private void onDrop(LivingEntity attacker, int lootingLevel, CallbackInfo ci) {
		ZombieEntity zombie = (ZombieEntity) (Object) this;
		
		// 2% chance to drop Zombie Totem
		if (zombie.getRandom().nextDouble() < 0.02) {
			ItemStack zombieTotem = new ItemStack(
				Registries.ITEM.get(Identifier.of(ZombieTotemMod.MOD_ID, "zombie_totem"))
			);
			zombie.dropStack(zombieTotem);
		}
	}
}
