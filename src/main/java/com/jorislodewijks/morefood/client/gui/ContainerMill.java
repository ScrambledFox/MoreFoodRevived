package com.jorislodewijks.morefood.client.gui;

import com.jorislodewijks.morefood.common.crafting.MillRecipes;
import com.jorislodewijks.morefood.common.item.ModItems;
import com.jorislodewijks.morefood.common.tileentity.machine.TileEntityMill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerMill extends Container {
	
	private final TileEntityMill tileentityMill;
	private int currentWork, maxWork;
	
	public ContainerMill (InventoryPlayer playerInventory, TileEntityMill tileentityMill) {
		this.tileentityMill = tileentityMill;
		IItemHandler itemHandler = tileentityMill.getInventory();
		
		this.addSlot(new SlotItemHandler(itemHandler, 0, 54, 45));
		this.addSlot(new SlotItemHandler(itemHandler, 1, 54, 23));
		this.addSlot(new SlotItemHandler(itemHandler, 2, 114, 35));
		
		for ( int y = 0; y < 3; y++ ) {
			for ( int x = 0; x < 9; x++ ) {
				this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		for ( int x = 0; x < 9; x++ ) {
			this.addSlot(new Slot(playerInventory, x, 8 + x * 18, 142));
		}
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for ( int i = 0; i < this.listeners.size(); ++i ) {
			IContainerListener listener = (IContainerListener)this.listeners.get(i);
			
			if (this.currentWork != this.tileentityMill.getField(0)) listener.sendWindowProperty(this, 0, this.tileentityMill.getField(0));
			if (this.maxWork != this.tileentityMill.getField(1)) listener.sendWindowProperty(this, 1, this.tileentityMill.getField(1));
		}
		
		this.currentWork = this.tileentityMill.getField(0);
		this.maxWork = this.tileentityMill.getField(1);
	}
	
	@Override
	public void updateProgressBar(int id, int data) {
		this.tileentityMill.setField(id, data);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tileentityMill.isUsableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = (Slot)this.inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack())  {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			
			if(index == 2) {
				if(!this.mergeItemStack(stack1, 3, 39, true)) {
					return ItemStack.EMPTY;
				}
				
				slot.onSlotChange(stack1, stack);
			}  else if(index != 1 && index != 0)  {
				if(canMill(stack1)) {
					if(!this.mergeItemStack(stack1, 0, 1, true)) {
						return ItemStack.EMPTY;
					} 
				} else if(stack1.getItem().equals(ModItems.MILLSTONE)) {
					if (!this.mergeItemStack(stack1, 0, 1, false)) { 
						return ItemStack.EMPTY;
					}
				} else if(index >= 3 && index < 30) {
					if (!this.mergeItemStack(stack1, 30, 39, false)) {
						return ItemStack.EMPTY;
					}
				} else if(index >= 30 && index < 39 && !this.mergeItemStack(stack1, 3, 30, false)) {
					return ItemStack.EMPTY;
				}
			}  else if(!this.mergeItemStack(stack1, 3, 39, false))  {
				return ItemStack.EMPTY;
			}
			
			if(stack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			}
			else {
				slot.onSlotChanged();
			}
			
			if(stack1.getCount() == stack.getCount()) {
				return ItemStack.EMPTY;
			} 
			
			slot.onTake(playerIn, stack1);
		}
		
		return stack;
	}
	
	private boolean canMill(ItemStack stack) {
		if ( MillRecipes.getInstance().getMillingResult(stack).isEmpty() ) {
			return false;
		} else {
			return true;
		}
	}
	
}