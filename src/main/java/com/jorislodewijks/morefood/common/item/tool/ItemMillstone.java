package com.jorislodewijks.morefood.common.item.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMillstone extends Item {

	public ItemMillstone(Properties properties) {
		super(properties);
	}
	
	public int damage(ItemStack stack, int damage) {
		setDamage(stack, stack.getDamage() + damage);
		return stack.getDamage();
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) {
		return 64;
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return 1;
	}
	
}