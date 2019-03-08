package com.jorislodewijks.morefood.common.block;

import com.jorislodewijks.morefood.common.block.machine.BlockMill;
import com.jorislodewijks.morefood.common.block.ore.BlockSalt;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class ModBlocks {

	// Machines
	// Food
	public static Block MILL = new BlockMill(Block.Properties.create(Material.ROCK)).setRegistryName(location("mill"));
	
	// Ores
	public static Block SALT_ORE = new BlockSalt(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5f, 15f).sound(SoundType.STONE)).setRegistryName(location("salt_ore"));
	
	
	public static void register (final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll( MILL );
		event.getRegistry().registerAll( SALT_ORE );
	}
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
	
}