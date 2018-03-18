package com.soba.sobamod.init;

import com.soba.sobamod.SobaModCore;
import com.soba.sobamod.blocks.Ishiusu;
import com.soba.sobamod.crops.Buckwheat;
import com.soba.sobamod.crops.GreenOnion;
import com.soba.sobamod.crops.Soy;
import com.soba.sobamod.crops.Wasabi;
import com.soba.sobamod.crops.Yam;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RegisterBlock {

	//作物の定義
	public static Block Buckwheat;
	public static Block GreenOnion;
	public static Block Yam;
	public static Block Wasabi;
	public static Block Soy;

	//ブロックツールの定義
	public static Block blockIshiusu;

	/**ブロックを登録するメゾット*/
	public static void register() {

		//作物の登録
		Buckwheat = new Buckwheat()
				.setBlockName("Buckwheast");
		GameRegistry.registerBlock(Buckwheat, "buckwheat");

		GreenOnion = new GreenOnion()
				.setBlockName("GreenOnion");
		GameRegistry.registerBlock(GreenOnion, "GreenOnion");

		Yam = new Yam()
				.setBlockName("Yam");
		GameRegistry.registerBlock(Yam, "Yam");

		Wasabi = new Wasabi()
				.setBlockName("Wasabi");
		GameRegistry.registerBlock(Wasabi, "Wasabi");

		Soy = new Soy()
				.setBlockName("Soy");
		GameRegistry.registerBlock(Soy, "Soy");

		//ブロックツールの登録
		blockIshiusu = new Ishiusu(Material.rock)
				.setBlockName("Ishiusu")
				.setCreativeTab(RegisterOther.tabNoodles);
		GameRegistry.registerBlock(blockIshiusu, "blockIshiusu");
	}
}
