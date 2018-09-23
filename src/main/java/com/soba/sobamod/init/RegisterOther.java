package com.soba.sobamod.init;

import com.soba.sobamod.SobaModCore;
import com.soba.sobamod.SobaTab;
import com.soba.sobamod.handler.GuiHandler;
import com.soba.sobamod.renderer.RenderIshiusu;
import com.soba.sobamod.tileentity.TileEntityIshiusu;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.FishingHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class RegisterOther {

	//実績の定義
	public static Achievement getBuckwheat;
	public static Achievement getSoba;
	public static Achievement getYakisoba;
	public static Achievement getDonmono;
	public static Achievement getEbi;
	public static Achievement getHerring;
	public static Achievement get64Ebi;
	public static Achievement getPlant;
	public static Achievement get64Plant;
	public static Achievement craftWanko;
	public static Achievement craft100Wanko;
	public static Achievement craft200Wanko;
	public static Achievement craft500Wanko;
	public static Achievement getTableware;
	//実績ページの定義
	public static AchievementPage SobaPage;
	//クリエイティブタブの定義
	public static CreativeTabs tabNoodles = new SobaTab("SobaMod");
	//GuiIDの定義
	public static final int guiIDIshiusu = 0;

	/**実績、鉱石辞書などを登録するメゾット*/
	@EventHandler
	public static void register() {

		//TileEntityの登録
		GameRegistry.registerTileEntity(TileEntityIshiusu.class, "Ishiusu");

		//ContainerItemの登録
		RegisterItem.konebati.setContainerItem(RegisterItem.konebati);
		RegisterItem.nosiita.setContainerItem(RegisterItem.nosiita);
		RegisterItem.mennbo.setContainerItem(RegisterItem.mennbo);
		RegisterItem.manaita.setContainerItem(RegisterItem.manaita);
		RegisterItem.menHotyo.setContainerItem(RegisterItem.menHotyo);
		RegisterItem.komaita.setContainerItem(RegisterItem.komaita);
		RegisterItem.sukuizaru.setContainerItem(RegisterItem.sukuizaru);
		RegisterItem.grater.setContainerItem(RegisterItem.grater);
		RegisterItem.oilThrower.setContainerItem(RegisterItem.oilThrower);
		RegisterItem.gridiron.setContainerItem(RegisterItem.gridiron);
		RegisterItem.hotyo.setContainerItem(RegisterItem.hotyo);
		RegisterItem.camasSalt.setContainerItem(RegisterItem.camasAmajio);
		RegisterItem.blower.setContainerItem(RegisterItem.blower);
		RegisterItem.driedHerring.setContainerItem(RegisterItem.herringRoe);
		RegisterItem.boilMizuYude.setContainerItem(RegisterItem.sobaYudenabe);

		//魚釣りの登録
		FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(RegisterItem.shrimp, 1), 55));
		FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(RegisterItem.herring, 20), 100));

		//種の登録
		MinecraftForge.addGrassSeed(new ItemStack(RegisterItem.sobanomi), 3);
		MinecraftForge.addGrassSeed(new ItemStack(RegisterItem.greenOnion), 1);
		MinecraftForge.addGrassSeed(new ItemStack(RegisterItem.yam), 1);
		MinecraftForge.addGrassSeed(new ItemStack(RegisterItem.wasabi), 1);

		//鉱石辞書の登録
		OreDictionary.registerOre("cropBuckwheat", RegisterItem.sobanomi);
		OreDictionary.registerOre("cropGreenOnion", RegisterItem.greenOnion);
		OreDictionary.registerOre("cropYam", RegisterItem.yam);
		OreDictionary.registerOre("cropWasabi", RegisterItem.wasabi);
		OreDictionary.registerOre("cropSoy", RegisterItem.soyBean);
		OreDictionary.registerOre("dustFlour", RegisterItem.flour);

		//GuiHandlerの登録
		NetworkRegistry.INSTANCE.registerGuiHandler(SobaModCore.instance, new GuiHandler());

		//実績の登録
		getBuckwheat = new Achievement("achievement.getBuckwheat", "getBuckwheat", 0, 0,
				new ItemStack(RegisterItem.sobanomi),
				(Achievement) null)
						.initIndependentStat().registerStat();
		getSoba = new Achievement("achievement.getSoba", "getSoba", 2, 2, new ItemStack(RegisterItem.seirosoba),
				getBuckwheat)
						.registerStat();
		getYakisoba = new Achievement("achievement.getYakisoba", "getYakisoba", 5, 2,
				new ItemStack(RegisterItem.yakisoba), getSoba)
						.registerStat();
		getDonmono = new Achievement("achievement.getDonmono", "getDonmono", 4, 0,
				new ItemStack(RegisterItem.ebitensoba), getSoba)
						.registerStat();
		getEbi = new Achievement("achievement:getEbi", "getEbi", 0, 3, Items.fishing_rod, getSoba)
				.registerStat();
		getHerring = new Achievement("achievement:getHerring", "getHerring", 0, 4, new ItemStack(RegisterItem.herring),
				getSoba)
						.registerStat();
		get64Ebi = new Achievement("achievement.get64Ebi", "get64Ebi", -2, 3, new ItemStack(RegisterItem.shrimp),
				getEbi)
						.setSpecial().registerStat();
		getPlant = new Achievement("achievement.getPlant", "getPlant", 0, -2, new ItemStack(RegisterItem.greenOnion),
				getBuckwheat)
						.registerStat();
		get64Plant = new Achievement("achievement.get64Plant", "get64Plant", 2, -4, new ItemStack(RegisterItem.soyBean),
				getPlant)
						.registerStat();
		craftWanko = new Achievement("achievement.craftWanko", "craftWanko", 6, 0,
				new ItemStack(RegisterItem.yudetasoba),
				getYakisoba)
						.registerStat();
		craft100Wanko = new Achievement("achievement.craft100Wanko", "craft100Wanko", 7, 2,
				new ItemStack(RegisterItem.wankoSobaOwan), craftWanko)
						.registerStat();
		craft200Wanko = new Achievement("achievement.craft200Wanko", "craft200Wanko", 7, 4,
				new ItemStack(RegisterItem.wankoOwanTuyu), craft100Wanko)
						.setSpecial().registerStat();
		craft500Wanko = new Achievement("achievement.craft500Wanko", "craft500Wanko", 9, 4,
				new ItemStack(RegisterItem.wankoSoba),
				craft200Wanko)
						.setSpecial().registerStat();
		getTableware = new Achievement("achievement.getTableware", "getTableware", 3, 5,
				new ItemStack(RegisterItem.seiro), getSoba)
						.registerStat();

		SobaPage = new AchievementPage("SobaMod Achievemnet", getBuckwheat, getSoba, getYakisoba, getDonmono, getEbi,
				getHerring, get64Ebi, getPlant, get64Plant,
				craftWanko, craft100Wanko, craft200Wanko, craft500Wanko, getTableware);
		AchievementPage.registerAchievementPage(SobaPage);

		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {

			TileEntitySpecialRenderer render1 = new RenderIshiusu();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIshiusu.class, render1);

		}
	}
}
