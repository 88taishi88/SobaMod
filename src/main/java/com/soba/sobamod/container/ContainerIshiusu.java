package com.soba.sobamod.container;

import com.soba.sobamod.crafting.IshiusuRecipes;
import com.soba.sobamod.tileentity.TileEntityIshiusu;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerIshiusu extends Container {

	private TileEntityIshiusu ishiusu;

	public int lastCookTime;

    public ContainerIshiusu(InventoryPlayer inventory, TileEntityIshiusu tileentity) {
    	this.ishiusu = tileentity;

    	this.addSlotToContainer(new Slot(tileentity, 0, 56, 35));
    	this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 1, 116, 35));

    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 9; j++) {
    			this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18));
    		}
    	}

    	for(int i =0; i < 9; i++) {
    		this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
    	}
    }

    public void addCraftingToCrafters(ICrafting icrafting) {
    	super.addCraftingToCrafters(icrafting);
    	icrafting.sendProgressBarUpdate(this, 0, this.ishiusu.cookTime);
    }

    public void detectAndSendChanges() {
    	super.detectAndSendChanges();
    	for(int i = 0; i < this.crafters.size(); ++i) {
    		ICrafting icrafting = (ICrafting) this.crafters.get(i);

    		if(this.lastCookTime != this.ishiusu.cookTime) {
    			icrafting.sendProgressBarUpdate(this, 0, this.ishiusu.cookTime);
    		}
    	}

    	this.lastCookTime = this.ishiusu.cookTime;
    }

    @SideOnly(Side.CLIENT)
    public void updatePogressBar(int slot, int newValue) {

    	if(slot == 0) {
    		this.ishiusu.cookTime = newValue;
    	}
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 1)
            {
                if (!this.mergeItemStack(itemstack1, 2, 38, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ != 1 && p_82846_2_ != 0)
            {
                if (IshiusuRecipes.grinding().getGrindingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 2 && p_82846_2_ < 29)
                {
                    if (!this.mergeItemStack(itemstack1, 29, 38, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 29 && p_82846_2_ < 38 && !this.mergeItemStack(itemstack1, 2, 29, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 2, 38, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }

	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

}
