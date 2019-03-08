package com.jorislodewijks.morefood.common.block.ore;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockAdvancedOre extends BlockOre {

	// What does the block drop?
	private Item drop;
	private int minAmount;
	private int maxAmount;

	public BlockAdvancedOre( Block.Properties builder ) {
		this(builder, null , 1 );
	}
	
	public BlockAdvancedOre( Block.Properties builder, Item drop, int amount ) {
		this(builder, drop, 0, amount);
	}
	
	public BlockAdvancedOre( Block.Properties builder, Item drop, int minAmount, int maxAmount ) {
		super(builder);
		this.drop = drop;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
	}
	
	@Override
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
		return drop == null ? this : drop;
	}
	
	@Override
	public int quantityDropped(IBlockState state, Random random) {
		if (minAmount == 0) {
			return maxAmount;
		} else {
			return random.nextInt(maxAmount - minAmount) + minAmount;
		}
	}
	
	
	
}