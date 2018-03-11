package com.soba.sobamod.tileentity;

import com.soba.sobamod.crafting.IshiusuRecipes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityIshiusu extends TileEntity implements ISidedInventory {

    private String localizedName;

    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {1};
    private static final int[] slotsSides = new int[] {0};

    private ItemStack[] slots = new ItemStack [2];

    public final int ishiusuSpeed = 100;
    /*
     * The number of ticks that the current item has been cooking for
     */
    public int cookTime;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.slots.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int var1)
    {
        return this.slots[var1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
     public ItemStack decrStackSize(int var1, int var2) {
		if(this.slots[var1] != null) {
			ItemStack itemstack;

			if(this.slots[var1].stackSize <= var2) {
				itemstack = this.slots[var1];
				this.slots[var1] = null;
				return itemstack;
			}else{
				itemstack = this.slots[var1].splitStack(var2);

				if(this.slots[var1].stackSize == 0) {
					this.slots[var1] = null;
				}
			}
		}
		return null;
	}

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int i) {
        if(this.slots[i] != null) {
            ItemStack itemstack = this.slots[i];
            this.slots[i] = null;
            return itemstack;
        }
        return null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        this.slots[i] = itemstack;

        if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.localizedName : "container.ishiusu";
    }


    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName() {
        return this.localizedName != null && this.localizedName.length() > 0;
    }

    public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}

    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("Item", 10);
        this.slots = new ItemStack[this.getSizeInventory()];

        for(int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
            byte b = compound.getByte("Slot");

            if(b >= 0 && b < this.slots.length) {
                this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
            }
        }

        this.cookTime = (int)nbt.getShort("CookTime");

        if(nbt.hasKey("CustomName")) {
            this.localizedName = nbt.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setShort("CookTime", (short)this.cookTime);

        NBTTagList list = new NBTTagList();

        for(int i = 0; i < this.slots.length; i++) {
            if(this.slots[i] != null) {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte)i);
                this.slots[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }

        nbt.setTag("Item", list);

        if(this.hasCustomInventoryName()) {
            nbt.setString("CustomName", this.localizedName);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int i)
    {
        return this.cookTime * i / this.ishiusuSpeed;
    }

    public void updateEntity()
    {
        boolean flag1 = false;

        if (!this.worldObj.isRemote)
        {
            if (this.cookTime != 0 || this.slots[0] != null)
            {

                if (this.canGrind())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.ishiusuSpeed)
                    {
                        this.cookTime = 0;
                        this.grindItem();
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    private boolean canGrind()
    {
        if(this.slots[0] == null){
            return false;
        } else {
            ItemStack itemstack = IshiusuRecipes.grinding().getGrindingResult(this.slots[0]);
            if (itemstack == null) return false;
            if (this.slots[1] == null) return true;
            if (!this.slots[1].isItemEqual(itemstack)) return false;
            int result = slots[1].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.slots[1].getMaxStackSize();
        }
    }

    private void grindItem() {
        if (this.canGrind())
        {
            ItemStack itemstack = IshiusuRecipes.grinding().getGrindingResult(this.slots[0]);

            if (this.slots[1] == null)
            {
                this.slots[1] = itemstack.copy();
            }
            else if (this.slots[1].getItem() == itemstack.getItem())
            {
                this.slots[1].stackSize += itemstack.stackSize;
            }

            --this.slots[0].stackSize;

            if (this.slots[0].stackSize <= 0)
            {
                this.slots[0] = null;
            }
        }
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return slot == 1 ? false : true;
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int var1) {
        return var1 == 0 ? slotsBottom : (var1 == 1 ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int i, ItemStack itemstack, int var3) {
        return this.isItemValidForSlot(i, itemstack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return j != 0 || i != 1;
    }
}
