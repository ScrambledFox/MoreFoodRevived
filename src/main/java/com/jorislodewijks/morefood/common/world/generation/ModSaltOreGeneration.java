package com.jorislodewijks.morefood.common.world.generation;

import com.jorislodewijks.morefood.common.block.ModBlocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.common.BiomeManager;

public class ModSaltOreGeneration {

	public static void Init() {

		BiomeManager.getBiomes(BiomeManager.BiomeType.COOL).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature(
				GenerationStage.Decoration.UNDERGROUND_ORES,
				Biome.createCompositeFeature(
						Feature.MINABLE, 
						new MinableConfig(MinableConfig.IS_ROCK, ModBlocks.SALT_ORE.getDefaultState(), 17),
						Biome.COUNT_RANGE,
						new CountRangeConfig(5, 0, 0, 128)
				)
		));
		
		BiomeManager.getBiomes(BiomeManager.BiomeType.DESERT).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature(
				GenerationStage.Decoration.UNDERGROUND_ORES,
				Biome.createCompositeFeature(
						Feature.MINABLE, 
						new MinableConfig(MinableConfig.IS_ROCK, ModBlocks.SALT_ORE.getDefaultState(), 17),
						Biome.COUNT_RANGE,
						new CountRangeConfig(5, 0, 0, 128)
				)
		));
		
		BiomeManager.getBiomes(BiomeManager.BiomeType.ICY).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature(
				GenerationStage.Decoration.UNDERGROUND_ORES,
				Biome.createCompositeFeature(
						Feature.MINABLE, 
						new MinableConfig(MinableConfig.IS_ROCK, ModBlocks.SALT_ORE.getDefaultState(), 17),
						Biome.COUNT_RANGE,
						new CountRangeConfig(5, 0, 0, 128)
				)
		));
		
		BiomeManager.getBiomes(BiomeManager.BiomeType.WARM).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature(
				GenerationStage.Decoration.UNDERGROUND_ORES,
				Biome.createCompositeFeature(
						Feature.MINABLE, 
						new MinableConfig(MinableConfig.IS_ROCK, ModBlocks.SALT_ORE.getDefaultState(), 17),
						Biome.COUNT_RANGE,
						new CountRangeConfig(5, 0, 0, 128)
				)
		));
		
	}
	
}