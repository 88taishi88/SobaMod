package com.soba.sobamod;

import com.soba.sobamod.init.RegisterBlock;
import com.soba.sobamod.init.RegisterItem;
import com.soba.sobamod.init.RegisterOther;
import com.soba.sobamod.init.RegisterRecipe;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = SobaModCore.MODID, version = SobaModCore.VERSION)
public class SobaModCore {
	public static final String MODID = "SobaMod";
	public static final String VERSION = "1.8.5beta";

	@Metadata(MODID)
	public static ModMetadata meta;

	//インスタンス化
	@Instance(MODID)
	public static SobaModCore instance;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModInfo.loadInfo(meta);

		//各メゾットの呼び出し
		//アイテム登録メゾット
		RegisterItem.register();
		//ブロック登録メゾット
		RegisterBlock.register();
		//その他登録メゾット
		RegisterOther.register();
		//レシピ登録メゾット
		RegisterRecipe.register();
	}
}