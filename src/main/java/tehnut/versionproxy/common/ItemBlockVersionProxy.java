package tehnut.versionproxy.common;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tehnut.versionproxy.VPShortHand;

public class ItemBlockVersionProxy extends ItemBlock {

    public ItemBlockVersionProxy(Block block) {
        super(block);
    }

    // Proxy methods

    protected EnumActionResult onItemUseProxy(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        IBlockState worldState = world.getBlockState(pos);
        Block worldBlock = worldState.getBlock();
        ItemStack stack = player.getHeldItem(hand);

        if (!worldBlock.isReplaceable(world, pos))
            pos = pos.offset(facing);

        if (VPShortHand.isValid(stack) && player.canPlayerEdit(pos, facing, stack) && VPShortHand.canBlockBePlaced(world, this.block, pos, false, facing, null)) {
            int i = this.getMetadata(stack.getMetadata());
            IBlockState placedState = this.block.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, i, player, hand);

            if (placeBlockAt(stack, player, world, pos, facing, hitX, hitY, hitZ, placedState)) {
                SoundType soundtype = worldBlock.getSoundType(worldState, world, pos, player);
                world.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                VPShortHand.decrStackSize(stack, 1);
            }

            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.FAIL;
    }

    protected EnumActionResult onItemUseFirstProxy(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        return EnumActionResult.PASS;
    }

    protected ActionResult<ItemStack> onItemRightClickProxy(World world, EntityPlayer player, EnumHand hand) {
        return ActionResult.newResult(EnumActionResult.PASS, player.getHeldItem(hand));
    }

    // Soft Overrides - Override their Proxy variants instead.

    // @Override - Soft override - 1.11
    public final EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return onItemUseProxy(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    // @Override - Soft override - 1.10
    public final EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return onItemUseProxy(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    // @Override - Soft override - 1.11
    public final EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        return onItemUseFirstProxy(player, world, pos, side, hitX, hitY, hitZ, hand);
    }

    // @Override - Soft override - 1.10
    public final EnumActionResult onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        return onItemUseFirstProxy(player, world, pos, side, hitX, hitY, hitZ, hand);
    }

    // @Override - Soft override - 1.11
    public final ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        return onItemRightClickProxy(world, player, hand);
    }

    // @Override - Soft override - 1.10
    public final ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        return onItemRightClickProxy(world, player, hand);
    }
}
