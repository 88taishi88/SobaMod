package com.soba.sobamod.crops;

import java.util.Random;

import com.soba.sobamod.init.RegisterItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class Buckwheat extends BlockCrops implements IPlantable, IGrowable {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconArray = new IIcon[4];

		for (int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = iconRegister.registerIcon("noodlesmod:buckwheat_" + (i + 1));
		}
	}

	/** 隣接ブロックが更新された時の処理。 */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		// 二重判定回避のためコメントアウト。実際、Blockクラスでは何もしていない。
		//		super.onNeighborBlockChange(world, x, y, z, block);
		this.checkAndDropBlock(world, x, y, z);
	}

	/** 設置状態を維持できるかを確認し、維持できなければドロップする。 */
	@Override
	protected void checkAndDropBlock(World world, int x, int y, int z) {
		// 維持できない時。
		if (!this.canBlockStay(world, x, y, z)) {
			// ドロップする。
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			// 空気に上書きする。
			world.setBlock(x, y, z, getBlockById(0), 0, 2);
		}
	}

	/** その座標で維持できるか。 */
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		// 下のブロックが耕地かどうかを判定する。
		return world.getBlock(x, y - 1, z).canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
	}

	/** 作物の種別を返す。 */
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		// IPlantableの実装。作物。耕地の上に設置する。
		return EnumPlantType.Crop;
	}

	public IIcon getIcon(int side, int metadata) {
		if (metadata < 7){
			if (metadata == 6) {
				metadata = 5;
			}

			return this.iconArray[metadata >> 1];
		}

		return this.iconArray[3];
	}

	public int quantityDropped(int metadata, int fortune, Random random) {
        return metadata == 6 ? random.nextInt() + 1 : 1; // 完全成長ならランダム、それ以外なら1つ
    }

	protected Item func_149866_i() {
		return RegisterItem.sobanomi;
	}

	protected Item func_149865_P() {
		return RegisterItem.sobanomi;
	}

}
