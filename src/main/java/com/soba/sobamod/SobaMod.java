package com.soba.sobamod;

import com.soba.sobamod.blocks.Ishiusu;
import com.soba.sobamod.crops.Buckwheat;
import com.soba.sobamod.crops.GreenOnion;
import com.soba.sobamod.crops.Soy;
import com.soba.sobamod.crops.Wasabi;
import com.soba.sobamod.crops.Yam;
import com.soba.sobamod.handler.GuiHandler;
import com.soba.sobamod.returnplate.ItemOwan;
import com.soba.sobamod.returnplate.ItemPlate;
import com.soba.sobamod.returnplate.ItemSeiro;
import com.soba.sobamod.returnplate.ItemSoba;
import com.soba.sobamod.returnplate.ItemSoy;
import com.soba.sobamod.returnplate.ItemTuyu;
import com.soba.sobamod.returnplate.ItemWanko;
import com.soba.sobamod.tileentity.TileEntityIshiusu;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.stats.Achievement;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.FishingHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid =SobaMod.MODID, version = SobaMod.VERSION)
public class SobaMod
{
    public static final String MODID = "SobaMod";
    public static final String VERSION = "1.8.5";

    @Metadata(MODID)
    public static ModMetadata meta;
    //Define Achievement
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
    //Define AchievementPage
    public static AchievementPage SobaPage;
    //Define CreativeTabs
    public static CreativeTabs tabNoodles = new SobaTab("SobaMod");
    //Define GUI
    @Instance(MODID)
    public static SobaMod instance;

    //Define Items,Blocks
    //Tools
    public static Item isiusu;
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
    //Plates
    public static Item seiroWaku;
    public static Item seiroSudare;
    public static Item seiro;
    public static Item clayPlate;
    public static Item plate;
    public static Item clayOwan;
    public static Item owan;
    //Materials
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
    //About shrimp
    public static Item shrimp;
    public static Item koromo;
    public static Item pot;
    public static Item oilPot;
    public static Item boilOilPot;
    public static Item rapeseedOil;
    public static Item koromoShrimp;
    public static Item tenpura;
    public static Item ebitensoba;
    //Crops
    public static Item greenOnion;
    public static Item chopGreOni;
    public static Item yam;
    public static Item gratedYam;
    public static Item wasabi;
    public static Item gratedWasabi;
    public static Item tororoSoba;
    //Donmono
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
    //wanko
    public static Item wankoSobaOwan;
    public static Item wankoOwanTuyu;
    public static Item wankoSoba;
    //kakiage etc
    public static Item carrotStick;
    public static Item potatoStick;
    public static Item kakiageSeed;
    public static Item kakiage;
    public static Item kakiageSoba;
    public static Item mushroomTen;
    public static Item kinoTenSoba;
    //Sweets
    public static Item karintoDough;
    public static Item sobaKarinto;
    public static Item sobaCookie;
    //BlockCrops
    public static Block Buckwheat;
    public static Block GreenOnion;
    public static Block Yam;
    public static Block Wasabi;
    public static Block Soy;

    //BlockTool
    public static Block blockIshiusu;
    public static final int guiIDIshiusu = 0;

    //Nishin
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

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ModInfo.loadInfo(meta);

    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

    	GameRegistry.registerTileEntity(TileEntityIshiusu.class, "Ishiusu");

    	//
    	isiusu = new Item()
    	.setCreativeTab(this.tabNoodles)
    	.setUnlocalizedName("ishiusu")
    	.setTextureName("noodlesmod:isiusu")
    	.setMaxStackSize(1);
    	GameRegistry.registerItem(isiusu, "isiusu");

    	konebati = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("konebachi")
        .setTextureName("noodlesmod:konebati")
        .setMaxStackSize(1);
        GameRegistry.registerItem(konebati, "konebati");

        nosiita = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("noshiita")
        .setTextureName("noodlesmod:nosiita")
        .setMaxStackSize(1);
        GameRegistry.registerItem(nosiita, "nosiita");

        mennbo = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("menbo")
        .setTextureName("noodlesmod:mennbo");
        GameRegistry.registerItem(mennbo, "mennbo");

        manaita = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("manaita")
        .setTextureName("noodlesmod:manaita")
        .setMaxStackSize(1);
        GameRegistry.registerItem(manaita, "manaita");

        menHotyo = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("menkirihocho")
        .setTextureName("noodlesmod:men_hotyo")
        .setMaxStackSize(1);
        GameRegistry.registerItem(menHotyo, "menHotyo");

        komaita = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("komaita")
        .setTextureName("noodlesmod:komaita")
        .setMaxStackSize(1);
        GameRegistry.registerItem(komaita, "komaita");

        sukuizaru = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("sukuizaru")
        .setTextureName("noodlesmod:sukuizaru");
        GameRegistry.registerItem(sukuizaru, "sukuizaru");

        yudenabe = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("yudenabe")
        .setTextureName("noodlesmod:yudenabe");
        GameRegistry.registerItem(yudenabe, "yudenabe");

        mizuYudenabe = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("mizuiriyudenabe")
        .setTextureName("noodlesmod:mizuiriyudenabe")
        .setMaxStackSize(1);
        GameRegistry.registerItem(mizuYudenabe, "mizuiriyudenabe");

        boilMizuYude = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("boilMizuYude")
        .setTextureName("noodlesmod:boil_mizu_yude")
        .setMaxStackSize(1);
        GameRegistry.registerItem(boilMizuYude, "boilMizuYude");

        grater = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("grater")
        .setTextureName("noodlesmod:grater")
        .setMaxStackSize(1);
        GameRegistry.registerItem(grater, "grater");

        oilThrower = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("oilThrower")
        .setTextureName("noodlesmod:oil_thrower")
        .setMaxStackSize(1);
        GameRegistry.registerItem(oilThrower, "oilThrower");

        gridiron = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("gridiron")
        .setTextureName("noodlesmod:gridiron");
        GameRegistry.registerItem(gridiron, "gridiron");

