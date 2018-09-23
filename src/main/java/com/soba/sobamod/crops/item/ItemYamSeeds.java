package com.soba.sobamod.crops.item;

import com.soba.sobamod.init.RegisterBlock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemYamSeeds extends ItemSeeds implements IPlantable {

	public ItemYamSeeds() {
		super(RegisterBlock.Yam, Blocks.farmland);
		// this.soilBlockID = Block.farmland;
		// this.setCreativeTab(RegisterOther.tabNoodle);
	}

	/** �A�C�e�����g�p�������̏����B */
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (side != 1) {
			return false;
		} else if (player.canPlayerEdit(x, y, z, side, itemStack) && player.canPlayerEdit(x, y + 1, z, side, itemStack)) {
			// �ォ��̎g�p�ŁA�v���C���[���ҏW�\�ŁA�E�N���b�N�����u���b�N���k�n�ł���A���̏オ��C�̎��B
			if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z)) {
				// �앨��ݒu����B
				world.setBlock(x, y + 1, z, RegisterBlock.Yam);
				// �X�^�b�N�������炷�B
				--itemStack.stackSize;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/** �앨�̎�ʂ�Ԃ��B*/
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		// IPlantable�̎����B�앨�B�k�n�̏�ɐݒu����B
		return EnumPlantType.Crop;
	}

	/** �앨�u���b�N�̃C���X�^���X��Ԃ��B */
	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		// IPlantable�̎����B
		return RegisterBlock.Yam;
	}

	/** �앨�̃��^�f�[�^��Ԃ��B */
	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		// IPlantable�̎����B
		return 0;
	}
}
