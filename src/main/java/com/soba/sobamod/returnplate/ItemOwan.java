package com.soba.sobamod.returnplate;

import com.soba.sobamod.init.RegisterItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemOwan extends ItemFood
{
    private static final String __OBFID = "CL_00001778";
	private CreativeTabs tabToDisplayOn;

    public ItemOwan(int p_i45330_1_)
    {
        super(p_i45330_1_, false);
        this.setMaxStackSize(1);
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
        p_77654_2_.playSoundAtEntity(p_77654_3_, "noodlesmod:susuru", 1.0F, 1.0F);
        return new ItemStack(RegisterItem.owan);
    }

    @Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
		return 42;
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