        camas = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("camas")
        .setTextureName("noodlesmod:camas");
        GameRegistry.registerItem(camas, "camas");

        hotyo = new ItemSword(Item.ToolMaterial.STONE)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("hotyo")
        .setTextureName("noodlesmod:hotyo")
        .setMaxStackSize(1);
        GameRegistry.registerItem(hotyo, "hotyo");


        yuto = new Item()
        .setCreativeTab(tabNoodles)
        .setUnlocalizedName("yuto")
        .setTextureName("noodlesmod:yuto")
        .setMaxStackSize(1);
        GameRegistry.registerItem(yuto, "yuto");

        sobaYudenabe = new Item()
        .setCreativeTab(tabNoodles)
        .setUnlocalizedName("sobaYudenabe")
        .setTextureName("noodlesmod:soba_yudenabe")
        .setContainerItem(yudenabe)
        .setMaxStackSize(1);
        GameRegistry.registerItem(sobaYudenabe, "sobaYudenabe");

        sobayuYuto = new Item()
        .setCreativeTab(tabNoodles)
        .setUnlocalizedName("sobayuYuto")
        .setTextureName("noodlesmod:sobayu_yuto")
        .setContainerItem(yuto)
        .setMaxStackSize(1);
        GameRegistry.registerItem(sobayuYuto, "sobayuYuto");
        //
        seiroWaku = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("seiroWaku")
        .setTextureName("noodlesmod:seiro_waku");
        GameRegistry.registerItem(seiroWaku, " seiroWaku");

        seiroSudare = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("seiroSudare")
        .setTextureName("noodlesmod:seiro_sudare");
        GameRegistry.registerItem(seiroSudare,  "seiroSudare");

        seiro = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("seiro")
        .setTextureName("noodlesmod:seiro");
        GameRegistry.registerItem(seiro, "seiro");

        clayPlate = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("tsuchiZara")
        .setTextureName("noodlesmod:tuti_zara")
        .setMaxStackSize(1);
        GameRegistry.registerItem(clayPlate, "clayPlate");

        plate = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("sara")
        .setTextureName("noodlesmod:sara");
        GameRegistry.registerItem(plate, "plate");

        clayOwan = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("tuchiOwan")
        .setTextureName("noodlesmod:tuchi_owan")
        .setMaxStackSize(1);
        GameRegistry.registerItem(clayOwan, "tuchiOwan");

        owan = new Item()
        .setCreativeTab(tabNoodles)
        .setUnlocalizedName("owan")
        .setTextureName("noodlesmod:owan");
        GameRegistry.registerItem(owan, "owan");

        //
        Buckwheat = new Buckwheat()
        .setBlockName("Buckwheast");
        GameRegistry.registerBlock(Buckwheat, "buckwheat");

        sobanomi = new ItemSeeds(this.Buckwheat, Blocks.farmland)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("sobanomi")
        .setTextureName("noodlesmod:sobanomi");
        GameRegistry.registerItem(sobanomi, "sobanomi");

        MinecraftForge.addGrassSeed(new ItemStack(this.sobanomi), 3);

        sobako = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("sobako")
        .setTextureName("noodlesmod:sobako");
        GameRegistry.registerItem(sobako, "sobako");

        flour = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("komugiko")
        .setTextureName("noodlesmod:komugiko");
        GameRegistry.registerItem(flour, "flour");

        dou = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("dou")
        .setTextureName("noodlesmod:dou")
        .setMaxStackSize(16);
        GameRegistry.registerItem(dou, "dou");

        sobaDough = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kiji")
        .setTextureName("noodlesmod:kizi");
        GameRegistry.registerItem(sobaDough, "sobaDough");

        tatanndakizi = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("tatandakiji")
        .setTextureName("noodlesmod:tatanndakizi")
        .setMaxStackSize(16);
        GameRegistry.registerItem(tatanndakizi, "tatanndakizi");

        kittakizi = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kittakiji")
        .setTextureName("noodlesmod:kittakizi");
        GameRegistry.registerItem(kittakizi, "kittakizi");

        yudetasoba = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("yudetasoba")
        .setTextureName("noodlesmod:yudetasoba");
        GameRegistry.registerItem(yudetasoba, "yudetasoba");

        soba = new ItemSoba(5)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("soba")
        .setTextureName("noodlesmod:soba")
        .setMaxStackSize(1);
        GameRegistry.registerItem(soba, "soba");

        syouyu = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("shouyu")
        .setTextureName("noodlesmod:syouyu")
        .setContainerItem(Items.glass_bottle)
        .setMaxStackSize(1);
        GameRegistry.registerItem(syouyu, "syouyu");

        kaesi = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kaeshi")
        .setTextureName("noodlesmod:kaesi")
        .setMaxStackSize(1);
        GameRegistry.registerItem(kaesi, "kaesi");

        dasi = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("dashi")
        .setTextureName("noodlesmod:dasi")
        .setContainerItem(Items.glass_bottle)
        .setMaxStackSize(1);
        GameRegistry.registerItem(dasi, "dasi");

        tuyu = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("tuyu")
        .setTextureName("noodlesmod:tuyu")
        .setMaxStackSize(1)
        .setContainerItem(Items.glass_bottle);
        GameRegistry.registerItem(tuyu, "tuyu");

        originTyoko = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("sobachokonomoto")
        .setTextureName("noodlesmod:origin_tyoko")
        .setMaxStackSize(1);
        GameRegistry.registerItem(originTyoko, "sobatyokonomoto");

        sobatyoko = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("sobachoko")
        .setTextureName("noodlesmod:sobatyoko");
        GameRegistry.registerItem(sobatyoko, "sobatyoko");

        sobatuyu = new ItemTuyu(3)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("sobatsuyu")
        .setTextureName("noodlesmod:sobatuyu");
        GameRegistry.registerItem(sobatuyu, "sobatuyu");

        seirosoba = new ItemSeiro(8)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("seirosoba")
        .setTextureName("noodlesmod:seirosoba");
        GameRegistry.registerItem(seirosoba, "seirosoba");

