package com.soba.sobamod.handler;

import com.soba.sobamod.SobaModCore;
import com.soba.sobamod.container.ContainerIshiusu;
import com.soba.sobamod.gui.GuiIshiusu;
import com.soba.sobamod.init.RegisterOther;
import com.soba.sobamod.tileentity.TileEntityIshiusu;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case RegisterOther.guiIDIshiusu:
				if(entity instanceof TileEntityIshiusu) {
					return new ContainerIshiusu(player.inventory, (TileEntityIshiusu) entity);
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case RegisterOther.guiIDIshiusu:
				if(entity instanceof TileEntityIshiusu) {
					return new GuiIshiusu(player.inventory, (TileEntityIshiusu) entity);
				}
				return null;
			}
		}
		return null;
	}

}
