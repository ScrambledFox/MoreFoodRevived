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
	public static Item CURED_CHICKEN = new ItemFood(4, 0.8F, true, defaultItemProperties).setPotionEffect(new PotionEffect(MobEffects.NAUSEA), 0.8f).setPotionEffect(new PotionEffect(MobEffects.HUNGER), 0.5f).setRegistryName(location("cured_chicken"));
	public static Item CURED_RABBIT = new ItemFood(5, 0.8F, true, defaultItemProperties).setRegistryName(location("cured_rabbit"));
	public static Item CURED_MUTTON = new ItemFood(4, 0.8F, true, defaultItemProperties).setRegistryName(location("cured_mutton"));
	
	public static Item CURED_COD = new ItemFood(4, 0.3F, false, defaultItemProperties).setRegistryName(location("cured_cod"));
	public static Item CURED_SALMON = new ItemFood(4, 0.3F, false, defaultItemProperties).setRegistryName(location("cured_salmon"));
	public static Item CURED_TROPICAL_FISH = new ItemFood(2, 0.2F, false, defaultItemProperties).setRegistryName(location("cured_tropical_fish"));
	public static Item CURED_PUFFERFISH = new ItemFood(1, 0.1F, false, defaultItemProperties).setPotionEffect(new PotionEffect(MobEffects.NAUSEA), 0.8f).setPotionEffect(new PotionEffect(MobEffects.POISON, 100, 0), 0.8f).setRegistryName(location("cured_pufferfish"));
	
	// Recipes
	public static Item SALTED_POTATO = new ItemFood(2, 0.5F, false, defaultItemProperties).setRegistryName(location("salted_potato"));
	public static Item SALTED_BAKED_POTATO = new ItemFood(7, 1F, false, defaultItemProperties).setRegistryName(location("salted_baked_potato"));
	
	
	// Tools
	public static Item MILLSTONE = new ItemMillstone(defaultItemProperties).setRegistryName(location("millstone"));
	
	
	// Item Blocks
	public static Item MILL = new ItemBlock(ModBlocks.MILL, defaultItemProperties).setRegistryName(ModBlocks.MILL.getRegistryName());
	
	public static Item ACANTHITE_ORE = new ItemBlock(ModBlocks.ACANTHITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.ACANTHITE_ORE.getRegistryName());
	public static Item BARITE_ORE = new ItemBlock(ModBlocks.BARITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.BARITE_ORE.getRegistryName());
	public static Item BAUXITE_ORE = new ItemBlock(ModBlocks.BAUXITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.BAUXITE_ORE.getRegistryName());
	public static Item BERYL_ORE = new ItemBlock(ModBlocks.BERYL_ORE, defaultItemProperties).setRegistryName(ModBlocks.BERYL_ORE.getRegistryName());
	public static Item BORNITE_ORE = new ItemBlock(ModBlocks.BORNITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.BORNITE_ORE.getRegistryName());
	public static Item CASSITERITE_ORE = new ItemBlock(ModBlocks.CASSITERITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.CASSITERITE_ORE.getRegistryName());
	public static Item CHALCOCITE_ORE = new ItemBlock(ModBlocks.CHALCOCITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.CHALCOCITE_ORE.getRegistryName());
	public static Item CHALCOPYRITE_ORE = new ItemBlock(ModBlocks.CHALCOPYRITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.CHALCOPYRITE_ORE.getRegistryName());
	public static Item CHROMITE_ORE = new ItemBlock(ModBlocks.CHROMITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.CHROMITE_ORE.getRegistryName());
	public static Item CINNABAR_ORE = new ItemBlock(ModBlocks.CINNABAR_ORE, defaultItemProperties).setRegistryName(ModBlocks.CINNABAR_ORE.getRegistryName());
	public static Item COBALTITE_ORE = new ItemBlock(ModBlocks.COBALTITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.COBALTITE_ORE.getRegistryName());
	public static Item COPPER_ORE = new ItemBlock(ModBlocks.COPPER_ORE, defaultItemProperties).setRegistryName(ModBlocks.COPPER_ORE.getRegistryName());
	public static Item COLTAN_ORE = new ItemBlock(ModBlocks.COLTAN_ORE, defaultItemProperties).setRegistryName(ModBlocks.COLTAN_ORE.getRegistryName());
	public static Item DOLOMITE_ORE = new ItemBlock(ModBlocks.DOLOMITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.DOLOMITE_ORE.getRegistryName());
	public static Item GALENA_ORE = new ItemBlock(ModBlocks.GALENA_ORE, defaultItemProperties).setRegistryName(ModBlocks.GALENA_ORE.getRegistryName());
	public static Item HEMATITE_ORE = new ItemBlock(ModBlocks.HEMATITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.HEMATITE_ORE.getRegistryName());
	public static Item ILMENITE_ORE = new ItemBlock(ModBlocks.ILMENITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.ILMENITE_ORE.getRegistryName());
	public static Item MAGNETITE_ORE = new ItemBlock(ModBlocks.MAGNETITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.MAGNETITE_ORE.getRegistryName());
	public static Item MALACHITE_ORE = new ItemBlock(ModBlocks.MALACHITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.MALACHITE_ORE.getRegistryName());
	public static Item MOLYBDENITE_ORE = new ItemBlock(ModBlocks.MOLYBDENITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.MOLYBDENITE_ORE.getRegistryName());
	public static Item PENTLANDITE_ORE = new ItemBlock(ModBlocks.PENTLANDITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.PENTLANDITE_ORE.getRegistryName());
	public static Item PYROLUSITE_ORE = new ItemBlock(ModBlocks.PYROLUSITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.PYROLUSITE_ORE.getRegistryName());
	public static Item SALT_ORE = new ItemBlock(ModBlocks.SALT_ORE, defaultItemProperties).setRegistryName(ModBlocks.SALT_ORE.getRegistryName());
	public static Item SCHEELITE_ORE = new ItemBlock(ModBlocks.SCHEELITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.SCHEELITE_ORE.getRegistryName());
	public static Item SPERRYLITE_ORE = new ItemBlock(ModBlocks.SPERRYLITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.SPERRYLITE_ORE.getRegistryName());
	public static Item SPHALERITE_ORE = new ItemBlock(ModBlocks.SPHALERITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.SPHALERITE_ORE.getRegistryName());
	public static Item URANINITE_ORE = new ItemBlock(ModBlocks.URANINITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.URANINITE_ORE.getRegistryName());
	public static Item WOLFRAMITE_ORE = new ItemBlock(ModBlocks.WOLFRAMITE_ORE, defaultItemProperties).setRegistryName(ModBlocks.WOLFRAMITE_ORE.getRegistryName());
	
	
	
	public static void register(final RegistryEvent.Register<Item> event) {
		
		event.getRegistry().registerAll(
				SALT, FLOUR, DOUGH,
				CURED_BEEF, CURED_PORKCHOP, CURED_CHICKEN, CURED_RABBIT, CURED_MUTTON,
				CURED_COD, CURED_SALMON, CURED_TROPICAL_FISH, CURED_PUFFERFISH,
				SALTED_POTATO, SALTED_BAKED_POTATO,
				MILLSTONE
		);
		
		event.getRegistry().registerAll(
				MILL
		);
		
		event.getRegistry().registerAll( ACANTHITE_ORE, BARITE_ORE, BAUXITE_ORE, BERYL_ORE, BORNITE_ORE, CASSITERITE_ORE, CHALCOCITE_ORE, CHALCOPYRITE_ORE, CHROMITE_ORE, CINNABAR_ORE, COBALTITE_ORE, COPPER_ORE, COLTAN_ORE,
				DOLOMITE_ORE, GALENA_ORE, HEMATITE_ORE, ILMENITE_ORE, MAGNETITE_ORE, MALACHITE_ORE, MOLYBDENITE_ORE, PENTLANDITE_ORE, PYROLUSITE_ORE, SALT_ORE, SCHEELITE_ORE, SPERRYLITE_ORE, SPHALERITE_ORE, URANINITE_ORE, WOLFRAMITE_ORE);
	}
	
	public static ResourceLocation location (String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
	
}