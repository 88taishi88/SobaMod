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

	//�C���X�^���X�̓o�^
	@Instance(MODID)
	public static SobaModCore instance;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModInfo.loadInfo(meta);

		//�o�^�N���X�̌Ăяo��
		//�A�C�e���o�^�N���X
		RegisterItem.register();
		//�u���b�N�o�^�N���X
		RegisterBlock.register();
		//���̑��o�^�N���X
		RegisterOther.register();
		//���V�s�o�^�N���X
		RegisterRecipe.register();
	}
}