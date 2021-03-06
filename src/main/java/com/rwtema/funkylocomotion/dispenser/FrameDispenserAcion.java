package com.rwtema.funkylocomotion.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.rwtema.funkylocomotion.FunkyLocomotion;
import com.rwtema.funkylocomotion.items.ItemBlockFrame;

public class FrameDispenserAcion extends BehaviorDefaultDispenseItem {

	@Override
	public ItemStack dispenseStack(IBlockSource pos, ItemStack stack) {
		if (stack.getItem() instanceof ItemBlockFrame) {
			ItemBlockFrame frame = (ItemBlockFrame) stack.getItem();
			
			EnumFacing facing = BlockDispenser.func_149937_b(pos.getBlockMetadata());
			World world = pos.getWorld();
			int x = pos.getXInt() + facing.getFrontOffsetX();
			int y = pos.getYInt() + facing.getFrontOffsetY();
			int z = pos.getZInt() + facing.getFrontOffsetZ();
			if (world.getBlock(x, y, z).isReplaceable(world, x, y, z)) {
				world.setBlock(x, y, z, FunkyLocomotion.frame[frame.index / 16], stack.getItemDamage(), 3);
				stack.stackSize--;
			}
		}
		
		return stack;
	}
}