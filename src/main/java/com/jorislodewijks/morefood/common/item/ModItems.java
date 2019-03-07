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
	public static Item salt = new Item(defaultItemProperties).setRegistryName(location("salt"));
	public static Item flour = new Item(defaultItemProperties).setRegistryName(location("flour"));
	
	public static Item millstone = new Item(defaultItemProperties).setRegistryName(location("millstone"));
	
	
	// Item Blocks
	public static Item mill = new ItemBlock(ModBlocks.mill, defaultItemProperties).setRegistryName(ModBlocks.mill.getRegistryName());
	
	public static Item salt_ore = new ItemBlock(ModBlocks.salt_ore, defaultItemProperties).setRegistryName(ModBlocks.salt_ore.getRegistryName());
	
	
	public static void register(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll( salt, flour );
		event.getRegistry().registerAll( millstone );
		
		event.getRegistry().registerAll( mill );
		event.getRegistry().registerAll( salt_ore );
	}
	
	public static ResourceLocation location (String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
	
}