        seiroset = new Item()
        .setUnlocalizedName("seiroset")
        .setTextureName("noodlesmod:seiroset")
        .setMaxStackSize(1)
        .setContainerItem(this.seiro);
        GameRegistry.registerItem(seiroset, "seiroset");

        yakisobaMenn = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("yakisobamen")
        .setTextureName("noodlesmod:yakisoba_menn")
        .setMaxStackSize(1);
        GameRegistry.registerItem(yakisobaMenn, "yakisobaMenn");

        yakisoba =new ItemPlate(8)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("yakisoba")
        .setTextureName("noodlesmod:yakisoba");
        GameRegistry.registerItem(yakisoba, "yakisoba");

        remainingTuyu = new Item()
        .setCreativeTab(tabNoodles)
        .setUnlocalizedName("remainingTuyu")
        .setTextureName("noodlesmod:remaining_tuyu")
        .setMaxStackSize(1);
        GameRegistry.registerItem(remainingTuyu, "remainingTuyu");

        sobayuTuyu = new ItemTuyu(5)
        .setCreativeTab(tabNoodles)
        .setUnlocalizedName("sobayuTuyu")
        .setTextureName("noodlesmod:sobayu_tuyu");
        GameRegistry.registerItem(sobayuTuyu, "sobayuTuyu");


        shrimp = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("ebi")
        .setTextureName("noodlesmod:shrimp");
        GameRegistry.registerItem(shrimp, "ebi");

        koromo = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("koromo")
        .setTextureName("noodlesmod:koromo");
        GameRegistry.registerItem(koromo, "koromo");

        pot = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("nabe")
        .setTextureName("noodlesmod:nabe");
        GameRegistry.registerItem(pot, "nabe");

        oilPot = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("aburanabe")
        .setTextureName("noodlesmod:aburanabe")
        .setContainerItem(this.pot);
        GameRegistry.registerItem(oilPot, "aburanabe");

        boilOilPot = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("boilOilPot")
        .setTextureName("noodlesmod:boil_oil_pot")
        .setContainerItem(pot)
        .setMaxStackSize(1);
        GameRegistry.registerItem(boilOilPot, "boilOilPot");

        rapeseedOil = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("nataneabura")
        .setContainerItem(Items.glass_bottle)
        .setTextureName("noodlesmod:nataneabura");
        GameRegistry.registerItem(rapeseedOil, "nataneabura");

        koromoShrimp = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("koromotukiebi")
        .setTextureName("noodlesmod:koromo_ebi");
        GameRegistry.registerItem(koromoShrimp, "koromotukiebi");

        tenpura = new ItemFood(3, 5.0F, false)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("tenpura")
        .setTextureName("noodlesmod:tenpura");
        GameRegistry.registerItem(tenpura, "tenpura");

        ebitensoba = new ItemOwan(8)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("ebitensoba")
        .setTextureName("noodlesmod:ebitensoba");
        GameRegistry.registerItem(ebitensoba, "ebitensoba");

        GreenOnion = new GreenOnion()
        .setBlockName("GreenOnion");
        GameRegistry.registerBlock(GreenOnion, "GreenOnion");

        Yam = new Yam()
        .setBlockName("Yam");
        GameRegistry.registerBlock(Yam, "Yam");

        Wasabi = new Wasabi()
        .setBlockName("Wasabi");
        GameRegistry.registerBlock(Wasabi, "Wasabi");

        greenOnion = new ItemSeeds(this.GreenOnion, Blocks.farmland)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("greenOnion")
        .setTextureName("noodlesmod:green_onion");
        GameRegistry.registerItem(greenOnion, "greenOnion");

        chopGreOni = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("chopGreenOnion")
        .setTextureName("noodlesmod:chop_greoni");
        GameRegistry.registerItem(chopGreOni, "chopGreOni");

        yam = new ItemSeeds(this.Yam, Blocks.farmland)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("yam")
        .setTextureName("noodlesmod:yam");
        GameRegistry.registerItem(yam, "yam");

        gratedYam = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("gratedYam")
        .setTextureName("noodlesmod:grated_yam");
        GameRegistry.registerItem(gratedYam, "gratedYam");

        wasabi = new ItemSeeds(this.Wasabi, Blocks.farmland)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("wasabi")
        .setTextureName("noodlesmod:wasabi");
        GameRegistry.registerItem(wasabi, "wasabi");

        gratedWasabi = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("gratedWasabi")
        .setTextureName("noodlesmod:grated_wasabi");
        GameRegistry.registerItem(gratedWasabi, "gratedWasabi");

        tororoSoba = new ItemOwan(8)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("tororoSoba")
        .setTextureName("noodlesmod:tororo_soba");
        GameRegistry.registerItem(tororoSoba, "tororoSoba");

        MinecraftForge.addGrassSeed(new ItemStack(this.greenOnion), 1);
        MinecraftForge.addGrassSeed(new ItemStack(this.yam), 1);
        MinecraftForge.addGrassSeed(new ItemStack(this.wasabi), 1);

        tenkasu = new ItemFood(2, 0, true)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("tenkasu")
        .setTextureName("noodlesmod:tenkasu");
        GameRegistry.registerItem(tenkasu, "tenkasu");

        tanukiSoba = new ItemOwan(8)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("tanukiSoba")
        .setTextureName("noodlesmod:tanuki_soba");
        GameRegistry.registerItem(tanukiSoba, "tanukiSoba");

        salt = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("salt")
        .setTextureName("noodlesmod:salt");
        GameRegistry.registerItem(salt, "salt");

        camasSalt= new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("camasSalt")
        .setTextureName("noodlesmod:camas_salt");
        GameRegistry.registerItem(camasSalt, "camasSalt");

        bittern = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("bittern")
        .setTextureName("noodlesmod:bittern")
        .setContainerItem(Items.bucket);
        GameRegistry.registerItem(bittern, "bittern");

