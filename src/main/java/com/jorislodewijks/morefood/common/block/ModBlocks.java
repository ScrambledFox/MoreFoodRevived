package com.jorislodewijks.morefood.common.block;

import com.jorislodewijks.morefood.common.item.ModItems;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class ModBlocks {

	// Ores
	public static final Block salt_ore = new BlockOre(Block.Properties.create(Material.ROCK), ModItems.salt).setRegistryName(location("salt_ore"));
	
	
	public static void register (final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll( salt_ore );
	}
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
	
}