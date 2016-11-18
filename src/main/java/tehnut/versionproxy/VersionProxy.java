package tehnut.versionproxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to obtain the active instance of {@link tehnut.versionproxy.iface.IVersionProxy}.
 *
 * Example:
 * <code>
 *     @VersionProxy
 *     public static final IVersionProxy VERSION_PROXY = null;
 * </code>
 *
 * Instances are injected right before the {@link net.minecraftforge.fml.common.event.FMLConstructionEvent} fires and a
 * valid Minecraft version has been detected. This annotation <i>can</i> set final fields.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VersionProxy {

}
