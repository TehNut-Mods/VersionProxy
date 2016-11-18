package tehnut.versionproxy.one_ten;

import tehnut.versionproxy.iface.IChatHelper;
import tehnut.versionproxy.iface.IItemStackHelper;
import tehnut.versionproxy.iface.IVersionProxy;
import tehnut.versionproxy.iface.IWorldHelper;

import javax.annotation.Nonnull;

public class VersionProxy1_10 implements IVersionProxy {

    private final IItemStackHelper stackHelper = new ItemStackHelper();
    private final IChatHelper chatHelper = new ChatHelper();
    private final IWorldHelper worldHelper = new WorldHelper();

    @Nonnull
    @Override
    public IItemStackHelper getStackHelper() {
        return stackHelper;
    }

    @Nonnull
    @Override
    public IChatHelper getChatHelper() {
        return chatHelper;
    }

    @Nonnull
    @Override
    public IWorldHelper getWorldHelper() {
        return worldHelper;
    }
}
