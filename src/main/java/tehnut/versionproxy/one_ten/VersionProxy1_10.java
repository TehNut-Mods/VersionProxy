package tehnut.versionproxy.one_ten;

import tehnut.versionproxy.iface.IChatHelper;
import tehnut.versionproxy.iface.IItemStackHelper;
import tehnut.versionproxy.iface.IVersionProxy;

import javax.annotation.Nonnull;

public class VersionProxy1_10 implements IVersionProxy {

    @Nonnull
    @Override
    public IItemStackHelper getStackHelper() {
        return new ItemStackHelper();
    }

    @Nonnull
    @Override
    public IChatHelper getChatHelper() {
        return new ChatHelper();
    }
}
