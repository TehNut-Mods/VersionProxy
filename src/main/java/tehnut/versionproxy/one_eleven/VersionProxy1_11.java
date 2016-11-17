package tehnut.versionproxy.one_eleven;

import tehnut.versionproxy.iface.IChatHelper;
import tehnut.versionproxy.iface.IItemStackHelper;
import tehnut.versionproxy.iface.IVersionProxy;

import javax.annotation.Nonnull;

public class VersionProxy1_11 implements IVersionProxy {

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
