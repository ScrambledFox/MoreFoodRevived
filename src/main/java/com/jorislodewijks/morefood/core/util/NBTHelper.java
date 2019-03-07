package com.jorislodewijks.morefood.core.util;

public class NBTHelper {
	
	// Tile entity.
	public static final String CURR_PROGRESS = "currProgress";
	public static final String INVENTORY = "inventory";
	
//	public static NBTTagCompound getBaseTag(ItemStack stack) {
//		return stack.getOrCreateChildTag(MOB);
//	}
//	
//	public static void setBaseTag(ItemStack stack, NBTTagCompound nbt) {
//		stack.getOrCreateTag().setTag(MOB, nbt);
//	}
//	
//	public static boolean hasMob(ItemStack stack) {
//		return stack.getOrCreateTag().hasKey(MOB);
//	}
//	
//	public static boolean hasHostileMob(ItemStack stack) {
//		if (!hasMob(stack)) return false;
//		NBTTagCompound nbt = NBTHelper.getBaseTag(stack);
//		return nbt.getBoolean(NBTHelper.MOB_HOSTILE);
//	}
//
//	public static NBTTagList createNBTList(INBTBase... tags) {
//		NBTTagList list = new NBTTagList();
//		for (INBTBase i: tags) list.add(i);
//		
//		return list;
//	}
}