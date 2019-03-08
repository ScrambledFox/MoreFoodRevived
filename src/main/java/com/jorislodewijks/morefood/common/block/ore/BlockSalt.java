package com.jorislodewijks.morefood.common.block.ore;

import java.util.Random;

import com.jorislodewijks.morefood.common.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Particles;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockSalt extends Block {
	
	public BlockSalt(Properties properties) {
		super(properties);
	}
	
	
	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		drops.add(new ItemStack(ModItems.SALT, RANDOM.nextInt(4) + 1));
	}
	
	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.PICKAXE;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 1;
	}
	
	@Override
	public void animateTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
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
	
}