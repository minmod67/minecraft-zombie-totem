package com.minmod67.zombietotem.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ZombieTotemItem extends Item {

	public ZombieTotemItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack itemStack = player.getStackInHand(hand);

		if (!world.isClient) {
			// Check if player already has zombie effect
			if (player.hasStatusEffect(StatusEffects.NAUSEA)) {
				// Remove zombie effects
				player.removeStatusEffect(StatusEffects.NAUSEA);
				player.removeStatusEffect(StatusEffects.SLOWNESS);
				player.removeStatusEffect(StatusEffects.WEAKNESS);
				itemStack.decrement(1);
				return TypedActionResult.success(itemStack);
			} else {
				// Apply zombie effects
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 999999, 0, false, false));
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 999999, 2, false, false));
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 999999, 1, false, false));
				itemStack.decrement(1);
				return TypedActionResult.success(itemStack);
			}
		}

		return TypedActionResult.pass(itemStack);
	}
}
