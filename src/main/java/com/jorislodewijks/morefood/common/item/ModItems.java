package com.jorislodewijks.morefood.common.item;

import com.jorislodewijks.morefood.common.MoreFood;
import com.jorislodewijks.morefood.common.block.ModBlocks;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class ModItems {

	// Properties
	public static final Item.Properties defaultItemProperties = new Item.Properties().group(MoreFood.creativeTab);
	
	
	// Items
	public static final Item salt = new Item(defaultItemProperties).setRegistryName(location("salt"));
	public static final Item flour = new Item(defaultItemProperties).setRegistryName(location("flour"));
	
	
	// Item Blocks
	public static final Item salt_ore = new ItemBlock(ModBlocks.salt_ore, defaultItemProperties).setRegistryName(ModBlocks.salt_ore.getRegistryName());
	
	
	public static void register(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll( salt, flour );
		
		event.getRegistry().registerAll( salt_ore );
	}
	
	public static ResourceLocation location (String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
	
}