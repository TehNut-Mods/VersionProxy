package tehnut.versionproxy.one_ten;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tehnut.versionproxy.VersionProxyMain;
import tehnut.versionproxy.iface.IWorldHelper;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

public class WorldHelper implements IWorldHelper {

    private static final Method _MAY_PLACE;

    static {
        try {
            String methodName = VersionProxyMain.IS_DEV ? "canBlockBePlaced" : "func_175716_a";
            _MAY_PLACE = World.class.getMethod(methodName, Block.class, BlockPos.class, boolean.class, EnumFacing.class, Entity.class, ItemStack.class);
            _MAY_PLACE.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException("Could not reflect the \"canBlockBePlaced\" method in World.");
        }
    }

    WorldHelper() {

    }

    @Override
    public boolean canBlockBePlaced(World world, Block block, BlockPos pos, boolean ignoreCollision, EnumFacing side, @Nullable Entity entity) {
        try {
            return (Boolean) _MAY_PLACE.invoke(world, block, pos, ignoreCollision, side, entity, null);
        } catch (Exception e) {
            return false;
        }
    }
}
