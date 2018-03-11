package com.soba.sobamod;

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
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(SobaMod.sobanomi))){
			buckwheatFound = buckwheatFound + 1;
			event.player.addStat(SobaMod.getBuckwheat, 1);
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(SobaMod.greenOnion))){
			greenOnionFound = greenOnionFound + 1;
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(SobaMod.yam))){
			yamFound = yamFound + 1;
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(SobaMod.wasabi))){
			wasabiFound = wasabiFound + 1;
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(SobaMod.soyBean))){
			soyFound = soyFound + 1;
			this.triggerGetPlant(event);
			this.triggerGet64Plant(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(SobaMod.shrimp))){
			event.player.addStat(SobaMod.getEbi, 1);
			ebiFound = ebiFound + 1;
			this.triggerGet64Ebi(event);
		}

		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(SobaMod.herring))){
			event.player.addStat(SobaMod.getHerring, 1);
		}

	}

	private void triggerGet64Ebi(ItemPickupEvent event) {
		if(ebiFound >= 64)
		{
			event.player.addStat(SobaMod.get64Ebi, 1);
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
							event.player.addStat(SobaMod.getPlant, 1);
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
							event.player.addStat(SobaMod.get64Plant, 1);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
    public void crafting(ItemCraftedEvent event){
		if(event.crafting.getItem().equals(SobaMod.seirosoba)){
			event.player.addStat(SobaMod.getSoba, 1);
		}

		if(event.crafting.getItem().equals(SobaMod.ebitensoba)){
			ebitenpuraFound = ebitenpuraFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(SobaMod.tororoSoba)){
			tororoFound = tororoFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(SobaMod.tanukiSoba)){
			tanukiFound = tanukiFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(SobaMod.kitsuneSoba)){
			kitsuneFound = kitsuneFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(SobaMod.kakiageSoba)){
			kakiageFound = kakiageFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(SobaMod.kinoTenSoba)){
			mushroomFound = mushroomFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(SobaMod.NishinSoba)){
			nishinFound = nishinFound + 1;
			this.triggerGetDonmono(event);
		}

		if(event.crafting.getItem().equals(SobaMod.wankoSoba)){
			wankoFound = wankoFound + 1;
			this.triggerCraftWanko(event);
			this.triggerCraft100Wanko(event);
			this.triggerCraft200Wanko(event);
			this.triggerCraft500Wanko(event);
		}

		if(event.crafting.getItem().equals(SobaMod.seiro)){
			seiroFound = seiroFound + 1;
			this.triggerGetTableware(event);
		}

		if(event.crafting.getItem().equals(SobaMod.wankoSobaOwan)){
			wanOwaFound = wanOwaFound + 1;
			this.triggerGetTableware(event);
		}
	}

	private void triggerCraftWanko(ItemCraftedEvent event)
	{
		if(wankoFound >= 1)
		{
			event.player.addStat(SobaMod.craftWanko, 1);
		}
	}

	private void triggerCraft100Wanko(ItemCraftedEvent event)
	{
		if(wankoFound >= 100)
		{
			event.player.addStat(SobaMod.craft100Wanko, 1);
		}
	}

	private void triggerCraft200Wanko(ItemCraftedEvent event) {
		if(wankoFound >= 200)
		{
			event.player.addStat(SobaMod.craft200Wanko, 1);
		}
	}

	private void triggerCraft500Wanko(ItemCraftedEvent event)
	{
		if(wankoFound >= 500)
		{
			event.player.addStat(SobaMod.craft500Wanko, 1);
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
									event.player.addStat(SobaMod.getDonmono, 1);
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
		if(event.smelting.getItem().equals(SobaMod.yakisoba)){
			event.player.addStat(SobaMod.getYakisoba, 1);
		}

		if(event.smelting.getItem().equals(SobaMod.plate)){
			plateFound = plateFound + 1;
			this.triggerGetTableware(event);
		}

		if(event.smelting.getItem().equals(SobaMod.owan)){
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
						event.player.addStat(SobaMod.getTableware, 1);
					}
				}
			}
		}
	}
}
