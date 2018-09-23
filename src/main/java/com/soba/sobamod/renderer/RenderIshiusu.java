package com.soba.sobamod.renderer;

import org.lwjgl.opengl.GL11;

import com.soba.sobamod.model.ModelIshiusu;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderIshiusu extends TileEntitySpecialRenderer {

	ResourceLocation texture = new ResourceLocation("noodlesmod:textures/models/ModelIshiusu.png");

	private ModelIshiusu model;

	public RenderIshiusu() {
		this.model = new ModelIshiusu();
	}

	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f) {
		GL11.glPushMatrix();

		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		this.bindTexture(texture);

		GL11.glPushMatrix();

		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();

		GL11.glPopMatrix();
	}

}
