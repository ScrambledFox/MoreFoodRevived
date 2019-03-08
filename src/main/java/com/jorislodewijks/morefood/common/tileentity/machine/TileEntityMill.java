package com.jorislodewijks.morefood.common.tileentity.machine;

import javax.annotation.Nullable;

import com.jorislodewijks.morefood.common.block.machine.BlockMill;
import com.jorislodewijks.morefood.common.crafting.MillRecipes;
import com.jorislodewijks.morefood.common.tileentity.ModTileEntities;
import com.jorislodewijks.morefood.core.Reference;
import com.jorislodewijks.morefood.core.util.NBTHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityMill extends TileEntity implements ITickable {
	
	// Current Mill inventory
	private ItemStackHandler inventory = new ItemStackHandler(3);
	// 0: millstone
	// 1: input
	// 2: output
	
	// Work values
	private int currentWork;
	private int maxWork; 
	
	// Redstone automation
	private boolean powered;
	private boolean shouldUpdate;
	
	// Custom name
	private ITextComponent customName;
	
	public TileEntityMill() {
		super(ModTileEntities.tileEntityMill);
		
		this.maxWork = 200;
	}
	
	@Override
	public void tick() {
		if (this.shouldUpdate) {
			this.updateRedstone();
			this.shouldUpdate = false;
		}
		
		if ( !this.world.isRemote() ) {
			if ( canMill() ) {
				this.currentWork++;
				
				if ( this.currentWork > this.maxWork ) {
					this.millItem();
					this.currentWork = 0;
					this.maxWork = MillRecipes.getInstance().getMillingWorkNeeded(this.inventory.getStackInSlot(1));
				}
			} else {
				this.currentWork = 0;
			}
			
			BlockMill.setState(this.hasProgress() && this.canMill(), world, pos);
		}
	}
	
	public boolean hasProgress() {
		return this.currentWork > 0;
	}
	
	@OnlyIn(Dist.CLIENT)
	public boolean hasProgress(TileEntityMill tileEntityMill) {
		return tileEntityMill.getField(0) > 0;
	}
	
	public int getInventoryStackLimit() {
		return 64;
	}
	
	private void millItem() {
		if ( this.canMill() ) {
			ItemStack millstone = this.inventory.getStackInSlot(0);
			ItemStack input = this.inventory.getStackInSlot(1);
			
			ItemStack expectedOutput = MillRecipes.getInstance().getMillingResult(input);
			ItemStack output = this.inventory.getStackInSlot(2);
			
			if ( output.isEmpty() ) {
				this.inventory.setStackInSlot(2, expectedOutput.copy());
			} else {
				output.grow(expectedOutput.getCount());
			}
			
			input.shrink(1);
			
			// Damage the millstone.
			millstone.setDamage(millstone.getDamage() + 1);
			if ( millstone.getDamage() >= millstone.getMaxDamage() ) {
				millstone.shrink(1);
				world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
			}
		}
	}
	
	public boolean canMill() {
		if (this.isPowered() || this.inventory.getStackInSlot(1).isEmpty()) return false;
		
		ItemStack millstone = this.inventory.getStackInSlot(0);
		
		// Millstone is still good.
		if ( millstone.getDamage() < millstone.getMaxDamage() ) { 
			ItemStack expectedRecipeOutput = MillRecipes.getInstance().getMillingResult(this.inventory.getStackInSlot(1));
			
			// Check for a existing recipe with the inserted item.
			if ( expectedRecipeOutput.isEmpty() ) { 
				return false;
			} else {
				ItemStack output = this.inventory.getStackInSlot(2);
				
				if(output.isEmpty()) {
					return true;
				} else if (!output.isItemEqual(expectedRecipeOutput)) {
					return false;
				} else if (output.getCount() + expectedRecipeOutput.getCount() <= this.getInventoryStackLimit()) {
					return true;
				} else {
					return output.getCount() + expectedRecipeOutput.getCount() <= output.getMaxStackSize();
				}
			}
		} else {
			
			// Millstone is fully damaged.
			return false;
		}
	}
	
	public void updateRedstone() {
		this.powered = this.world.getRedstonePowerFromNeighbors(this.pos) != 0;
	}
	
	public boolean isPowered() {
		return this.powered;
	}
	
	public double getScaledProgress() {
		return this.currentWork / (double) this.maxWork;
	}
	
	public String getUnlocalisedName() {
		return this.getUnlocalisedName();
	}
	
	public boolean isUsableByPlayer (EntityPlayer playerIn) {
		return this.world.getTileEntity(this.pos) != this ? false : playerIn.getDistanceSq(
				(double)this.pos.getX() + 0.5D,
				(double)this.pos.getY() + 0.5D,
				(double)this.pos.getZ() + 0.5D
				) <= 64.0D;
	}
	
	public ITextComponent getName() {
		return (this.customName != null ? this.customName : new TextComponentTranslation(Reference.MOD_ID + ".container.mill"));
	}
	
	public boolean hasCustomName() {
		return this.customName != null;
	}
	
	@Nullable
	public ITextComponent getCustomName() {
		return customName;
	}
	
	public void setCustomName(@Nullable ITextComponent name) {
		this.customName = name;
	}
	
	public ItemStackHandler getInventory() {
		return inventory;
	}
	
	public int getField(int id) {
		switch(id) 
		{
		case 0:
			return this.currentWork;
		case 1:
			return this.maxWork;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch(id) 
		{
		case 0:
			this.currentWork = value;
			break;
		case 1:
			this.maxWork = value;
			break;
		}
	}
	
	public void saveAndSync() {
		IBlockState state = this.world.getBlockState(this.pos);
		this.world.markBlockRangeForRenderUpdate(this.pos, this.pos);
		this.world.notifyBlockUpdate(pos, state, state, 3);
		this.markDirty();
	}
	
	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		this.currentWork = compound.getInt(NBTHelper.CURR_PROGRESS);
		this.inventory.deserializeNBT(compound.getCompound(NBTHelper.INVENTORY));
		this.shouldUpdate = true;
		
		if ( compound.contains("CustomName", 8) ) {
			this.customName = ITextComponent.Serializer.fromJson(compound.getString("CustomName"));
		}
	}
	
	@Override
	public NBTTagCompound write(NBTTagCompound compound) {
		compound.setInt(NBTHelper.CURR_PROGRESS, this.currentWork);
		compound.setTag(NBTHelper.INVENTORY, this.inventory.serializeNBT());
		
		if ( this.customName != null ) {
			compound.setString("CustomName", ITextComponent.Serializer.toJson(this.customName));
		}
		
		return super.write(compound);
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(this.getPos(), 0, this.getUpdateTag());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.read(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound getUpdateTag() {
		return this.write(new NBTTagCompound());
	}
	
	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.read(tag);
	}
	
}