package com.jorislodewijks.morefood.common.block;

import com.jorislodewijks.morefood.common.block.machine.BlockMill;
import com.jorislodewijks.morefood.common.block.ore.BlockAdvancedOre;
import com.jorislodewijks.morefood.common.item.ModItems;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class ModBlocks {

	// Machines
	public static Block MILL = new BlockMill().setRegistryName(location("mill"));
	
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
	
	// Standard properties: hardness 3 and resistance 15
	public static Block ACANTHITE_ORE = new BlockAdvancedOre().setRegistryName(location("acanthite_ore"));
	public static Block BARITE_ORE = new BlockAdvancedOre().setRegistryName(location("barite_ore"));
	public static Block BAUXITE_ORE = new BlockAdvancedOre().setRegistryName(location("bauxite_ore"));
	public static Block BERYL_ORE = new BlockAdvancedOre().setRegistryName(location("beryl_ore"));
	public static Block BORNITE_ORE = new BlockAdvancedOre().setRegistryName(location("bornite_ore"));
	public static Block CASSITERITE_ORE = new BlockAdvancedOre().setRegistryName(location("cassiterite_ore"));
	public static Block CHALCOCITE_ORE = new BlockAdvancedOre().setRegistryName(location("chalcocite_ore"));
	public static Block CHALCOPYRITE_ORE = new BlockAdvancedOre().setRegistryName(location("chalcopyrite_ore"));
	public static Block CHROMITE_ORE = new BlockAdvancedOre().setRegistryName(location("chromite_ore"));
	public static Block CINNABAR_ORE = new BlockAdvancedOre().setRegistryName(location("cinnabar_ore"));
	public static Block COBALTITE_ORE = new BlockAdvancedOre().setRegistryName(location("cobaltite_ore"));
	public static Block COPPER_ORE = new BlockAdvancedOre().setRegistryName(location("copper_ore"));
	public static Block COLTAN_ORE = new BlockAdvancedOre().setRegistryName(location("coltan_ore"));
	public static Block DOLOMITE_ORE = new BlockAdvancedOre().setRegistryName(location("dolomite_ore"));
	public static Block GALENA_ORE = new BlockAdvancedOre().setRegistryName(location("galena_ore"));
	public static Block HEMATITE_ORE = new BlockAdvancedOre().setRegistryName(location("hematite_ore"));
	public static Block ILMENITE_ORE = new BlockAdvancedOre().setRegistryName(location("ilmenite_ore"));
	public static Block MAGNETITE_ORE = new BlockAdvancedOre().setRegistryName(location("magnetite_ore"));
	public static Block MALACHITE_ORE = new BlockAdvancedOre().setRegistryName(location("malachite_ore"));
	public static Block MOLYBDENITE_ORE = new BlockAdvancedOre().setRegistryName(location("molybdenite_ore"));
	public static Block PENTLANDITE_ORE = new BlockAdvancedOre().setRegistryName(location("pentlandite_ore"));
	public static Block PYROLUSITE_ORE = new BlockAdvancedOre().setRegistryName(location("pyrolusite_ore"));
	public static Block SALT_ORE = new BlockAdvancedOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(1f, 3f)).setRegistryName(location("salt_ore"));
	public static Block SCHEELITE_ORE = new BlockAdvancedOre().setRegistryName(location("scheelite_ore"));
	public static Block SPERRYLITE_ORE = new BlockAdvancedOre().setRegistryName(location("sperrylite_ore"));
	public static Block SPHALERITE_ORE = new BlockAdvancedOre().setRegistryName(location("sphalerite_ore"));
	public static Block URANINITE_ORE = new BlockAdvancedOre().setRegistryName(location("uraninite_ore"));
	public static Block WOLFRAMITE_ORE = new BlockAdvancedOre().setRegistryName(location("wolframite_ore"));
	
	
	public static void register (final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll( MILL );
		event.getRegistry().registerAll( ACANTHITE_ORE, BARITE_ORE, BAUXITE_ORE, BERYL_ORE, BORNITE_ORE, CASSITERITE_ORE, CHALCOCITE_ORE, CHALCOPYRITE_ORE, CHROMITE_ORE, CINNABAR_ORE, COBALTITE_ORE, COPPER_ORE, COLTAN_ORE,
				DOLOMITE_ORE, GALENA_ORE, HEMATITE_ORE, ILMENITE_ORE, MAGNETITE_ORE, MALACHITE_ORE, MOLYBDENITE_ORE, PENTLANDITE_ORE, PYROLUSITE_ORE, SALT_ORE, SCHEELITE_ORE, SPERRYLITE_ORE, SPHALERITE_ORE, URANINITE_ORE, WOLFRAMITE_ORE);
	}
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(Reference.MOD_ID, name);
	}
	
}