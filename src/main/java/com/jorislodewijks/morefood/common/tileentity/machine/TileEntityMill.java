package com.jorislodewijks.morefood.common.tileentity.machine;

import javax.annotation.Nullable;

import com.jorislodewijks.morefood.common.tileentity.ModTileEntities;
import com.jorislodewijks.morefood.core.util.NBTHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityMill extends TileEntity implements ITickable {
	
	// Current Mill inventory
	private ItemStackHandler inventory = new ItemStackHandler(3);
	
	// Work values
	private int currentWork;
	private int maxWork; 
	
	// Redstone automation
	private boolean powered;
	private boolean shouldUpdate;
	
	// Custom name
	private ITextComponent customName;
	
	public TileEntityMill(TileEntityType<?> tileentityTypeIn) {
		super(tileentityTypeIn);
	}
	
	public TileEntityMill() {
		super(ModTileEntities.tileEntityMill);
	}
	
	@Override
	public void tick() {
		if (this.shouldUpdate) {
			this.updateRedstone();
			this.shouldUpdate = false;
		}
		
		// TODO Milling logic
	}
	
	private void millItem() {
		
	}
	
	public boolean canMill() {
		if (this.isPowered() || this.inventory.getStackInSlot(1) == null) return false;
		return true;
	}
	
	public void updateRedstone() {
		this.powered = this.world.getRedstonePowerFromNeighbors(this.pos) != 0;
	}
	
	public boolean isPowered() {
		return this.powered;
	}
	
	public ItemStackHandler getInventory() {
		return inventory;
	}
	
	public double getScaledProgress() {
		return this.currentWork / (double) this.maxWork;
	}
	
	public String getUnlocalisedName() {
		return this.getUnlocalisedName();
	}
	
	public boolean isUsableByPlayer (EntityPlayer playerIn) {
		/*return this.world.getTileEntity(this.pos) != this ? false : playerIn.getDistanceSq(
				(double)this.pos.getX() + 0.5D,
				(double)this.pos.getY() + 0.5D,
				(double)this.pos.getZ() + 0.5D
				) <= 64.0D;
				*/
		return true;
	}
	
	public ITextComponent getName() {
		return (ITextComponent)(this.customName != null ? this.customName : new TextComponentTranslation("container.mill"));
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