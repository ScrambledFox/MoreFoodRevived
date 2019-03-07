package com.jorislodewijks.morefood.client.gui;

import com.jorislodewijks.morefood.common.tileentity.machine.TileEntityMill;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiMill extends GuiContainer {

	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/mill_gui.png");
	private final InventoryPlayer player;
	private final TileEntityMill tileentity;
	
	public GuiMill(InventoryPlayer player, TileEntityMill tileentity) {
		
		super(new ContainerMill(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tileName = this.tileentity.getName().getUnformattedComponentText();
		String test = Integer.toString(this.tileentity.getField(0));
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) + 3, 8, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedComponentText() /*"CurrentMillTime: " + test*/, 122, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		{
			GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
			this.mc.getTextureManager().bindTexture(TEXTURE);
			this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
			
			int l = this.getCookProgressScaled(24);
			this.drawTexturedModalRect(this.guiLeft + 77, this.guiTop + 35, 176, 15, l + 1, 17);
		}
	}
	
	private int getCookProgressScaled(int pixels)
	{
		int i = this.tileentity.getField(0);
		int j = this.tileentity.getField(1);
		return j != 0 && i != 0 ? i * pixels / j: 0;
	}
	
}
