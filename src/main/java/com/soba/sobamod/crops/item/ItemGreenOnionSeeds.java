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

public class ItemGreenOnionSeeds extends ItemSeeds implements IPlantable {
	// 土台となるブロックのインスタンス。使われていない
	// private Block soilBlockID;

	public ItemGreenOnionSeeds() {
		super(RegisterBlock.GreenOnion, Blocks.farmland);
		// this.soilBlockID = Block.farmland;
		// this.setCreativeTab(RegisterOther.tabNoodle);
	}

	/** アイテムを使用したときの処理。 */
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (side != 1) {
			return false;
		} else if (player.canPlayerEdit(x, y, z, side, itemStack) && player.canPlayerEdit(x, y + 1, z, side, itemStack)) {
			// 上からの使用で、プレイヤーが編集可能で、右クリックしたブロックが耕地であり、その上が空気の時。
			if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z)) {
				// 作物を設置する
				world.setBlock(x, y + 1, z, RegisterBlock.GreenOnion);
				// スタック数を減らす
				--itemStack.stackSize;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/** 作物の種別を返す。 */
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		// IPlantableの実装。作物。耕地の上に設置する。
		return EnumPlantType.Crop;
	}

	/** 作物ブロックのインスタンスを返す。 */
	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		// IPlantableの実装
		return RegisterBlock.GreenOnion;
	}

	/** 作物のメタデータを返す。 */
	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		// IPlantableの実装
		return 0;
	}
}