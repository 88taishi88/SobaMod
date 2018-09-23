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
	public static final String VERSION = "1.9.0";

	@Metadata(MODID)
	public static ModMetadata meta;

	//インスタンスの登録
	@Instance(MODID)
	public static SobaModCore instance;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModInfo.loadInfo(meta);

		//登録クラスの呼び出し
		//アイテム登録クラス
		RegisterItem.register();
		//ブロック登録クラス
		RegisterBlock.register();
		//その他登録クラス
		RegisterOther.register();
		//レシピ登録クラス
		RegisterRecipe.register();
	}
}