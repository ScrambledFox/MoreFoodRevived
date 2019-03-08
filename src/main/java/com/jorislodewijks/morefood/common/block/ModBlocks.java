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
//	Acanthite (cooled polymorph of Argentite): Ag2S for production of silver
//	Barite: BaSO4
//	Bauxite Al(OH)3 and AlOOH, dried to Al2O3 for production of aluminium
//	Beryl: Be3Al2(SiO3)6
//	Bornite: Cu5FeS4
//	Cassiterite: SnO2
//	Chalcocite: Cu2S for production of copper
//	Chalcopyrite: CuFeS2
//	Chromite: (Fe, Mg)Cr2O4 for production of chromium
//	Cinnabar: HgS for production of mercury
//	Cobaltite: (Co, Fe)AsS
//	Columbite-Tantalite or Coltan: (Fe, Mn)(Nb, Ta)2O6
//	Dolomite: CaMg(CO3)2
//	Galena: PbS
//	Native gold: Au, typically associated with quartz or as placer deposits
//	Hematite: Fe2O3
//	Ilmenite: FeTiO3
//	Magnetite: Fe3O4
//	Malachite: Cu2CO3(OH)2
//	Molybdenite: MoS2
//	Pentlandite: (Fe, Ni)9S8
//	Pyrolusite: MnO2
//	Scheelite: CaWO4
//	Sperrylite: PtAs2 for production of platinum
//	Sphalerite: ZnS
//	Uraninite (pitchblende): UO2 for production of metallic uranium
//	Wolframite: (Fe, Mn)WO4
	
	public static Block SALT_ORE = new BlockSalt(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0f, 5f).sound(SoundType.STONE)).setRegistryName(location("salt_ore"));
	
	public static Block SILVER_ORE = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15f).sound(SoundType.STONE)).setRegistryName(location("silver_ore")); 	// Acanthite: Ag2S
	public static Block BARIUM_ORE = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15f).sound(SoundType.STONE)).setRegistryName(location("barium_ore"));
	public static Block COPPER_ORE = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15f).sound(SoundType.STONE)).setRegistryName(location("copper_ore"));
	public static Block TIN_ORE = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15f).sound(SoundType.STONE)).setRegistryName(location("tin_ore"));
	
	
	public static void register (final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll( MILL );
		event.getRegistry().registerAll( SALT_ORE, COPPER_ORE );
	}
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
	
}