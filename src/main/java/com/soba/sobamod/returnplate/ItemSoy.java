package com.soba.sobamod.returnplate;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSoy extends ItemFood
{
	 private static final String __OBFID = "CL_00001778";
		private CreativeTabs tabToDisplayOn;

	    public ItemSoy(int p_i45330_1_)
	    {
	        super(p_i45330_1_, false);
	        this.setMaxStackSize(1);
	    }

	    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
	    {
	        super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
	        return new ItemStack(Items.glass_bottle);
	    }

		public Item setCreativeTab(CreativeTabs tabNoodles) {
			this.tabToDisplayOn = tabNoodles;
	        return this;
		}

		@SideOnly(Side.CLIENT)
	    public CreativeTabs getCreativeTab()
	    {
	        return this.tabToDisplayOn;
	    }

}