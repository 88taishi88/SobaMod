package com.soba.sobamod.blocks;

import com.soba.sobamod.SobaModCore;
import com.soba.sobamod.init.RegisterBlock;
import com.soba.sobamod.init.RegisterOther;
import com.soba.sobamod.tileentity.TileEntityIshiusu;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Ishiusu extends BlockContainer{

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconBottom;

	public Ishiusu(Material material) {
		super(material);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("noodlesmod:block_ishiusu_side");
		this.iconTop = iconRegister.registerIcon("noodlesmod:block_ishiusu_top");
		this.iconBottom = iconRegister.registerIcon("noodlesmod:block_ishiusu_bottom");
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
    	return side == 0 ? this.iconBottom : (side == 1 ? this.iconTop : this.blockIcon);
    }

    public Item getItemDropped(World world, int x, int y, int z) {
    	return Item.getItemFromBlock(RegisterBlock.blockIshiusu);
    }

    public void onBlockAdded(World world, int x, int y, int z) {
    	super.onBlockAdded(world, x, y, z);
    	this.setDefaultDiraction(world, x, y, z);
    }

	private void setDefaultDiraction(World world, int x, int y, int z) {
		if(!world.isRemote ) {
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x, y, z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4 = world.getBlock(x + 1, y, z);

			byte b0 = 3;

			if(b1.func_149730_j() && !b2.func_149730_j()) {
				b0 = 3;
			}

			if(b2.func_149730_j() && !b1.func_149730_j()) {
				b0 = 2;
			}

			if(b3.func_149730_j() && !b4.func_149730_j()) {
				b0 = 5;
			}

			if(b4.func_149730_j() && !b3.func_149730_j()) {
				b0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			FMLNetworkHandler.openGui(player, SobaModCore.instance, RegisterOther.guiIDIshiusu, world, x, y, z);
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityIshiusu();
	}

	//TODO rondomDisplayTick

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack) {
		int l =MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;

		if(l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if(l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if(l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if(l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}

		if(itemstack.hasDisplayName()) {
			((TileEntityIshiusu)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
		}
	}

}
