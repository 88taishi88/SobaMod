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

public class Ishiusu extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconBottom;

	public Ishiusu() {
		super(Material.rock);
		this.setHardness(5.0F);
		this.setResistance(0.5F);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.75F, 0.5F + f);
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public Item getItemDropped(World world, int x, int y, int z) {
		return Item.getItemFromBlock(RegisterBlock.blockIshiusu);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, SobaModCore.instance, RegisterOther.guiIDIshiusu, world, x, y, z);
		}
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int i1 = world.getBlockMetadata(x, y, z) & 4;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2 | i1, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 1 | i1, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3 | i1, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 0 | i1, 2);
        }
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityIshiusu();
	}
}
