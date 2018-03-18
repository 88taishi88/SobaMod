package com.soba.sobamod;

import com.soba.sobamod.init.RegisterItem;
import com.soba.sobamod.init.RegisterOther;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import net.minecraft.item.ItemStack;

public class EventListener
{
	public int buckwheatFound;
	public int greenOnionFound;
	public int yamFound;
	public int wasabiFound;
	public int soyFound;

	public int ebitenpuraFound;
	public int tororoFound;
	public int tanukiFound;
	public int kitsuneFound;
	public int kakiageFound;
	public int mushroomFound;
	public int nishinFound;

    public int ebiFound;
    public int herringFound;

    public int wankoFound;

    public int seiroFound;
    public int plateFound;
    public int owanFound;
    public int wanOwaFound;

	@SubscribeEvent
    public void pickup(ItemPickupEvent event){
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(RegisterItem.sobanomi))){
			buckwheatFound = buckwheatFound + 1;
			event.player.addStat(RegisterOther.getBuckwheat, 1);
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(RegisterItem.greenOnion))){
			greenOnionFound = greenOnionFound + 1;
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(RegisterItem.yam))){
			yamFound = yamFound + 1;
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(RegisterItem.wasabi))){
			wasabiFound = wasabiFound + 1;
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(RegisterItem.soyBean))){
			soyFound = soyFound + 1;
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(RegisterItem.shrimp))){
			event.player.addStat(RegisterOther.getEbi, 1);
			ebiFound = ebiFound + 1;
			this.triggerGet64Ebi(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(RegisterItem.herring))){
			event.player.addStat(RegisterOther.getHerring, 1);
		}

	}

	private void triggerGet64Ebi(ItemPickupEvent event) {
		if(ebiFound >= 64)
		{
			event.player.addStat(RegisterOther.get64Ebi, 1);
		}
	}

	@SubscribeEvent
	private void triggerGetPlant(ItemPickupEvent event)
	{
		if(buckwheatFound >= 1)
		{
			if(greenOnionFound >= 1)
			{
				if(yamFound >= 1)
				{
					if(wasabiFound >= 1)
					{
						if(soyFound >= 1)
						{
							event.player.addStat(RegisterOther.getPlant, 1);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	private void triggerGet64Plant(ItemPickupEvent event)
	{
		if(buckwheatFound >= 64)
		{
			if(greenOnionFound >= 64)
			{
				if(yamFound >= 64)
				{
					if(wasabiFound >= 64)
					{
						if(soyFound >= 64)
						{
							event.player.addStat(RegisterOther.get64Plant, 1);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
    public void crafting(ItemCraftedEvent event){
		if(event.crafting.getItem().equals(RegisterItem.seirosoba)){
			event.player.addStat(RegisterOther.getSoba, 1);
		}

		if(event.crafting.getItem().equals(RegisterItem.ebitensoba)){
			ebitenpuraFound = ebitenpuraFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(RegisterItem.tororoSoba)){
			tororoFound = tororoFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(RegisterItem.tanukiSoba)){
			tanukiFound = tanukiFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(RegisterItem.kitsuneSoba)){
			kitsuneFound = kitsuneFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(RegisterItem.kakiageSoba)){
			kakiageFound = kakiageFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(RegisterItem.kinoTenSoba)){
			mushroomFound = mushroomFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(RegisterItem.NishinSoba)){
			nishinFound = nishinFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(RegisterItem.wankoSoba)){
			wankoFound = wankoFound + 1;
			this.triggerCraftWanko(event);
			this.triggerCraft100Wanko(event);
			this.triggerCraft200Wanko(event);
			this.triggerCraft500Wanko(event);
		}

		if(event.crafting.getItem().equals(RegisterItem.seiro)){
			seiroFound = seiroFound + 1;
			this.triggerGetTableware(event);
		}

		if(event.crafting.getItem().equals(RegisterItem.wankoSobaOwan)){
			wanOwaFound = wanOwaFound + 1;
			this.triggerGetTableware(event);
		}
	}

	private void triggerCraftWanko(ItemCraftedEvent event)
	{
		if(wankoFound >= 1)
		{
			event.player.addStat(RegisterOther.craftWanko, 1);
		}
	}

	private void triggerCraft100Wanko(ItemCraftedEvent event)
	{
		if(wankoFound >= 100)
		{
			event.player.addStat(RegisterOther.craft100Wanko, 1);
		}
	}

	private void triggerCraft200Wanko(ItemCraftedEvent event) {
		if(wankoFound >= 200)
		{
			event.player.addStat(RegisterOther.craft200Wanko, 1);
		}
	}

	private void triggerCraft500Wanko(ItemCraftedEvent event)
	{
		if(wankoFound >= 500)
		{
			event.player.addStat(RegisterOther.craft500Wanko, 1);
		}
	}

	@SubscribeEvent
	private void triggerGetDonmono(ItemCraftedEvent event)
	{
		if(ebitenpuraFound >= 1)
		{
			if(tororoFound >= 1)
			{
				if(tanukiFound >= 1)
				{
					if(kitsuneFound >= 1)
					{
						if(kakiageFound >= 1)
						{
							if(mushroomFound >= 1)
							{
								if(nishinFound >= 1)
								{
									event.player.addStat(RegisterOther.getDonmono, 1);
								}
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void smelting(ItemSmeltedEvent event){
		if(event.smelting.getItem().equals(RegisterItem.yakisoba)){
			event.player.addStat(RegisterOther.getYakisoba, 1);
		}

		if(event.smelting.getItem().equals(RegisterItem.plate)){
			plateFound = plateFound + 1;
			this.triggerGetTableware(event);
		}

		if(event.smelting.getItem().equals(RegisterItem.owan)){
			owanFound = owanFound + 1;
			this.triggerGetTableware(event);
		}
	}

	private void triggerGetTableware(PlayerEvent event) {
		if(seiroFound >= 1)
		{
			if(plateFound >= 1)
			{
				if(owanFound >= 1)
				{
					if(wanOwaFound >= 1)
					{
						event.player.addStat(RegisterOther.getTableware, 1);
					}
				}
			}
		}
	}
}
