package com.soba.sobamod.init;

import com.soba.sobamod.crops.item.ItemBuckwheatSeed;
import com.soba.sobamod.crops.item.ItemGreenOnionSeeds;
import com.soba.sobamod.crops.item.ItemSoySeeds;
import com.soba.sobamod.crops.item.ItemWasabiSeeds;
import com.soba.sobamod.crops.item.ItemYamSeeds;
import com.soba.sobamod.returnplate.ItemOwan;
import com.soba.sobamod.returnplate.ItemPlate;
import com.soba.sobamod.returnplate.ItemSeiro;
import com.soba.sobamod.returnplate.ItemSoba;
import com.soba.sobamod.returnplate.ItemSoy;
import com.soba.sobamod.returnplate.ItemTuyu;
import com.soba.sobamod.returnplate.ItemWanko;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.MinecraftForge;

public class RegisterItem {

	//アイテムの定義
	//道具
	public static Item konebati;
	public static Item nosiita;
	public static Item mennbo;
	public static Item manaita;
	public static Item menHotyo;
	public static Item komaita;
	public static Item sukuizaru;
	public static Item yudenabe;
	public static Item mizuYudenabe;
	public static Item boilMizuYude;
	public static Item grater;
	public static Item oilThrower;
	public static Item gridiron;
	public static Item camas;
	public static Item hotyo;

	public static Item yuto;
	public static Item sobaYudenabe;
	public static Item sobayuYuto;
	//皿
	public static Item seiroWaku;
	public static Item seiroSudare;
	public static Item seiro;
	public static Item clayPlate;
	public static Item plate;
	public static Item clayOwan;
	public static Item owan;
	//材料
	public static Item sobanomi;
	public static Item sobako;
	public static Item flour;
	public static Item dou;
	public static Item sobaDough;
	public static Item tatanndakizi;
	public static Item kittakizi;
	public static Item yudetasoba;
	public static Item soba;
	public static Item syouyu;
	public static Item kaesi;
	public static Item dasi;
	public static Item tuyu;
	public static Item originTyoko;
	public static Item sobatyoko;
	public static Item sobatuyu;
	public static Item seirosoba;
	public static Item seiroset;
	public static Item yakisobaMenn;
	public static Item yakisoba;

	public static Item remainingTuyu;
	public static Item sobayuTuyu;
	//海老に関連するもの
	public static Item shrimp;
	public static Item koromo;
	public static Item pot;
	public static Item oilPot;
	public static Item boilOilPot;
	public static Item rapeseedOil;
	public static Item koromoShrimp;
	public static Item tenpura;
	public static Item ebitensoba;
	//作物
	public static Item greenOnion;
	public static Item chopGreOni;
	public static Item yam;
	public static Item gratedYam;
	public static Item wasabi;
	public static Item gratedWasabi;
	public static Item tororoSoba;
	//どんぶりもの
	public static Item tenkasu;
	public static Item tanukiSoba;
	public static Item salt;
	public static Item camasSalt;
	public static Item bittern;
	public static Item camasAmajio;
	public static Item amajio;
	public static Item soyBean;
	public static Item soyMilk;
	public static Item tofu;
	public static Item chopTofu;
	public static Item friedTofu;
	public static Item kitsuneSoba;
	//わんこ
	public static Item wankoSobaOwan;
	public static Item wankoOwanTuyu;
	public static Item wankoSoba;
	//かき揚げなど
	public static Item carrotStick;
	public static Item potatoStick;
	public static Item kakiageSeed;
	public static Item kakiage;
	public static Item kakiageSoba;
	public static Item mushroomTen;
	public static Item kinoTenSoba;
	//お菓子
	public static Item karintoDough;
	public static Item sobaKarinto;
	public static Item sobaCookie;
	//にしん
	public static Item blower;
	public static Item herring;
	public static Item driedHerring;
	public static Item pieceHerring;
	public static Item herringRoe;
	public static Item Kazunoko;
	public static Item driedPieceHerring;
	public static Item Migakinishin;
	public static Item kanro;
	public static Item kanroPot;
	public static Item boilKanroPot;
	public static Item NishinKanroni;
	public static Item NishinSoba;

