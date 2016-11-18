package tehnut.versionproxy.one_ten;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tehnut.versionproxy.iface.IWorldHelper;

import javax.annotation.Nullable;

public class WorldHelper implements IWorldHelper {

    WorldHelper() {

    }

    @Override
    public boolean canBlockBePlaced(World world, Block block, BlockPos pos, boolean ignoreCollision, EnumFacing side, @Nullable Entity entity) {
        IBlockState state = world.getBlockState(pos);
        AxisAlignedBB axisalignedbb = ignoreCollision ? null : block.getDefaultState().getCollisionBoundingBox(world, pos);
        return !(axisalignedbb != Block.NULL_AABB && !world.checkNoEntityCollision(axisalignedbb.offset(pos), entity)) && (state.getMaterial() == Material.CIRCUITS && state.getBlock() == Blocks.ANVIL || state.getBlock().isReplaceable(world, pos) && state.getBlock().canPlaceBlockOnSide(world, pos, side));
    }
}