        camasAmajio = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("camasAmajio")
        .setTextureName("noodlesmod:camas_amajio")
        .setContainerItem(this.camas);
        GameRegistry.registerItem(camasAmajio, "camasAmajio");

        amajio = new ItemFood(2, 1.0F, false)
        .setPotionEffect(1, 30, 1, 90.0F)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("amajio")
        .setTextureName("noodlesmod:amajio");
        GameRegistry.registerItem(amajio, "amajio");

        Soy = new Soy()
        .setBlockName("Soy");
        GameRegistry.registerBlock(Soy, "Soy");

        soyBean = new ItemSeeds(this.Soy, Blocks.farmland)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("soyBean")
        .setTextureName("noodlesmod:soy_bean");
        GameRegistry.registerItem(soyBean, "soyBean");

        MinecraftForge.addGrassSeed(new ItemStack(this.soyBean), 1);

        soyMilk = new ItemSoy(5)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("soyMilk")
        .setTextureName("noodlesmod:soy_milk")
        .setContainerItem(Items.glass_bottle);
        GameRegistry.registerItem(soyMilk, "soyMilk");

        tofu = new ItemFood(6, 2.0F, false)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("tofu")
        .setTextureName("noodlesmod:tofu");
        GameRegistry.registerItem(tofu, "tofu");

        chopTofu = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("chopTofu")
        .setTextureName("noodlesmod:chop_tofu");
        GameRegistry.registerItem(chopTofu, "chopTofu");

        friedTofu = new ItemFood(6, 4.0F, false)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("friedTofu")
        .setTextureName("noodlesmod:fried_tofu");
        GameRegistry.registerItem(friedTofu, "friedTofu");

        kitsuneSoba = new ItemOwan(8)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kitsuneSoba")
        .setTextureName("noodlesmod:kitsune_soba");
        GameRegistry.registerItem(kitsuneSoba, "kitsuneSoba");

        wankoSobaOwan = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("wankoSobaOwan")
        .setTextureName("noodlesmod:wanko_owan");
        GameRegistry.registerItem(wankoSobaOwan, "wankoSobaOwan");

        wankoOwanTuyu = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("wankoOwanTuyu")
        .setTextureName("noodlesmod:wanko_tuyu");
        GameRegistry.registerItem(wankoOwanTuyu, "wankoOwanTuyu");

        wankoSoba = new ItemWanko(2)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("wankoSoba")
        .setTextureName("noodlesmod:wanko_soba")
        .setContainerItem(this.wankoOwanTuyu);
        GameRegistry.registerItem(wankoSoba, "wankoSoba");

        carrotStick = new ItemFood(1, 0.5F, true)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("carrotStick")
        .setTextureName("noodlesmod:carrot_stick");
        GameRegistry.registerItem(carrotStick, "carrotStick");

        potatoStick = new ItemFood(1, 0.5F, true)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("potatoStick")
        .setTextureName("noodlesmod:potato_stick");
        GameRegistry.registerItem(potatoStick, "potatoStick");

        kakiageSeed = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kakiageSeed")
        .setTextureName("noodlesmod:kakiage_seed");
        GameRegistry.registerItem(kakiageSeed, "kakiageSeed");

        kakiage = new ItemFood(4, 2.0F, false)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kakiage")
        .setTextureName("noodlesmod:kakiage");
        GameRegistry.registerItem(kakiage, "kakiage");

        kakiageSoba = new ItemOwan(8)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kakiageSoba")
        .setTextureName("noodlesmod:kakiage_soba");
        GameRegistry.registerItem(kakiageSoba, "kakiageSoba");

        mushroomTen = new ItemFood(3, 1.0F, false)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("mushroomTen")
        .setTextureName("noodlesmod:mushroom_ten");
        GameRegistry.registerItem(mushroomTen, "mushroomTen");

        kinoTenSoba = new ItemOwan(8)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kinoTenSoba")
        .setTextureName("noodlesmod:kino_ten_soba");
        GameRegistry.registerItem(kinoTenSoba, "kinoTenSoba");

        karintoDough = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("karintoDough")
        .setTextureName("noodlesmod:karinto_dough");
        GameRegistry.registerItem(karintoDough, "karintoDough");

        sobaKarinto = new ItemFood(10, 0.5F, false)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("sobaKarinto")
        .setTextureName("noodlesmod:soba_karinto");
        GameRegistry.registerItem(sobaKarinto, "sobaKarinto");

        sobaCookie = new ItemFood(2, 0.5F, true)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("sobaCookie")
        .setTextureName("noodlesmod:soba_cookie");
        GameRegistry.registerItem(sobaCookie, "sobaCookie");

        blower = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("blower")
        .setTextureName("noodlesmod:blower")
        .setMaxStackSize(1);
        GameRegistry.registerItem(blower, "blower");

        herring = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("herring")
        .setTextureName("noodlesmod:herring");
        GameRegistry.registerItem(herring, "herring");

        driedHerring = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("driedHerring")
        .setTextureName("noodlesmod:dried_herring");
        GameRegistry.registerItem(driedHerring, "driedHerring");

        pieceHerring = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("pieceHerring")
        .setTextureName("noodlesmod:piece_herring");
        GameRegistry.registerItem(pieceHerring, "pieceHerring");

        herringRoe = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("herringRoe")
        .setTextureName("noodlesmod:herring_roe");
        GameRegistry.registerItem(herringRoe, "herringRoe");

        Kazunoko = new ItemFood(3, 0.5F, false)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("Kazunoko")
        .setTextureName("noodlesmod:Kazunoko");
        GameRegistry.registerItem(Kazunoko, "Kazunoko");

        driedPieceHerring = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("driedPieceHerring")
        .setTextureName("noodlesmod:dried_piece_herring");
        GameRegistry.registerItem(driedPieceHerring, "driedPieceHerring");

        Migakinishin = new ItemFood(5, 1.0F, false)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("Migakinishin")
        .setTextureName("noodlesmod:Migakinishin");
        GameRegistry.registerItem(Migakinishin, "Migakinishin");