	/**アイテムを登録するメゾット*/
	public static void register() {

		konebati = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("konebachi")
				.setTextureName("noodlesmod:konebati")
				.setMaxStackSize(1);
		GameRegistry.registerItem(konebati, "konebati");

		nosiita = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("noshiita")
				.setTextureName("noodlesmod:nosiita")
				.setMaxStackSize(1);
		GameRegistry.registerItem(nosiita, "nosiita");

		mennbo = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("menbo")
				.setTextureName("noodlesmod:mennbo");
		GameRegistry.registerItem(mennbo, "mennbo");

		manaita = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("manaita")
				.setTextureName("noodlesmod:manaita")
				.setMaxStackSize(1);
		GameRegistry.registerItem(manaita, "manaita");

		menHotyo = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("menkirihocho")
				.setTextureName("noodlesmod:men_hotyo")
				.setMaxStackSize(1);
		GameRegistry.registerItem(menHotyo, "menHotyo");

		komaita = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("komaita")
				.setTextureName("noodlesmod:komaita")
				.setMaxStackSize(1);
		GameRegistry.registerItem(komaita, "komaita");

		sukuizaru = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sukuizaru")
				.setTextureName("noodlesmod:sukuizaru");
		GameRegistry.registerItem(sukuizaru, "sukuizaru");

		yudenabe = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("yudenabe")
				.setTextureName("noodlesmod:yudenabe");
		GameRegistry.registerItem(yudenabe, "yudenabe");

		mizuYudenabe = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("mizuiriyudenabe")
				.setTextureName("noodlesmod:mizuiriyudenabe")
				.setMaxStackSize(1);
		GameRegistry.registerItem(mizuYudenabe, "mizuiriyudenabe");

		boilMizuYude = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("boilMizuYude")
				.setTextureName("noodlesmod:boil_mizu_yude")
				.setMaxStackSize(1);
		GameRegistry.registerItem(boilMizuYude, "boilMizuYude");

		grater = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("grater")
				.setTextureName("noodlesmod:grater")
				.setMaxStackSize(1);
		GameRegistry.registerItem(grater, "grater");

		oilThrower = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("oilThrower")
				.setTextureName("noodlesmod:oil_thrower")
				.setMaxStackSize(1);
		GameRegistry.registerItem(oilThrower, "oilThrower");

		gridiron = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("gridiron")
				.setTextureName("noodlesmod:gridiron");
		GameRegistry.registerItem(gridiron, "gridiron");

		camas = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("camas")
				.setTextureName("noodlesmod:camas");
		GameRegistry.registerItem(camas, "camas");

		hotyo = new ItemSword(Item.ToolMaterial.STONE)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("hotyo")
				.setTextureName("noodlesmod:hotyo")
				.setMaxStackSize(1);
		GameRegistry.registerItem(hotyo, "hotyo");

		yuto = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("yuto")
				.setTextureName("noodlesmod:yuto")
				.setMaxStackSize(1);
		GameRegistry.registerItem(yuto, "yuto");

		sobaYudenabe = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobaYudenabe")
				.setTextureName("noodlesmod:soba_yudenabe")
				.setContainerItem(yudenabe)
				.setMaxStackSize(1);
		GameRegistry.registerItem(sobaYudenabe, "sobaYudenabe");

		sobayuYuto = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobayuYuto")
				.setTextureName("noodlesmod:sobayu_yuto")
				.setContainerItem(yuto)
				.setMaxStackSize(1);
		GameRegistry.registerItem(sobayuYuto, "sobayuYuto");
		//
		seiroWaku = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("seiroWaku")
				.setTextureName("noodlesmod:seiro_waku");
		GameRegistry.registerItem(seiroWaku, " seiroWaku");

		seiroSudare = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("seiroSudare")
				.setTextureName("noodlesmod:seiro_sudare");
		GameRegistry.registerItem(seiroSudare, "seiroSudare");

		seiro = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("seiro")
				.setTextureName("noodlesmod:seiro");
		GameRegistry.registerItem(seiro, "seiro");

		clayPlate = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("tsuchiZara")
				.setTextureName("noodlesmod:tuti_zara")
				.setMaxStackSize(1);
		GameRegistry.registerItem(clayPlate, "clayPlate");

		plate = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sara")
				.setTextureName("noodlesmod:sara");
		GameRegistry.registerItem(plate, "plate");

		clayOwan = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("tuchiOwan")
				.setTextureName("noodlesmod:tuchi_owan")
				.setMaxStackSize(1);
		GameRegistry.registerItem(clayOwan, "tuchiOwan");

		owan = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("owan")
				.setTextureName("noodlesmod:owan");
		GameRegistry.registerItem(owan, "owan");

		sobanomi = new ItemBuckwheatSeed()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobanomi")
				.setTextureName("noodlesmod:sobanomi");
		GameRegistry.registerItem(sobanomi, "sobanomi");

		sobako = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobako")
				.setTextureName("noodlesmod:sobako");
		GameRegistry.registerItem(sobako, "sobako");

		flour = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("komugiko")
				.setTextureName("noodlesmod:komugiko");
		GameRegistry.registerItem(flour, "flour");

		dou = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("dou")
				.setTextureName("noodlesmod:dou")
				.setMaxStackSize(16);
		GameRegistry.registerItem(dou, "dou");

		sobaDough = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kiji")
				.setTextureName("noodlesmod:kizi");
		GameRegistry.registerItem(sobaDough, "sobaDough");

		tatanndakizi = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("tatandakiji")
				.setTextureName("noodlesmod:tatanndakizi")
				.setMaxStackSize(16);
		GameRegistry.registerItem(tatanndakizi, "tatanndakizi");

		kittakizi = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kittakiji")
				.setTextureName("noodlesmod:kittakizi");
		GameRegistry.registerItem(kittakizi, "kittakizi");

		yudetasoba = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("yudetasoba")
				.setTextureName("noodlesmod:yudetasoba");
		GameRegistry.registerItem(yudetasoba, "yudetasoba");

		soba = new ItemSoba(5)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("soba")
				.setTextureName("noodlesmod:soba")
				.setMaxStackSize(1);
		GameRegistry.registerItem(soba, "soba");

		syouyu = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("shouyu")
				.setTextureName("noodlesmod:syouyu")
				.setContainerItem(Items.glass_bottle)
				.setMaxStackSize(1);
		GameRegistry.registerItem(syouyu, "syouyu");

		kaesi = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kaeshi")
				.setTextureName("noodlesmod:kaesi")
				.setMaxStackSize(1);
		GameRegistry.registerItem(kaesi, "kaesi");

		dasi = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("dashi")
				.setTextureName("noodlesmod:dasi")
				.setContainerItem(Items.glass_bottle)
				.setMaxStackSize(1);
		GameRegistry.registerItem(dasi, "dasi");

		tuyu = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("tuyu")
				.setTextureName("noodlesmod:tuyu")
				.setMaxStackSize(1)
				.setContainerItem(Items.glass_bottle);
		GameRegistry.registerItem(tuyu, "tuyu");

		originTyoko = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobachokonomoto")
				.setTextureName("noodlesmod:origin_tyoko")
				.setMaxStackSize(1);
		GameRegistry.registerItem(originTyoko, "sobatyokonomoto");

		sobatyoko = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobachoko")
				.setTextureName("noodlesmod:sobatyoko");
		GameRegistry.registerItem(sobatyoko, "sobatyoko");

		sobatuyu = new ItemTuyu(3)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobatsuyu")
				.setTextureName("noodlesmod:sobatuyu");
		GameRegistry.registerItem(sobatuyu, "sobatuyu");

		seirosoba = new ItemSeiro(8)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("seirosoba")
				.setTextureName("noodlesmod:seirosoba");
		GameRegistry.registerItem(seirosoba, "seirosoba");

		seiroset = new Item()
				.setUnlocalizedName("seiroset")
				.setTextureName("noodlesmod:seiroset")
				.setMaxStackSize(1)
				.setContainerItem(RegisterItem.seiro);
		GameRegistry.registerItem(seiroset, "seiroset");

		yakisobaMenn = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("yakisobamen")
				.setTextureName("noodlesmod:yakisoba_menn")
				.setMaxStackSize(1);
		GameRegistry.registerItem(yakisobaMenn, "yakisobaMenn");

		yakisoba = new ItemPlate(8)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("yakisoba")
				.setTextureName("noodlesmod:yakisoba");
		GameRegistry.registerItem(yakisoba, "yakisoba");

		remainingTuyu = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("remainingTuyu")
				.setTextureName("noodlesmod:remaining_tuyu")
				.setMaxStackSize(1);
		GameRegistry.registerItem(remainingTuyu, "remainingTuyu");

		sobayuTuyu = new ItemTuyu(5)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobayuTuyu")
				.setTextureName("noodlesmod:sobayu_tuyu");
		GameRegistry.registerItem(sobayuTuyu, "sobayuTuyu");

		shrimp = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("ebi")
				.setTextureName("noodlesmod:shrimp");
		GameRegistry.registerItem(shrimp, "ebi");

		koromo = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("koromo")
				.setTextureName("noodlesmod:koromo");
		GameRegistry.registerItem(koromo, "koromo");

		pot = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("nabe")
				.setTextureName("noodlesmod:nabe");
		GameRegistry.registerItem(pot, "nabe");

		oilPot = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("aburanabe")
				.setTextureName("noodlesmod:aburanabe")
				.setContainerItem(RegisterItem.pot);
		GameRegistry.registerItem(oilPot, "aburanabe");

		boilOilPot = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("boilOilPot")
				.setTextureName("noodlesmod:boil_oil_pot")
				.setContainerItem(pot)
				.setMaxStackSize(1);
		GameRegistry.registerItem(boilOilPot, "boilOilPot");

		rapeseedOil = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("nataneabura")
				.setContainerItem(Items.glass_bottle)
				.setTextureName("noodlesmod:nataneabura");
		GameRegistry.registerItem(rapeseedOil, "nataneabura");

		koromoShrimp = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("koromotukiebi")
				.setTextureName("noodlesmod:koromo_ebi");
		GameRegistry.registerItem(koromoShrimp, "koromotukiebi");

		tenpura = new ItemFood(3, 5.0F, false)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("tenpura")
				.setTextureName("noodlesmod:tenpura");
		GameRegistry.registerItem(tenpura, "tenpura");

		ebitensoba = new ItemOwan(8)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("ebitensoba")
				.setTextureName("noodlesmod:ebitensoba");
		GameRegistry.registerItem(ebitensoba, "ebitensoba");

		greenOnion = new ItemGreenOnionSeeds()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("greenOnion")
				.setTextureName("noodlesmod:green_onion");
		GameRegistry.registerItem(greenOnion, "greenOnion");

		chopGreOni = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("chopGreenOnion")
				.setTextureName("noodlesmod:chop_greoni");
		GameRegistry.registerItem(chopGreOni, "chopGreOni");

		yam = new ItemYamSeeds()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("yam")
				.setTextureName("noodlesmod:yam");
		GameRegistry.registerItem(yam, "yam");

		gratedYam = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("gratedYam")
				.setTextureName("noodlesmod:grated_yam");
		GameRegistry.registerItem(gratedYam, "gratedYam");

		wasabi = new ItemWasabiSeeds()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("wasabi")
				.setTextureName("noodlesmod:wasabi");
		GameRegistry.registerItem(wasabi, "wasabi");

		gratedWasabi = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("gratedWasabi")
				.setTextureName("noodlesmod:grated_wasabi");
		GameRegistry.registerItem(gratedWasabi, "gratedWasabi");

		tororoSoba = new ItemOwan(8)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("tororoSoba")
				.setTextureName("noodlesmod:tororo_soba");
		GameRegistry.registerItem(tororoSoba, "tororoSoba");

		tenkasu = new ItemFood(2, 0, true)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("tenkasu")
				.setTextureName("noodlesmod:tenkasu");
		GameRegistry.registerItem(tenkasu, "tenkasu");

		tanukiSoba = new ItemOwan(8)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("tanukiSoba")
				.setTextureName("noodlesmod:tanuki_soba");
		GameRegistry.registerItem(tanukiSoba, "tanukiSoba");

		salt = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("salt")
				.setTextureName("noodlesmod:salt");
		GameRegistry.registerItem(salt, "salt");

		camasSalt = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("camasSalt")
				.setTextureName("noodlesmod:camas_salt");
		GameRegistry.registerItem(camasSalt, "camasSalt");

		bittern = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("bittern")
				.setTextureName("noodlesmod:bittern")
				.setContainerItem(Items.bucket);
		GameRegistry.registerItem(bittern, "bittern");

		camasAmajio = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("camasAmajio")
				.setTextureName("noodlesmod:camas_amajio")
				.setContainerItem(RegisterItem.camas);
		GameRegistry.registerItem(camasAmajio, "camasAmajio");

		amajio = new ItemFood(2, 1.0F, false)
				.setPotionEffect(1, 30, 1, 90.0F)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("amajio")
				.setTextureName("noodlesmod:amajio");
		GameRegistry.registerItem(amajio, "amajio");

		soyBean = new ItemSoySeeds()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("soyBean")
				.setTextureName("noodlesmod:soy_bean");
		GameRegistry.registerItem(soyBean, "soyBean");

		MinecraftForge.addGrassSeed(new ItemStack(RegisterItem.soyBean), 1);

		soyMilk = new ItemSoy(5)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("soyMilk")
				.setTextureName("noodlesmod:soy_milk")
				.setContainerItem(Items.glass_bottle);
		GameRegistry.registerItem(soyMilk, "soyMilk");

		tofu = new ItemFood(6, 2.0F, false)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("tofu")
				.setTextureName("noodlesmod:tofu");
		GameRegistry.registerItem(tofu, "tofu");

		chopTofu = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("chopTofu")
				.setTextureName("noodlesmod:chop_tofu");
		GameRegistry.registerItem(chopTofu, "chopTofu");

		friedTofu = new ItemFood(6, 4.0F, false)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("friedTofu")
				.setTextureName("noodlesmod:fried_tofu");
		GameRegistry.registerItem(friedTofu, "friedTofu");

		kitsuneSoba = new ItemOwan(8)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kitsuneSoba")
				.setTextureName("noodlesmod:kitsune_soba");
		GameRegistry.registerItem(kitsuneSoba, "kitsuneSoba");

		wankoSobaOwan = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("wankoSobaOwan")
				.setTextureName("noodlesmod:wanko_owan");
		GameRegistry.registerItem(wankoSobaOwan, "wankoSobaOwan");

		wankoOwanTuyu = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("wankoOwanTuyu")
				.setTextureName("noodlesmod:wanko_tuyu");
		GameRegistry.registerItem(wankoOwanTuyu, "wankoOwanTuyu");

		wankoSoba = new ItemWanko(2)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("wankoSoba")
				.setTextureName("noodlesmod:wanko_soba")
				.setContainerItem(RegisterItem.wankoOwanTuyu);
		GameRegistry.registerItem(wankoSoba, "wankoSoba");

		carrotStick = new ItemFood(1, 0.5F, true)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("carrotStick")
				.setTextureName("noodlesmod:carrot_stick");
		GameRegistry.registerItem(carrotStick, "carrotStick");

		potatoStick = new ItemFood(1, 0.5F, true)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("potatoStick")
				.setTextureName("noodlesmod:potato_stick");
		GameRegistry.registerItem(potatoStick, "potatoStick");

		kakiageSeed = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kakiageSeed")
				.setTextureName("noodlesmod:kakiage_seed");
		GameRegistry.registerItem(kakiageSeed, "kakiageSeed");

		kakiage = new ItemFood(4, 2.0F, false)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kakiage")
				.setTextureName("noodlesmod:kakiage");
		GameRegistry.registerItem(kakiage, "kakiage");

		kakiageSoba = new ItemOwan(8)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kakiageSoba")
				.setTextureName("noodlesmod:kakiage_soba");
		GameRegistry.registerItem(kakiageSoba, "kakiageSoba");

		mushroomTen = new ItemFood(3, 1.0F, false)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("mushroomTen")
				.setTextureName("noodlesmod:mushroom_ten");
		GameRegistry.registerItem(mushroomTen, "mushroomTen");

		kinoTenSoba = new ItemOwan(8)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kinoTenSoba")
				.setTextureName("noodlesmod:kino_ten_soba");
		GameRegistry.registerItem(kinoTenSoba, "kinoTenSoba");

		karintoDough = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("karintoDough")
				.setTextureName("noodlesmod:karinto_dough");
		GameRegistry.registerItem(karintoDough, "karintoDough");

		sobaKarinto = new ItemFood(10, 0.5F, false)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobaKarinto")
				.setTextureName("noodlesmod:soba_karinto");
		GameRegistry.registerItem(sobaKarinto, "sobaKarinto");

		sobaCookie = new ItemFood(2, 0.5F, true)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("sobaCookie")
				.setTextureName("noodlesmod:soba_cookie");
		GameRegistry.registerItem(sobaCookie, "sobaCookie");

		blower = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("blower")
				.setTextureName("noodlesmod:blower")
				.setMaxStackSize(1);
		GameRegistry.registerItem(blower, "blower");

		herring = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("herring")
				.setTextureName("noodlesmod:herring");
		GameRegistry.registerItem(herring, "herring");

		driedHerring = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("driedHerring")
				.setTextureName("noodlesmod:dried_herring");
		GameRegistry.registerItem(driedHerring, "driedHerring");

		pieceHerring = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("pieceHerring")
				.setTextureName("noodlesmod:piece_herring");
		GameRegistry.registerItem(pieceHerring, "pieceHerring");

		herringRoe = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("herringRoe")
				.setTextureName("noodlesmod:herring_roe");
		GameRegistry.registerItem(herringRoe, "herringRoe");

		Kazunoko = new ItemFood(3, 0.5F, false)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("Kazunoko")
				.setTextureName("noodlesmod:Kazunoko");
		GameRegistry.registerItem(Kazunoko, "Kazunoko");

		driedPieceHerring = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("driedPieceHerring")
				.setTextureName("noodlesmod:dried_piece_herring");
		GameRegistry.registerItem(driedPieceHerring, "driedPieceHerring");

		Migakinishin = new ItemFood(5, 1.0F, false)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("Migakinishin")
				.setTextureName("noodlesmod:Migakinishin");
		GameRegistry.registerItem(Migakinishin, "Migakinishin");

		kanro = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kanro")
				.setTextureName("noodlesmod:kanro")
				.setContainerItem(Items.glass_bottle)
				.setMaxStackSize(1);
		GameRegistry.registerItem(kanro, "kanro");

		kanroPot = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("kanroPot")
				.setTextureName("noodlesmod:kanro_pot")
				.setMaxStackSize(1);
		GameRegistry.registerItem(kanroPot, "kanroPot");

		boilKanroPot = new Item()
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("boilKanroPot")
				.setTextureName("noodlesmod:boil_kanro_pot")
				.setContainerItem(pot)
				.setMaxStackSize(1);
		GameRegistry.registerItem(boilKanroPot, "boilKanroPot");

		NishinKanroni = new ItemFood(6, 1.5F, false)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("NishinKanroni")
				.setTextureName("noodlesmod:nishin_kanroni");
		GameRegistry.registerItem(NishinKanroni, "NishinKanroni");

		NishinSoba = new ItemOwan(8)
				.setCreativeTab(RegisterOther.tabNoodles)
				.setUnlocalizedName("NishinSoba")
				.setTextureName("noodlesmod:nishin_soba");
		GameRegistry.registerItem(NishinSoba, "NishinSoba");
	}
}
