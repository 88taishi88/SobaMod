package com.soba.sobamod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RegisterRecipe {

	/**レシピを登録するメゾット*/
	public static void register() {

		GameRegistry.addRecipe(new ItemStack(RegisterBlock.blockIshiusu),
				"ST",
				"S ",
				'S', Blocks.cobblestone,
				'T', Items.stick);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.konebati),
				"  S",
				"BSB",
				" B ",
				'S', Items.stick,
				'B', Items.bowl);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.nosiita),
				"WWW",
				"WWW",
				"WWW",
				'W', Blocks.wooden_slab);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.mennbo),
				"SSS",
				'S', Items.stick);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.manaita),
				"WWW",
				'W', Blocks.wooden_slab);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.menHotyo),
				"IIS",
				"III",
				'I', Items.iron_ingot,
				'S', Items.stick);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.komaita),
				"P  ",
				"WWW",
				'P', Blocks.planks,
				'W', Blocks.wooden_slab);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.sukuizaru),
				"BBI",
				"BB ",
				'B', Blocks.iron_bars,
				'I', Items.iron_ingot);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.yudenabe),
				"I I",
				"BBB",
				'I', Items.iron_ingot,
				'B', Blocks.iron_block);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.mizuYudenabe),
				"W",
				"Y",
				'W', Items.water_bucket,
				'Y', RegisterItem.yudenabe);

		GameRegistry.addSmelting(RegisterItem.mizuYudenabe, new ItemStack(RegisterItem.boilMizuYude), 0.5F);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.grater),
				"  I",
				"II ",
				" I ",
				'I', Items.iron_ingot);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.oilThrower),
				"III",
				"BB ",
				'I', Items.iron_ingot,
				'B', Blocks.iron_bars);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.gridiron),
				"P P",
				"PSP",
				"P P",
				'P', Blocks.planks,
				'S', Items.stick);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.camas),
				"S S",
				"S S",
				" S ",
				'S',
				Items.string);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.hotyo),
				"IIS",
				"II ",
				'I', Items.iron_ingot,
				'S', Items.stick);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.yuto),
				" B ",
				"RPR",
				'B', Items.dye,
				'R', new ItemStack(Items.dye, 1, 1),
				'P', Blocks.planks);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.sobayuYuto),
				"S",
				"Y",
				'S', RegisterItem.sobaYudenabe,
				'Y', RegisterItem.yuto);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.seiroWaku),
				"P P",
				"PBP",
				"RPR",
				'P', Blocks.planks,
				'B', Items.dye,
				'R', new ItemStack(Items.dye, 1, 1));

		GameRegistry.addRecipe(new ItemStack(RegisterItem.seiroSudare),
				"S S",
				" T ",
				"S S",
				'S', Items.stick,
				'T', Items.string);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.seiro),
				"S",
				"W",
				'S', RegisterItem.seiroSudare,
				'W', RegisterItem.seiroWaku);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.clayPlate),
				"C C",
				" C ",
				'C', Items.clay_ball);

		GameRegistry.addSmelting(RegisterItem.clayPlate, new ItemStack(RegisterItem.plate), 0.3F);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.clayOwan),
				"C C",
				"C C",
				" C ",
				'C', Items.clay_ball);

		GameRegistry.addSmelting(RegisterItem.clayOwan, new ItemStack(RegisterItem.owan), 0.3F);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.dou),
				"SSS",
				" KW",
				" N ",
				'S', RegisterItem.sobako,
				'K', RegisterItem.flour,
				'W', Items.water_bucket,
				'N', RegisterItem.konebati);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.sobaDough),
				"M",
				"D",
				"N",
				'M', RegisterItem.mennbo,
				'D', RegisterItem.dou,
				'N', RegisterItem.nosiita);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.tatanndakizi),
				"   ",
				"   ",
				"K  ",
				'K', RegisterItem.sobaDough);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.kittakizi, 4),
				"H ",
				"TK",
				"M ",
				'H', RegisterItem.menHotyo,
				'T', RegisterItem.tatanndakizi,
				'K', RegisterItem.komaita,
				'M', RegisterItem.manaita);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.yudetasoba),
				"S",
				"K",
				"M",
				'S', RegisterItem.sukuizaru,
				'K', RegisterItem.kittakizi,
				'M', RegisterItem.boilMizuYude);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.soba),
				"Y",
				"S",
				'Y', RegisterItem.yudetasoba,
				'S', RegisterItem.seiro);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.syouyu),
				"SWB",
				" G ",
				'S', RegisterItem.soyBean,
				'W', Items.wheat,
				'B', Items.water_bucket,
				'G', Items.glass_bottle);

		GameRegistry.addShapelessRecipe(new ItemStack(RegisterItem.kaesi),
				RegisterItem.syouyu,
				Items.sugar);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.dasi, 3),
				" F ",
				" W ",
				"GGG",
				'F', new ItemStack(Items.cooked_fished, 1, 0),
				'W', Items.water_bucket,
				'G', Items.glass_bottle);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.tuyu),
				"DDD",
				" K ",
				" G ",
				'D', RegisterItem.dasi,
				'K', RegisterItem.kaesi,
				'G', Items.glass_bottle);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.originTyoko),
				"C C",
				"Q Q",
				"CSC",
				'C', Items.clay_ball,
				'Q', Items.quartz,
				'S', Blocks.stone);

		GameRegistry.addSmelting(RegisterItem.originTyoko, new ItemStack(RegisterItem.sobatyoko), 1.5F);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.sobatuyu),
				"T",
				"S",
				'T', RegisterItem.tuyu,
				'S', RegisterItem.sobatyoko);

		GameRegistry.addShapelessRecipe(new ItemStack(RegisterItem.seirosoba),
				RegisterItem.soba,
				RegisterItem.sobatuyu);

		GameRegistry.addShapelessRecipe(new ItemStack(RegisterItem.remainingTuyu),
				RegisterItem.seiroset);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.yakisobaMenn),
				"S",
				"Y",
				"R",
				'S', RegisterItem.syouyu,
				'Y', RegisterItem.yudetasoba,
				'R', RegisterItem.plate);

		GameRegistry.addSmelting(RegisterItem.yakisobaMenn, new ItemStack(RegisterItem.yakisoba), 1.0f);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.sobayuTuyu),
				"Y",
				"T",
				'Y', RegisterItem.sobayuYuto,
				'T', RegisterItem.remainingTuyu);

		GameRegistry.addShapelessRecipe(new ItemStack(RegisterItem.koromo, 4),
				RegisterItem.flour,
				Items.egg,
				Items.water_bucket);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.pot),
				"I I",
				"IBI",
				'I', Items.iron_ingot,
				'B', Blocks.iron_block);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.oilPot),
				"O",
				"O",
				"T",
				'O', RegisterItem.rapeseedOil,
				'T', RegisterItem.pot);

		GameRegistry.addSmelting(RegisterItem.oilPot, new ItemStack(RegisterItem.boilOilPot), 0.5F);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.rapeseedOil),
				"S",
				"S",
				"B",
				'S', Items.wheat_seeds,
				'B', Items.glass_bottle);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.koromoShrimp),
				" K ",
				"KSK",
				" K ",
				'K', RegisterItem.koromo,
				'S', RegisterItem.shrimp);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.tenpura),
				"O",
				"E",
				"T",
				'S', RegisterItem.oilThrower,
				'E', RegisterItem.koromoShrimp,
				'T', RegisterItem.boilOilPot);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.ebitensoba),
				"TC",
				"SD",
				"O ",
				'T', RegisterItem.tenpura,
				'C', RegisterItem.chopGreOni,
				'D', RegisterItem.tuyu,
				'S', RegisterItem.yudetasoba,
				'O', RegisterItem.owan);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.chopGreOni, 3),
				"H",
				"G",
				"M",
				'H', RegisterItem.hotyo,
				'G', RegisterItem.greenOnion,
				'M', RegisterItem.manaita);

		GameRegistry.addShapelessRecipe(new ItemStack(RegisterItem.gratedYam),
				RegisterItem.grater,
				RegisterItem.yam);

		GameRegistry.addShapelessRecipe(new ItemStack(RegisterItem.gratedWasabi),
				RegisterItem.grater,
				RegisterItem.wasabi);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.tororoSoba),
				"WEC",
				" YT",
				" OS",
				'W', RegisterItem.gratedWasabi,
				'E', Items.egg,
				'C', RegisterItem.chopGreOni,
				'Y', RegisterItem.gratedYam,
				'T', RegisterItem.tuyu,
				'O', RegisterItem.owan,
				'S', RegisterItem.yudetasoba);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.tenkasu),
				"O",
				"K",
				"T",
				'O', RegisterItem.oilThrower,
				'K', RegisterItem.koromo,
				'T', RegisterItem.boilOilPot);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.tanukiSoba),
				"KG",
				"YT",
				"O ",
				'K', RegisterItem.tenkasu,
				'G', RegisterItem.chopGreOni,
				'Y', RegisterItem.yudetasoba,
				'T', RegisterItem.tuyu,
				'O', RegisterItem.owan);

		GameRegistry.addShapelessRecipe(new ItemStack(RegisterItem.salt, 3),
				Items.water_bucket);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.camasSalt),
				"S",
				"C",
				'S', RegisterItem.salt,
				'C', RegisterItem.camas);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.bittern),
				"C",
				"G",
				"B",
				'C', RegisterItem.camasSalt,
				'G', RegisterItem.gridiron,
				'B', Items.bucket);

		GameRegistry.addShapelessRecipe(new ItemStack(RegisterItem.amajio),
				RegisterItem.camasAmajio);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.soyMilk),
				"W",
				"S",
				"B",
				'W', Items.water_bucket,
				'S', RegisterItem.soyBean,
				'B', Items.glass_bottle);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.tofu, 2),
				"B",
				"S",
				'B', RegisterItem.bittern,
				'S', RegisterItem.soyMilk);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.chopTofu, 2),
				"H",
				"T",
				"M",
				'H', RegisterItem.hotyo,
				'T', RegisterItem.tofu,
				'M', RegisterItem.manaita);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.friedTofu),
				"O",
				"C",
				"P",
				'O', RegisterItem.oilThrower,
				'C', RegisterItem.chopTofu,
				'P', RegisterItem.boilOilPot);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.kitsuneSoba),
				"FC",
				"YT",
				"O ",
				'F', RegisterItem.friedTofu,
				'C', RegisterItem.chopGreOni,
				'Y', RegisterItem.yudetasoba,
				'T', RegisterItem.tuyu,
				'O', RegisterItem.owan);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.wankoSobaOwan),
				"P P",
				"PRP",
				"BPB",
				'P', Blocks.planks,
				'R', new ItemStack(Items.dye, 1, 1),
				'B', new ItemStack(Items.dye, 1, 0));

		GameRegistry.addRecipe(new ItemStack(RegisterItem.wankoOwanTuyu),
				"T",
				"O",
				'T', RegisterItem.tuyu,
				'O', RegisterItem.wankoSobaOwan);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.wankoSoba),
				"Y",
				"O",
				'Y', RegisterItem.yudetasoba,
				'O', RegisterItem.wankoOwanTuyu);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.carrotStick, 10),
				"H",
				"C",
				"M",
				'H', RegisterItem.hotyo,
				'C', Items.carrot,
				'M', RegisterItem.manaita);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.potatoStick, 10),
				"H",
				"P",
				"M",
				'H', RegisterItem.hotyo,
				'P', Items.potato,
				'M', RegisterItem.manaita);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.kakiageSeed, 2),
				"PPP",
				"CCC",
				"KKK",
				'P', RegisterItem.potatoStick,
				'C', RegisterItem.carrotStick,
				'K', RegisterItem.koromo);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.kakiage),
				"Y",
				"S",
				"N",
				'Y', RegisterItem.oilThrower,
				'S', RegisterItem.kakiageSeed,
				'N', RegisterItem.boilOilPot);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.kakiageSoba),
				"KG",
				"ST",
				"O ",
				'K', RegisterItem.kakiage,
				'G', RegisterItem.chopGreOni,
				'S', RegisterItem.yudetasoba,
				'T', RegisterItem.tuyu,
				'O', RegisterItem.owan);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.mushroomTen),
				"Y ",
				"MK",
				"N ",
				'Y', RegisterItem.oilThrower,
				'M', Blocks.brown_mushroom,
				'K', RegisterItem.koromo,
				'N', RegisterItem.boilOilPot);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.kinoTenSoba),
				"MG",
				"ST",
				"O ",
				'M', RegisterItem.mushroomTen,
				'G', RegisterItem.chopGreOni,
				'S', RegisterItem.yudetasoba,
				'T', RegisterItem.tuyu,
				'O', RegisterItem.owan);

		GameRegistry.addShapelessRecipe(new ItemStack(RegisterItem.karintoDough, 2),
				RegisterItem.sobako,
				Items.sugar,
				Items.water_bucket,
				RegisterItem.salt);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.sobaKarinto),
				"T",
				"D",
				"O",
				'T', RegisterItem.oilThrower,
				'D', RegisterItem.karintoDough,
				'O', RegisterItem.boilOilPot);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.sobaCookie, 8),
				"SCS",
				'S', RegisterItem.sobako,
				'C', new ItemStack(Items.dye, 1, 3));

		GameRegistry.addRecipe(new ItemStack(RegisterItem.blower),
				" I ",
				"IBI",
				" I ",
				'I', Items.iron_ingot,
				'B', Blocks.iron_block);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.driedHerring),
				"HB",
				'H', RegisterItem.herring,
				'B', RegisterItem.blower);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.pieceHerring, 2),
				"D",
				"H",
				'D', RegisterItem.driedHerring,
				'H', RegisterItem.hotyo);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.Kazunoko),
				"RB",
				'R', RegisterItem.herringRoe,
				'B', RegisterItem.blower);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.driedPieceHerring),
				"PB",
				'P', RegisterItem.pieceHerring,
				'B', RegisterItem.blower);

		GameRegistry.addShapelessRecipe((new ItemStack(RegisterItem.Migakinishin)),
				RegisterItem.driedPieceHerring);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.kanro),
				"S",
				"S",
				"C",
				'S', Items.sugar,
				'C', RegisterItem.syouyu);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.kanroPot),
				"K",
				"P",
				'K', RegisterItem.kanro,
				'P', RegisterItem.pot);

		GameRegistry.addSmelting(RegisterItem.kanroPot, new ItemStack(RegisterItem.boilKanroPot), 0.5F);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.NishinKanroni),
				"M",
				"K",
				'M', RegisterItem.Migakinishin,
				'K', RegisterItem.boilKanroPot);

		GameRegistry.addRecipe(new ItemStack(RegisterItem.NishinSoba),
				"NG",
				"ST",
				"O ",
				'N', RegisterItem.NishinKanroni,
				'G', RegisterItem.chopGreOni,
				'S', RegisterItem.yudetasoba,
				'T', RegisterItem.tuyu,
				'O', RegisterItem.owan);
	}
}
