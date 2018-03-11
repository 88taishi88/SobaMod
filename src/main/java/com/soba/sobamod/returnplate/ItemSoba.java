package com.soba.sobamod.returnplate;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSoba extends ItemFood
{
	 private static final String __OBFID = "CL_00001778";
		private CreativeTabs tabToDisplayOn;
		private World world;
		private EntityPlayer entityPlayer;

	    public ItemSoba(int p_i45330_1_)
	    {
	        super(p_i45330_1_, false);
	        this.setMaxStackSize(1);
	    }

	    @Override
		public int getMaxItemUseDuration(ItemStack itemStack) {
			return 42;
	    }

	    public EnumAction getItemUseAction(ItemStack p_77661_1_)
	    {
	    	world.playSoundAtEntity(entityPlayer, "noodlesmod:susuru", 1.0F, 1.0F);
	    	return EnumAction.eat;
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
