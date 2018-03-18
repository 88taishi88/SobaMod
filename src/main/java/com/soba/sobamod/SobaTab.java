package com.soba.sobamod;

import com.soba.sobamod.init.RegisterItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SobaTab extends CreativeTabs {

	public SobaTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return RegisterItem.soba;
	}

}