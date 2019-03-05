package com.jorislodewijks.morefood.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockOre extends Block {

	Item drop;
	int minDropAmount = 1;
	int maxDropAmount = 1;
	
	public BlockOre(Properties properties, Item drop) {
		super(properties);
		this.drop = drop;
	}
	
	
	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		drops.add(new ItemStack(drop, RANDOM.nextInt(4)+2));
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
	public float getBlockHardness(IBlockState blockState, IBlockReader worldIn, BlockPos pos) {
		return 3f;
	}
	
	@Override
	public float getExplosionResistance() {
		return 15f;
	}
	
}