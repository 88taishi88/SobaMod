package com.soba.sobamod.crops.block;

import java.util.ArrayList;
import java.util.Random;

import com.soba.sobamod.init.RegisterItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class Wasabi extends BlockCrops implements IPlantable, IGrowable {
	private IIcon[] iIcons;

	public Wasabi() {
		// BlockBush�̃R���X�g���N�^��Material��Material.plants�Ɏw�肳��Ă���B
		super();
		// updateTick�������_���ɌĂ΂��悤�ɂ���
		this.setTickRandomly(true);
		// �u���b�N�̑傫�����w�肷��B�����蔻���J�[�\�����������Ƃ��̘g�̑傫���Ɏg����B
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		// �N���G�C�e�B�u�^�u�ɕ\������Ȃ��悤�ɂ���B
		this.setCreativeTab(null);
		// ��u�Ŕj��ł���悤�ɂ���B�c�[���������Ă��Ă��ϋv�l�͏���Ȃ��B
		this.setHardness(0.0F);
		// �ݒu������s���̉��̎�ނ��w�肷��B
		this.setStepSound(soundTypeGrass);
		// ���v�ɃJ�E���g����Ȃ��悤�ɂ���B�i�H�j
		this.disableStats();
	}

	/** ���̍��W�ɐݒu�ł��邩�B */
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y, z).isReplaceable(world, x, y, z) && this.canBlockStay(world, x, y, z);
		// �ȉ���BlockBush�ł̎����Bsuper���Ăяo���Ɠ�d�ɔ��肳��Ă��܂����ߕύX�����B
		// return super.canplaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
	}

	/** ���̃u���b�N�̏�ɐݒu�ł��邩�B */
	@Override
	protected boolean canPlaceBlockOn(Block block) {
		// �k�n�̏�̂݁B
		return block == Blocks.farmland;
	}

	/** �אڃu���b�N���X�V���ꂽ���̏����B */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		//��d�������̂��߃R�����g�A�E�g�B���ہABlock�N���X�ł͉������Ă��Ȃ��B
		//		super.onNeighborBlockChange(world, x, y, z, block);
		this.checkAndDropBlock(world, x, y, z);
	}

	/** Tick�X�V���̏����B */
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		// �����_���ɌĂ΂��B
		this.checkAndDropBlock(world, x, y, z);
		// ���̃u���b�N�̌������x����9�ȏ�̎��B
		if (world.getBlockLightValue(x, y + 1, z) >= 9) {
			// ���^�f�[�^���擾�B
			int l = world.getBlockMetadata(x, y, z);
			// �������E�ɒB���Ă��Ȃ����B
			if (l < 7) {
				// �������₷�����擾�B
				float f = this.func_149864_n(world, x, y, z);
				// ���������邩���肷��B
				if (random.nextInt((int)(25.0F / f) + 1) == 0) {
					// ��i�K����������B
					++l;
					world.setBlockMetadataWithNotify(x, y, z, l, 2);
				}
			}
		}
	}

	/** �ݒu��Ԃ��ێ��ł��邩���m�F���A�ێ��ł��Ȃ���΃h���b�v����B */
	@Override
	protected void checkAndDropBlock(World world, int x, int y, int z) {
		// �ێ��ł��Ȃ����B
		if (!this.canBlockStay(world, x, y, z)) {
			// �h���b�v����B
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			// ��C�ɏ㏑������B
			world.setBlock(x, y, z, getBlockById(0), 0 ,2);
		}
	}

	/** ���̍��W�ňێ��ł��邩�B */
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		// ���̃u���b�N���k�n���ǂ����𔻒肷��B
		return world.getBlock(x, y - 1, z).canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
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
		return this;
	}

	/** �앨�̃��^�f�[�^��Ԃ��B */
	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		// IPlantable�̎����B
		return world.getBlockMetadata(x, y, z);
	}

	/** �������₷���̐��l��Ԃ��B */
	private float func_149864_n(World world, int x, int y, int z) {
		// ���͂̍k�n�A�앨�̏󋵂𔻒肵�A�������₷�����Z�o����B
		float f = 1.0F;
		Block block = world.getBlock(x, y, z - 1);
		Block block1 = world.getBlock(x, y, z + 1);
		Block block2 = world.getBlock(x - 1, y, z);
		Block block3 = world.getBlock(x + 1, y, z);
		Block block4 = world.getBlock(x - 1, y, z - 1);
		Block block5 = world.getBlock(x + 1, y, z - 1);
		Block block6 = world.getBlock(x + 1, y, z + 1);
		Block block7 = world.getBlock(x - 1, y, z + 1);

		boolean flag = block2 == this || block3 == this;
		boolean flag1 = block == this || block1 == this;
		boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

		for (int l = x - 1; l <= x + 1; ++l) {
			for (int i1 = z - 1; i1 <= z + 1; ++i1) {
				float f1 = 0.0F;
				if (world.getBlock(l, y - 1, i1).canSustainPlant(world, l, y - 1, i1, ForgeDirection.UP, this)) {
					f1 = 1.0F;
					if (world.getBlock(l, y - 1, i1).isFertile(world, l, y - 1, i1)) {
						f1 = 3.0F;
					}
				}
				if (l != x || i1 != z) {
					f1 /= 4.0F;
				}
				f += f1;
			}
		}
		if (flag2 || flag && flag1) {
			f /= 2.0F;
		}
		return f;
	}

	/** �����蔻���Ԃ��B */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		// �����蔻����Ȃ����B
		return null;
	}

	/** �s�����ȃu���b�N���B */
	@Override
	public boolean isOpaqueCube() {
		// �����ȃu���b�N�Ȃ̂�false��Ԃ��B
		return false;
	}

	/** �ʏ�Ɠ��l�ɕ`�悷�邩�B */
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	/** �`��̎�ʂ�Ԃ��B */
	@Override
	public int getRenderType() {
		// �����ȂǂƓ����B�l���̔��ォ�猩�āu��v�̌`�ɂȂ�悤�ɔz�u����A�����Ƀe�N�X�`�����\�������B
		return 6;
	}

	/** ��̃A�C�e����Ԃ��B */
	@Override
	protected Item func_149866_i() {
		return RegisterItem.wasabi;
	}

	/** �앨�̃A�C�e����Ԃ��B */
	@Override
	protected Item func_149865_P() {
		return RegisterItem.wasabi;
	}

	/** �u���b�N���h���b�v������B */
	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int meta, float dropChance, int fortune) {
		super.dropBlockAsItemWithChance(world, x, y, z, meta, dropChance, fortune);
		// BlockCrop�ňȉ��̂悤�ɃI�[�o�[���C�h����Ă���B�K�^���x����0�ɌŒ�B
		//		super.dropBlockAsItemWithChance(world, x, y, z, meta, dropChance, 0);
	}

	/** �h���b�v�A�C�e����Ԃ� */
	@Override
	public Item  getItemDropped(int meta, Random random, int fortune) {
		// ��{�I�Ɏ��Ԃ����A���S�������Ă�����앨��Ԃ��B
		return meta == 7 ? this.func_149865_P() : this.func_149866_i();
	}

	/** �h���b�v����Ԃ��B */
	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	/** �h���b�v�A�C�e���̃��X�g��Ԃ��B */
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		// �������Ȃ����A���S�������Ă�����앨���ǉ������B
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int count = quantityDropped(metadata,fortune, world.rand);
		for (int i = 0; i < count; i++) {
			Item item = getItemDropped(metadata, world.rand, fortune);
			if (item != null) {
				ret.add(new ItemStack(item, 1, damageDropped(metadata)));
			}
		}
		// �ȏ��Block�ł̎����B�ȉ���BlockCrops�o�̎����B�d����������̂��ߕύX�����B
		//		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);
		//
		// ���S�����̎��B
		if (metadata >= 7) {
			// �K�^���x���ɂ�蔻��񐔂���������B�f�t�H���g��3��B
			for (int i = 0; i < 3 + fortune; ++i) {
				// 0~14 <= 7�@���A1/2�̊m���B
				if (world.rand.nextInt(15) <= metadata) {
					// ���ǉ�����B
					ret.add(new ItemStack(this.func_149866_i(), 1, 0));
				}
			}
		}
		return ret;
	}

	/** �Ή�����A�C�e����Ԃ��B */
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		// ���Ԃ��B
		return this.func_149866_i();
	}

	/** �u���b�N�̃e�N�X�`����Ԃ� */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		// ���^�f�[�^�̐��l���ُ킾�����琬�����E�̒l���g���B
		if (meta < 0 || meta > 7) {
			meta = 7;
		}
		return this.iIcons[meta];
	}

	/** �u���b�N�̃e�N�X�`����o�^����B */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.iIcons = new IIcon[8];
		for (int i = 0; i < this.iIcons.length; ++i) {
			this.iIcons[i] = register.registerIcon(this.getTextureName() + "_" + i);
		}
	}

	/** �������g�p�ł��邩�B */
	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean isRemote) {
		// IGrowable�̎����B���S�������Ă�����false�B
		return world.getBlockMetadata(x, y, z) != 7;
	}

	/** ������K�p���邩 */
	@Override
	public boolean func_149852_a(World world, Random random, int x, int y, int z) {
		// IGrowable�̎����B
		return true;
	}

	/** ������K�p����B */
	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z) {
		// IGrowable�̎����B
		this.func_149863_m(world, x, y, z);
	}

	/** �������g�p�������̐��������鏈���B */
	@Override
	public void func_149863_m(World world, int x, int y, int z) {
		// �����i�K��2�ȏ�5�ȉ��㏸������B
		int l = world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
		// �������E�𒴂��Ă�����}����B
		if (l > 7) {
			l = 7;
		}
		// ���^�f�[�^��ݒ肷��B
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}



}
