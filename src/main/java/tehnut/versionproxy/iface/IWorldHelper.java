package tehnut.versionproxy.iface;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public interface IWorldHelper {

    /**
     * Determines if a block can be placed at a certain point in the world.
     *
     * In 1.10, this forwards to {@code World#canBlockBePlaced(...)} (There is a stack parameter in this version).
     * In 1.11, this forwards to {@code World#canBlockBePlaced(...)} (There is no stack parameter in this version).
     *
     * @param block - The block to be placed
     * @param pos - The position to place at
     * @param ignoreCollision - If collision should be ignored
     * @param side - The side of the block being placed on
     * @param entity - The entity placing this block
     * @return if the block can be placed.
     */
    boolean canBlockBePlaced(World world, Block block, BlockPos pos, boolean ignoreCollision, EnumFacing side, @Nullable Entity entity);
}