        kanro = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kanro")
        .setTextureName("noodlesmod:kanro")
        .setContainerItem(Items.glass_bottle)
        .setMaxStackSize(1);
        GameRegistry.registerItem(kanro, "kanro");

        kanroPot = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("kanroPot")
        .setTextureName("noodlesmod:kanro_pot")
        .setMaxStackSize(1);
        GameRegistry.registerItem(kanroPot, "kanroPot");

        boilKanroPot = new Item()
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("boilKanroPot")
        .setTextureName("noodlesmod:boil_kanro_pot")
        .setContainerItem(pot)
        .setMaxStackSize(1);
        GameRegistry.registerItem(boilKanroPot, "boilKanroPot");

        NishinKanroni = new ItemFood(6, 1.5F, false)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("NishinKanroni")
        .setTextureName("noodlesmod:nishin_kanroni");
        GameRegistry.registerItem(NishinKanroni, "NishinKanroni");

        NishinSoba = new ItemOwan(8)
        .setCreativeTab(this.tabNoodles)
        .setUnlocalizedName("NishinSoba")
        .setTextureName("noodlesmod:nishin_soba");
        GameRegistry.registerItem(NishinSoba, "NishinSoba");

        /*
         *
         * Ishiusu
         *
         */


        blockIshiusu = new Ishiusu(Material.rock)
        		.setBlockName("Ishiusu")
        		.setCreativeTab(this.tabNoodles);
        GameRegistry.registerBlock(blockIshiusu, "blockIshiusu");


        isiusu.setContainerItem(isiusu);
        konebati.setContainerItem(konebati);
        nosiita.setContainerItem(nosiita);
        mennbo.setContainerItem(mennbo);
        manaita.setContainerItem(manaita);
        menHotyo.setContainerItem(menHotyo);
        komaita.setContainerItem(komaita);
        sukuizaru.setContainerItem(sukuizaru);
        grater.setContainerItem(grater);
        oilThrower.setContainerItem(oilThrower);
        gridiron.setContainerItem(gridiron);
        hotyo.setContainerItem(hotyo);
        camasSalt.setContainerItem(camasAmajio);
        blower.setContainerItem(blower);
        driedHerring.setContainerItem(herringRoe);
        boilMizuYude.setContainerItem(sobaYudenabe);

        FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(this.shrimp, 1), 55));
        FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(this.herring, 20), 100));

        OreDictionary.registerOre("cropBuckwheat", this.sobanomi);
        OreDictionary.registerOre("cropGreenOnion", this.greenOnion);
        OreDictionary.registerOre("cropYam", this.yam);
        OreDictionary.registerOre("cropWasabi", this.wasabi);
        OreDictionary.registerOre("cropSoy", this.soyBean);
        OreDictionary.registerOre("dustFlour", this.flour);


        //
        GameRegistry.addRecipe(new ItemStack(this.isiusu),
        		"ST",
        		"S ",
        		'S', Blocks.stone,
        		'T', Items.stick
        );

        GameRegistry.addRecipe(new ItemStack(this.konebati),
        		"  S",
        		"BSB",
        		" B ",
        		'S', Items.stick,
        		'B', Items.bowl
        );

        GameRegistry.addRecipe(new ItemStack(this.nosiita),
        		"WWW",
        		"WWW",
        		"WWW",
        		'W', Blocks.wooden_slab
        );

        GameRegistry.addRecipe(new ItemStack(this.mennbo),
        		"SSS",
        		'S', Items.stick
        );

        GameRegistry.addRecipe(new ItemStack(this.manaita),
        		"WWW",
        		'W', Blocks.wooden_slab
        );

        GameRegistry.addRecipe(new ItemStack(this.menHotyo),
        		"IIS",
        		"III",
        		'I', Items.iron_ingot,
        		'S', Items.stick
        );

        GameRegistry.addRecipe(new ItemStack(this.komaita),
        		"P  ",
        		"WWW",
        		'P', Blocks.planks,
        		'W', Blocks.wooden_slab
        );

        GameRegistry.addRecipe(new ItemStack(this.sukuizaru),
        		"BBI",
        		"BB ",
        		'B', Blocks.iron_bars,
        		'I', Items.iron_ingot
        );

        GameRegistry.addRecipe(new ItemStack(this.yudenabe),
        		"I I",
        		"BBB",
        		'I', Items.iron_ingot,
        		'B', Blocks.iron_block
        );

        GameRegistry.addRecipe(new ItemStack(this.mizuYudenabe),
        		"W",
        		"Y",
        		'W', Items.water_bucket,
        		'Y', this.yudenabe
        );

        GameRegistry.addSmelting(mizuYudenabe, new ItemStack(this.boilMizuYude), 0.5F);

        GameRegistry.addRecipe(new ItemStack(this.grater),
        		"  I",
        		"II ",
        		" I ",
        		'I', Items.iron_ingot
        );

        GameRegistry.addRecipe(new ItemStack(this.oilThrower),
        		"III",
        		"BB ",
        		'I', Items.iron_ingot,
        		'B', Blocks.iron_bars
        );

        GameRegistry.addRecipe(new ItemStack(this.gridiron),
        		"P P",
        		"PSP",
        		"P P",
        		'P', Blocks.planks,
        		'S', Items.stick
        );

        GameRegistry.addRecipe(new ItemStack(this.camas),
        		"S S",
        		"S S",
        		" S ",
        		'S',
        		 Items.string
        );

        GameRegistry.addRecipe(new ItemStack(this.hotyo),
        		"IIS",
        		"II ",
        		'I', Items.iron_ingot,
        		'S', Items.stick
        );

        GameRegistry.addRecipe(new ItemStack(this.yuto),
        		" B ",
        		"RPR",
        		'B', Items.dye,
        		'R', new ItemStack(Items.dye, 1, 1),
        		'P', Blocks.planks
        );

        GameRegistry.addRecipe(new ItemStack(this.sobayuYuto),
        		"S",
        		"Y",
        		'S', this.sobaYudenabe,
        		'Y', this.yuto
        );


        //
        GameRegistry.addRecipe(new ItemStack(this.seiroWaku),
        		"P P",
        		"PBP",
        		"RPR",
        		'P', Blocks.planks,
        		'B', Items.dye,
        		'R', new ItemStack(Items.dye, 1, 1)
        );

        GameRegistry.addRecipe(new ItemStack(this.seiroSudare),
        		"S S",
        		" T ",
        		"S S",
        		'S', Items.stick,
        		'T', Items.string
        );

        GameRegistry.addRecipe(new ItemStack(this.seiro),
        		"S",
        		"W",
        		'S', this.seiroSudare,
        		'W', this.seiroWaku
        );

        GameRegistry.addRecipe(new ItemStack(this.clayPlate),
        		"C C",
        		" C ",
        		'C', Items.clay_ball
        );

        GameRegistry.addSmelting(this.clayPlate, new ItemStack(this.plate), 0.3F);

        GameRegistry.addRecipe(new ItemStack(this.clayOwan),
        		"C C",
        		"C C",
        		" C ",
        		'C', Items.clay_ball
        );

        GameRegistry.addSmelting(this.clayOwan, new ItemStack(this.owan), 0.3F);

        //
        GameRegistry.addRecipe(new ItemStack(this.sobako, 6),
        		"SSS",
        		"SSS",
        		" I ",
        		'S', this.sobanomi,
        		'I', this.isiusu
        );

        GameRegistry.addRecipe(new ItemStack(this.flour, 6),
        		"WWW",
        		"WWW",
        		" I ",
        		'W', Items.wheat,
        		'I', this.isiusu
        );

        GameRegistry.addRecipe(new ItemStack(this.dou),
        		"SSS",
        		" KW",
        		" N ",
        		'S', this.sobako,
        		'K', this.flour,
        		'W', Items.water_bucket,
        		'N', this.konebati
        );

        GameRegistry.addRecipe(new ItemStack(this.sobaDough),
        		"M",
        		"D",
        		"N",
        		'M', this.mennbo,
        		'D', this.dou,
        		'N', this.nosiita
        );

        GameRegistry.addRecipe(new ItemStack(this.tatanndakizi),
        		"   ",
        		"   ",
        		"K  ",
        		'K', this.sobaDough
        );

        GameRegistry.addRecipe(new ItemStack(this.kittakizi, 4),
        		"H ",
        		"TK",
        		"M ",
        		'H', this.menHotyo,
        		'T', this.tatanndakizi,
        		'K', this.komaita,
        		'M', this.manaita
        );

        GameRegistry.addRecipe(new ItemStack(this.yudetasoba),
        		"S",
        		"K",
        		"M",
        		'S', this.sukuizaru,
        		'K', this.kittakizi,
        		'M', this.boilMizuYude
        );

        GameRegistry.addRecipe(new ItemStack(this.soba),
        		"Y",
        		"S",
        		'Y', this.yudetasoba,
        		'S', this.seiro
        );

        GameRegistry.addRecipe(new ItemStack(this.syouyu),
        		"SWB",
        		" G ",
        		'S', this.soyBean,
        		'W', Items.wheat,
        		'B', Items.water_bucket,
        		'G', Items.glass_bottle
        );

        GameRegistry.addShapelessRecipe(new ItemStack(this.kaesi),
        		this.syouyu,
        		Items.sugar
        );

        GameRegistry.addRecipe(new ItemStack(this.dasi, 3),
        		" F ",
        		" W ",
        		"GGG",
        		'F', new ItemStack(Items.cooked_fished, 1, 0),
        		'W', Items.water_bucket,
        		'G', Items.glass_bottle
        );

        GameRegistry.addRecipe(new ItemStack(this.tuyu),
        		"DDD",
        		" K ",
        		" G ",
        		'D', this.dasi,
        		'K', this.kaesi,
        		'G', Items.glass_bottle
        );

        GameRegistry.addRecipe(new ItemStack(this.originTyoko),
        		"C C",
        		"Q Q",
        		"CSC",
        		'C', Items.clay_ball,
        		'Q', Items.quartz,
        		'S', Blocks.stone
        );

        GameRegistry.addSmelting(this.originTyoko, new ItemStack(this.sobatyoko), 1.5F);

        GameRegistry.addRecipe(new ItemStack(this.sobatuyu),
        		"T",
        		"S",
        		'T', this.tuyu,
        		'S', this.sobatyoko
        );

        GameRegistry.addShapelessRecipe(new ItemStack(this.seirosoba),
        		this.soba,
        		this.sobatuyu
        );

        GameRegistry.addShapelessRecipe(new ItemStack(this.remainingTuyu),
        		this.seiroset
        );

        GameRegistry.addRecipe(new ItemStack(this.yakisobaMenn),
        		"S",
        		"Y",
        		"R",
        		'S', this.syouyu,
        		'Y', this.yudetasoba,
        		'R', this.plate
        );

        GameRegistry.addSmelting(this.yakisobaMenn, new ItemStack(this.yakisoba), 1.0f);


        GameRegistry.addRecipe(new ItemStack(this.sobayuTuyu),
        		"Y",
        		"T",
        		'Y', this.sobayuYuto,
        		'T', this.remainingTuyu
        );


        GameRegistry.addShapelessRecipe(new ItemStack(this.koromo,4),
        		this.flour,
        		Items.egg,
        		Items.water_bucket
        );

        GameRegistry.addRecipe(new ItemStack(this.pot),
        		"I I",
        		"IBI",
        		'I', Items.iron_ingot,
        		'B', Blocks.iron_block
        );

        GameRegistry.addRecipe(new ItemStack(this.oilPot),
        		"O",
        		"O",
        		"T",
        		'O', this.rapeseedOil,
        		'T', this.pot
        );

        GameRegistry.addSmelting(oilPot, new ItemStack(this.boilOilPot), 0.5F);

        GameRegistry.addRecipe(new ItemStack(this.rapeseedOil),
        		"S",
        		"S",
        		"B",
        		'S', Items.wheat_seeds,
        		'B', Items.glass_bottle
        );

        GameRegistry.addRecipe(new ItemStack(this.koromoShrimp),
        		" K ",
        		"KSK",
        		" K ",
        		'K', this.koromo,
        		'S', this.shrimp
        );

        GameRegistry.addRecipe(new ItemStack(this.tenpura),
        		"O",
        		"E",
        		"T",
        		'S', this.oilThrower,
        		'E', this.koromoShrimp,
        		'T', this.boilOilPot
        );

        GameRegistry.addRecipe(new ItemStack(this.ebitensoba),
        		"TC",
        		"SD",
        		"O ",
        		'T', this.tenpura,
        		'C', this.chopGreOni,
        		'D', this.tuyu,
        		'S', this.yudetasoba,
        		'O', this.owan
        );

        GameRegistry.addRecipe(new ItemStack(this.chopGreOni, 3),
        		"H",
        		"G",
        		"M",
        		'H', this.hotyo,
        		'G', this.greenOnion,
        		'M', this.manaita
        );

        GameRegistry.addShapelessRecipe(new ItemStack(this.gratedYam),
        		this.grater,
        		this.yam
        );

        GameRegistry.addShapelessRecipe(new ItemStack(this.gratedWasabi),
        		this.grater,
        		this.wasabi
        );

        GameRegistry.addRecipe(new ItemStack(this.tororoSoba),
        		"WEC",
        		" YT",
        		" OS",
        		'W', this.gratedWasabi,
        		'E', Items.egg,
        		'C', this.chopGreOni,
        		'Y', this.gratedYam,
        		'T', this.tuyu,
        		'O', this.owan,
        		'S', this.yudetasoba
        );

        GameRegistry.addRecipe(new ItemStack(this.tenkasu),
        		"O",
        		"K",
        		"T",
        		'O', this.oilThrower,
        		'K', this.koromo,
        		'T', this.boilOilPot
        );

        GameRegistry.addRecipe(new ItemStack(this.tanukiSoba),
        		"KG",
        		"YT",
        		"O ",
        		'K', this.tenkasu,
        		'G', this.chopGreOni,
        		'Y', this.yudetasoba,
        		'T', this.tuyu,
        		'O', this.owan
        );

        GameRegistry.addShapelessRecipe(new ItemStack(this.salt, 3),
        		Items.water_bucket
        );

        GameRegistry.addRecipe(new ItemStack(this.camasSalt),
        		"S",
        		"C",
        		'S', this.salt,
        		'C', this.camas
        );

        GameRegistry.addRecipe(new ItemStack(this.bittern),
        		"C",
        		"G",
        		"B",
        		'C', this.camasSalt,
        		'G', this.gridiron,
        		'B', Items.bucket
        );

        GameRegistry.addShapelessRecipe(new ItemStack(this.amajio),
        		this.camasAmajio
        );

        GameRegistry.addRecipe(new ItemStack(this.soyMilk),
        		"W",
        		"S",
        		"B",
        		'W', Items.water_bucket,
        		'S', this.soyBean,
        		'B', Items.glass_bottle
        );

        GameRegistry.addRecipe(new ItemStack(this.tofu, 2),
        		"B",
        		"S",
        		'B', this.bittern,
        		'S', this.soyMilk
        );

        GameRegistry.addRecipe(new ItemStack(this.chopTofu, 2),
        		"H",
        		"T",
        		"M",
        		'H', this.hotyo,
        		'T', this.tofu,
        		'M', this.manaita
        );

        GameRegistry.addRecipe(new ItemStack(this.friedTofu),
        		"O",
        		"C",
        		"P",
        		'O', this.oilThrower,
        		'C', this.chopTofu,
        		'P', this.boilOilPot
        );

        GameRegistry.addRecipe(new ItemStack(this.kitsuneSoba),
        		"FC",
        		"YT",
        		"O ",
        		'F', this.friedTofu,
        		'C', this.chopGreOni,
        		'Y', this.yudetasoba,
        		'T', this.tuyu,
        		'O', this.owan
        );

        GameRegistry.addRecipe(new ItemStack(this.wankoSobaOwan),
        		"P P",
        		"PRP",
        		"BPB",
        		'P', Blocks.planks,
        		'R', new ItemStack(Items.dye, 1, 1),
        		'B', new ItemStack(Items.dye, 1, 0)
        );

        GameRegistry.addRecipe(new ItemStack(this.wankoOwanTuyu),
        		"T",
        		"O",
        		'T', this.tuyu,
        		'O', this.wankoSobaOwan
        );

        GameRegistry.addRecipe(new ItemStack(this.wankoSoba),
        		"Y",
        		"O",
        		'Y', this.yudetasoba,
        		'O', this.wankoOwanTuyu
        );

        GameRegistry.addRecipe(new ItemStack(this.carrotStick, 10),
        		"H",
        		"C",
        		"M",
        		'H', this.hotyo,
        		'C', Items.carrot,
        		'M', this.manaita
        );

        GameRegistry.addRecipe(new ItemStack(this.potatoStick, 10),
        		"H",
        		"P",
        		"M",
        		'H', this.hotyo,
        		'P', Items.potato,
        		'M', this.manaita
        );

        GameRegistry.addRecipe(new ItemStack(this.kakiageSeed, 2),
        		"PPP",
        		"CCC",
        		"KKK",
        		'P', this.potatoStick,
        		'C', this.carrotStick,
        		'K', this.koromo
        );

        GameRegistry.addRecipe(new ItemStack(this.kakiage),
        		"Y",
        		"S",
        		"N",
        		'Y', this.oilThrower,
        		'S', this.kakiageSeed,
        		'N', this.boilOilPot
        );

        GameRegistry.addRecipe(new ItemStack(this.kakiageSoba),
        		"KG",
        		"ST",
        		"O ",
        		'K', this.kakiage,
        		'G', this.chopGreOni,
        		'S', this.yudetasoba,
        		'T', this.tuyu,
        		'O', this.owan
        );

        GameRegistry.addRecipe(new ItemStack(this.mushroomTen),
        		"Y ",
        		"MK",
        		"N ",
        		'Y', this.oilThrower,
        		'M', Blocks.brown_mushroom,
        		'K', this.koromo,
        		'N', this.boilOilPot
        );

        GameRegistry.addRecipe(new ItemStack(this.kinoTenSoba),
        		"MG",
        		"ST",
        		"O ",
        		'M', this.mushroomTen,
        		'G', this.chopGreOni,
        		'S', this.yudetasoba,
        		'T', this.tuyu,
        		'O', this.owan
        );

        GameRegistry.addShapelessRecipe(new ItemStack(this.karintoDough, 2),
        		this.sobako,
        		Items.sugar,
        		Items.water_bucket,
        		this.salt
        );

        GameRegistry.addRecipe(new ItemStack(this.sobaKarinto),
        		"T",
        		"D",
        		"O",
        		'T', this.oilThrower,
        		'D', this.karintoDough,
        		'O', this.boilOilPot
        );

        GameRegistry.addRecipe(new ItemStack(this.sobaCookie, 8),
        		"SCS",
        		'S', this.sobako,
        		'C', new ItemStack(Items.dye, 1, 3)
        );

        //Nishin

        GameRegistry.addRecipe(new ItemStack(this.blower),
        		" I ",
        		"IBI",
        		" I ",
        		'I', Items.iron_ingot,
        		'B', Blocks.iron_block
        );

        GameRegistry.addRecipe(new ItemStack(this.driedHerring),
        		"HB",
        		'H', this.herring,
        		'B', this.blower
        );

        GameRegistry.addRecipe(new ItemStack(this.pieceHerring, 2),
        		"D",
        		"H",
        		'D', this.driedHerring,
        		'H', this.hotyo
        );

        GameRegistry.addRecipe(new ItemStack(this.Kazunoko),
        		"RB",
        		'R', this.herringRoe,
        		'B', this.blower
        );

        GameRegistry.addRecipe(new ItemStack(this.driedPieceHerring),
        		"PB",
        		'P', this.pieceHerring,
        		'B', this.blower
        );

        GameRegistry.addShapelessRecipe((new ItemStack(this.Migakinishin)),
        		this.driedPieceHerring
        );

        GameRegistry.addRecipe(new ItemStack(this.kanro),
        		"S",
        		"S",
        		"C",
        		'S', Items.sugar,
        		'C', this.syouyu
        );

        GameRegistry.addRecipe(new ItemStack(this.kanroPot),
        		"K",
        		"P",
        		'K', this.kanro,
        		'P', this.pot
        );

        GameRegistry.addSmelting(kanroPot, new ItemStack(this.boilKanroPot), 0.5F);

        GameRegistry.addRecipe(new ItemStack(this.NishinKanroni),
        		"M",
        		"K",
        		'M', this.Migakinishin,
        		'K', this.boilKanroPot
        );

        GameRegistry.addRecipe(new ItemStack(this.NishinSoba),
        		"NG",
        		"ST",
        		"O ",
        		'N', this.NishinKanroni,
        		'G', this.chopGreOni,
        		'S', this.yudetasoba,
        		'T', this.tuyu,
        		'O', this.owan
        );


    	getBuckwheat = new Achievement("achievement.getBuckwheat", "getBuckwheat", 0, 0, new ItemStack(sobanomi), (Achievement)null)
    			.initIndependentStat().registerStat();
    	getSoba = new Achievement("achievement.getSoba", "getSoba", 2, 2, new ItemStack(seirosoba), getBuckwheat)
    			.registerStat();
    	getYakisoba = new Achievement("achievement.getYakisoba", "getYakisoba", 5, 2, new ItemStack(yakisoba), getSoba)
    			.registerStat();
    	getDonmono = new Achievement("achievement.getDonmono", "getDonmono", 4, 0, new ItemStack(ebitensoba), getSoba)
    			.registerStat();
    	getEbi = new Achievement("achievement:getEbi", "getEbi", 0, 3, Items.fishing_rod, getSoba)
    			.registerStat();
    	getHerring = new Achievement("achievement:getHerring", "getHerring", 0, 4, new ItemStack(herring), getSoba)
    			.registerStat();
    	get64Ebi = new Achievement("achievement.get64Ebi", "get64Ebi", -2, 3, new ItemStack(shrimp), getEbi)
    			.setSpecial().registerStat();
    	getPlant = new Achievement("achievement.getPlant", "getPlant", 0, -2, new ItemStack(greenOnion), getBuckwheat)
    			.registerStat();
    	get64Plant = new Achievement("achievement.get64Plant", "get64Plant", 2, -4, new ItemStack(soyBean), getPlant)
    			.registerStat();
    	craftWanko = new Achievement("achievement.craftWanko", "craftWanko", 6, 0, new ItemStack(yudetasoba), getYakisoba)
    			.registerStat();
    	craft100Wanko = new Achievement("achievement.craft100Wanko", "craft100Wanko", 7, 2, new ItemStack(wankoSobaOwan), craftWanko)
    			.registerStat();
    	craft200Wanko = new Achievement("achievement.craft200Wanko", "craft200Wanko", 7, 4, new ItemStack(wankoOwanTuyu), craft100Wanko)
    			.setSpecial().registerStat();
    	craft500Wanko = new Achievement("achievement.craft500Wanko", "craft500Wanko", 9, 4, new ItemStack(wankoSoba), craft200Wanko)
    			.setSpecial().registerStat();
    	getTableware = new Achievement("achievement.getTableware", "getTableware", 3, 5, new ItemStack(seiro), getSoba)
    			.registerStat();

    	SobaPage = new AchievementPage("SobaMod Achievemnet", getBuckwheat, getSoba, getYakisoba, getDonmono, getEbi, getHerring, get64Ebi, getPlant, get64Plant,
    			craftWanko, craft100Wanko, craft200Wanko, craft500Wanko, getTableware);
    	AchievementPage.registerAchievementPage(SobaPage);
    }
}