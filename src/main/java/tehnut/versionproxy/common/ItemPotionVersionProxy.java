package tehnut.versionproxy.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPotionVersionProxy extends ItemPotion {

    // Proxy methods

    protected EnumActionResult onItemUseProxy(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return EnumActionResult.PASS;
    }

    protected EnumActionResult onItemUseFirstProxy(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        return EnumActionResult.PASS;
    }

    protected ActionResult<ItemStack> onItemRightClickProxy(World world, EntityPlayer player, EnumHand hand) {
        player.setActiveHand(hand);
        return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    // Soft Overrides - Override their Proxy variants instead.

    // @Override - Soft override - 1.11
    public final EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return onItemUseProxy(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    // @Override - Soft override - 1.10
    // onItemUse
    public final EnumActionResult func_180614_a(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return onItemUseProxy(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    // @Override - Soft override - 1.11
    public final EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        return onItemUseFirstProxy(player, world, pos, side, hitX, hitY, hitZ, hand);
    }

    // @Override - Soft override - 1.10
    // Forge method so no srg name needed
    public final EnumActionResult onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        return onItemUseFirstProxy(player, world, pos, side, hitX, hitY, hitZ, hand);
    }

    // @Override - Soft override - 1.11
    public final ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        return onItemRightClickProxy(world, player, hand);
    }

    // @Override - Soft override - 1.10
    // onItemRightClick
    public final ActionResult<ItemStack> func_77659_a(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        return onItemRightClickProxy(world, player, hand);
    }
}
