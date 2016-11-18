package tehnut.versionproxy.iface;

import javax.annotation.Nonnull;

/**
 * Main interface for a version proxy. Get an instance from {@link tehnut.versionproxy.VersionProxyMain#PROXY}.
 *
 * Supported versions can be found in the String(Version)->String(Class) Map at {@link tehnut.versionproxy.VersionProxyMain#PROXY_MAP}
 */
public interface IVersionProxy {

    /**
     * Obtains the {@link IItemStackHelper} for the current version proxy.
     * @return the {@link IItemStackHelper} for the current version proxy.
     */
    @Nonnull
    IItemStackHelper getStackHelper();

    /**
     * Obtains the {@link IChatHelper} for the current version proxy.
     * @return the {@link IChatHelper} for the current version proxy.
     */
    @Nonnull
    IChatHelper getChatHelper();

    /**
     * Obtains the {@link IWorldHelper} for the current version proxy.
     * @return the {@link IWorldHelper} for the current version proxy.
     */
    @Nonnull
    IWorldHelper getWorldHelper();
}
