package com.jorislodewijks.morefood.common.block.ore;

import java.util.Random;

import com.jorislodewijks.morefood.client.particle.UranititeParticle;
import com.jorislodewijks.morefood.common.block.ModBlocks;
import com.jorislodewijks.morefood.common.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Particles;
import net.minecraft.item.Item;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockAdvancedOre extends BlockOre {

	// Block drop
	private Item drop;
	private int minAmount;
	private int maxAmount;

	
	public BlockAdvancedOre(  ) {
		this(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE));
	}
	
	public BlockAdvancedOre( Block.Properties builder ) {
		super(builder);
	}
	
	
	@Override
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
		if (this == ModBlocks.SALT_ORE) { 
			drop = ModItems.SALT;
		}
		
		return drop == null ? this : drop;
	}
	
	@Override
	public int quantityDropped(IBlockState state, Random random) {
		if (this == ModBlocks.SALT_ORE) {
			minAmount = 1;
			maxAmount = 5;
		}
		
		if (minAmount == 0) {
			return maxAmount;
		} else {
			return random.nextInt(maxAmount - minAmount) + minAmount;
		}
	}
	
	
	@Override
	public void animateTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if ( this == ModBlocks.SALT_ORE ) {
			spawnSaltParticles(stateIn, worldIn, pos, rand);
		} else if ( this == ModBlocks.URANINITE_ORE ) {
			spawnUranititeParticles(stateIn, worldIn, pos, rand);
		}
	}
	
	private static void spawnSaltParticles(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(4) == 0) {
			BlockPos blockPos = pos.down();
			Material material = worldIn.getBlockState(blockPos).getMaterial();
			if (worldIn.isAirBlock(blockPos) || worldIn.getBlockState(blockPos).getBlock() == Blocks.FIRE || material.isLiquid() || material.isReplaceable()) {
	            double d0 = (double)((float)pos.getX() + rand.nextFloat());
	            double d1 = (double)pos.getY() - 0.05D;
	            double d2 = (double)((float)pos.getZ() + rand.nextFloat());
	            worldIn.spawnParticle(new BlockParticleData(Particles.FALLING_DUST, stateIn), d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	private void spawnUranititeParticles(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		double d0 = 0.5625D;
		
		if (rand.nextInt(4) == 0) {
			for (EnumFacing face : EnumFacing.values() ) {
				BlockPos blockPos = pos.offset(face);
				if(!worldIn.getBlockState(blockPos).isOpaqueCube(worldIn, blockPos)) {
					EnumFacing.Axis face$axis = face.getAxis();
					double d1 = face$axis == EnumFacing.Axis.X ? 0.5D + d0 * (double)face.getXOffset() : (double) rand.nextFloat();
					double d2 = face$axis == EnumFacing.Axis.Y ? 0.5D + d0 * (double)face.getYOffset() : (double) rand.nextFloat();
					double d3 = face$axis == EnumFacing.Axis.Z ? 0.5D + d0 * (double)face.getZOffset() : (double) rand.nextFloat();
					
					//worldIn.spawnParticle( RedstoneParticleData.REDSTONE_DUST, (double)pos.getX() + d1, (double)pos.getY() + d2, (double)pos.getZ() + d3, 0.0D, 0.0D, 0.0D);
				}
			}
		} 
	}
	
}