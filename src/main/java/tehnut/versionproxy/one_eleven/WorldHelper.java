package tehnut.versionproxy.one_eleven;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tehnut.versionproxy.iface.IWorldHelper;

import javax.annotation.Nullable;

public class WorldHelper implements IWorldHelper {

    WorldHelper() {

    }

    @Override
    public boolean canBlockBePlaced(World world, Block block, BlockPos pos, boolean ignoreCollision, EnumFacing side, @Nullable Entity entity) {
        return world.mayPlace(block, pos, ignoreCollision, side, entity);
    }
}
