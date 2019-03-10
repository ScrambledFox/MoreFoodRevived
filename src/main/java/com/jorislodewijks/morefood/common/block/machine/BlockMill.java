package com.jorislodewijks.morefood.common.block.machine;

import com.jorislodewijks.morefood.client.gui.InteractionObjectMill;
import com.jorislodewijks.morefood.common.block.ModBlocks;
import com.jorislodewijks.morefood.common.tileentity.machine.TileEntityMill;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockMill extends Block {
	
	public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;
	public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;

	public BlockMill( ) {
		super(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE));
		
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH).with(ENABLED, false));
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.SOLID;
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, IBlockState> builder) {
		builder.add(FACING, ENABLED);
	}
	
	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		super.onBlockPlacedBy(world, pos, state, placer, stack);
		
		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof TileEntityMill) {
			TileEntityMill tileEntityMill = (TileEntityMill) tileentity;
			tileEntityMill.updateRedstone();
		}
	}
	
	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote() && player instanceof EntityPlayerMP) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityMill) {
				NetworkHooks.openGui((EntityPlayerMP)player, new InteractionObjectMill((TileEntityMill)tileentity), (buffer) -> {
					buffer.writeBlockPos(pos);
				});
			}
		}
		
		return true;
	}
	
	@Override
	public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		TileEntity tileentity = worldIn.getTileEntity(currentPos);
		if (tileentity instanceof TileEntityMill) {
			TileEntityMill tileentityMill = (TileEntityMill) tileentity;
			tileentityMill.updateRedstone();
			tileentityMill.saveAndSync();
		}
		
		return stateIn;
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (!worldIn.isRemote() && tileentity instanceof TileEntityMill) {
			TileEntityMill tileentityMill = (TileEntityMill) tileentity;
			
			LOGGER.info("Drop the inventory");
			// drop inventory
		}
		
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	
	public static void setState(boolean enabled, World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		TileEntity tileentity = world.getTileEntity(pos);
	
		world.setBlockState(pos, ModBlocks.MILL.getDefaultState().with(FACING, state.get(FACING)).with(ENABLED, enabled));
		
		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(pos, tileentity);
		}
	}
	
	@Override
	public boolean hasTileEntity( IBlockState state ) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		return new TileEntityMill();
	}

}