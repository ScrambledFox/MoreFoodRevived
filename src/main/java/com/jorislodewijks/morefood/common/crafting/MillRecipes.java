package com.jorislodewijks.morefood.common.crafting;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.jorislodewijks.morefood.common.item.ModItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MillRecipes {

	private static final MillRecipes instance = new MillRecipes();
	private final Map<ItemStack, ItemStack> millingList = new HashMap<>();
	private final Map<ItemStack, Float> experienceList = new HashMap<>();
	
	public static MillRecipes getInstance() {
		return instance;
	}
	
	private MillRecipes() {
		addMillingRecipe(new ItemStack(Items.WHEAT), new ItemStack(ModItems.flour, 2), 5.0F);
	}
	
	public void addMillingRecipe(ItemStack ingredient, ItemStack result, float experience) {
		if ( getMillingResult(ingredient) != ItemStack.EMPTY ) return;
		this.millingList.put(ingredient, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getMillingResult( ItemStack ingredient ) {
		for(Entry<ItemStack, ItemStack> entry : this.millingList.entrySet()) {
			if ( this.compareItemStacks(ingredient, entry.getKey()) ) {
				return entry.getValue();
			}
		}
		
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks( ItemStack stack1, ItemStack stack2 ) {
		return stack2.getItem() == stack1.getItem();
	}
	
	public Map<ItemStack, ItemStack> getDualMillingList() {
		return this.millingList;
	}
	
	public float getMillingExperience(ItemStack stack) {
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) {
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
	
}