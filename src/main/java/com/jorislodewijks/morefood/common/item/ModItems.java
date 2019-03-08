package com.jorislodewijks.morefood.common.item;

import com.jorislodewijks.morefood.common.MoreFood;
import com.jorislodewijks.morefood.common.block.ModBlocks;
import com.jorislodewijks.morefood.common.item.tool.ItemMillstone;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class ModItems {

	// Properties
	public static final Item.Properties defaultItemProperties = new Item.Properties().group(MoreFood.CREATIVE_TAB);
	
	
	// Items
	// Spices
	public static Item SALT = new Item(defaultItemProperties).setRegistryName(location("salt"));
	
	public static Item FLOUR = new Item(defaultItemProperties).setRegistryName(location("flour"));
	public static Item DOUGH = new Item(defaultItemProperties).setRegistryName(location("dough"));
	
	// Foods
	// Cured
	public static Item CURED_BEEF = new ItemFood(5, 0.8F, true, defaultItemProperties).setRegistryName(location("cured_beef"));
	public static Item CURED_PORKCHOP = new ItemFood(5, 0.8F, true, defaultItemProperties).setRegistryName(location("cured_porkchop"));
	public static Item CURED_CHICKEN = new ItemFood(4, 0.8F, true, defaultItemProperties).setRegistryName(location("cured_chicken"));
	public static Item CURED_RABBIT = new ItemFood(5, 0.8F, true, defaultItemProperties).setRegistryName(location("cured_rabbit"));
	public static Item CURED_MUTTON = new ItemFood(4, 0.8F, true, defaultItemProperties).setRegistryName(location("cured_mutton"));
	public static Item SALTED_POTATO = new ItemFood(7, 1F, false, defaultItemProperties).setRegistryName(location("cured_potato"));
	
	public static Item CURED_COD = new ItemFood(4, 0.3F, false, defaultItemProperties).setRegistryName(location("cured_cod"));
	public static Item CURED_SALMON = new ItemFood(4, 0.3F, false, defaultItemProperties).setRegistryName(location("cured_salmon"));
	public static Item CURED_TROPICAL_FISH = new ItemFood(2, 0.2F, false, defaultItemProperties).setRegistryName(location("cured_tropical_fish"));
	public static Item CURED_PUFFERFISH = new ItemFood(1, 0.1F, false, defaultItemProperties).setPotionEffect(new PotionEffect(MobEffects.NAUSEA), 0.8f).setPotionEffect(new PotionEffect(MobEffects.POISON, 100, 0), 0.8f).setRegistryName(location("cured_pufferfish"));
	
	// Tools
	public static Item MILLSTONE = new ItemMillstone(defaultItemProperties).setRegistryName(location("millstone"));
	
	
	// Item Blocks
	public static Item MILL = new ItemBlock(ModBlocks.MILL, defaultItemProperties).setRegistryName(ModBlocks.MILL.getRegistryName());
	
	public static Item SALT_ORE = new ItemBlock(ModBlocks.SALT_ORE, defaultItemProperties).setRegistryName(ModBlocks.SALT_ORE.getRegistryName());
	
	
	public static void register(final RegistryEvent.Register<Item> event) {
		
		event.getRegistry().registerAll(
				SALT, FLOUR, DOUGH,
				CURED_BEEF, CURED_PORKCHOP, CURED_CHICKEN, CURED_RABBIT, CURED_MUTTON, SALTED_POTATO,
				CURED_COD, CURED_SALMON, CURED_TROPICAL_FISH, CURED_PUFFERFISH,
				MILLSTONE
		);
		
		event.getRegistry().registerAll(
				MILL,
				SALT_ORE
		);
	}
	
	public static ResourceLocation location (String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
	
}