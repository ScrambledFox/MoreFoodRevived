package com.jorislodewijks.morefood.client.gui;

import com.jorislodewijks.morefood.common.tileentity.machine.TileEntityMill;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class InteractionObjectMill implements IInteractionObject {

	private TileEntityMill tileentityMill;
	
	public InteractionObjectMill(TileEntityMill tileentityMill) {
		this.tileentityMill = tileentityMill;
	}
	
	@Override
	public ITextComponent getCustomName() {
		return tileentityMill.getCustomName();
	}
	
	@Override
	public ITextComponent getName() {
		return tileentityMill.getName();
	}
	
	@Override
	public boolean hasCustomName() {
		return tileentityMill.hasCustomName();
	}
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerMill(playerInventory, this.tileentityMill);
	}
	
	@Override
	public String getGuiID() {
		return Reference.MOD_ID + Reference.GUI_MILL;
	}
	
}