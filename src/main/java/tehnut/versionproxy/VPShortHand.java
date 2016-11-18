package tehnut.versionproxy;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class VPShortHand {

    // Shorthand IItemStackHelper methods

    public static ItemStack getInvalid() {
        return VersionProxyMain.PROXY.getStackHelper().getInvalid();
    }

    public static boolean isValid(ItemStack stack) {
        return VersionProxyMain.PROXY.getStackHelper().isValid(stack);
    }

    public static int getStackSize(ItemStack stack) {
        return VersionProxyMain.PROXY.getStackHelper().getStackSize(stack);
    }

    public static ItemStack incrStackSize(ItemStack stack, int amount) {
        return VersionProxyMain.PROXY.getStackHelper().incrStackSize(stack, amount);
    }

    public static ItemStack decrStackSize(ItemStack stack, int amount) {
        return VersionProxyMain.PROXY.getStackHelper().decrStackSize(stack, amount);
    }

    // Shorthand IChatHelper methods

    public static void sendMessage(EntityPlayer player, ITextComponent message, boolean actionBar) {
        VersionProxyMain.PROXY.getChatHelper().sendMessage(player, message, actionBar);
    }

    // Shorthand IWorldHelper methods

    public static boolean canBlockBePlaced(World world, Block block, BlockPos pos, boolean ignoreCollision, EnumFacing side, @Nullable Entity entity) {
        return VersionProxyMain.PROXY.getWorldHelper().canBlockBePlaced(world, block, pos, ignoreCollision, side, entity);
    }
}
