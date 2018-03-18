package com.soba.sobamod.gui;

import org.lwjgl.opengl.GL11;

import com.soba.sobamod.container.ContainerIshiusu;
import com.soba.sobamod.tileentity.TileEntityIshiusu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiIshiusu extends GuiContainer {

	private static final ResourceLocation bground = new ResourceLocation("noodlesmod:textures/gui/ishiusu.png");

	private final TileEntityIshiusu ishiusu;

	public GuiIshiusu(InventoryPlayer inventoryPlayer, TileEntityIshiusu entity) {
		super(new ContainerIshiusu(inventoryPlayer, entity));

		this.ishiusu = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = this.ishiusu.hasCustomInventoryName() ? this.ishiusu.getInventoryName()
				: I18n.format(this.ishiusu.getInventoryName(), new Object[0]);

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2,
				4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

		int progress = this.ishiusu.getGrindProgressScaled(24);
		this.drawTexturedModalRect(k + 79, l + 34, 176, 0, progress + 1, 16);
	}

}
