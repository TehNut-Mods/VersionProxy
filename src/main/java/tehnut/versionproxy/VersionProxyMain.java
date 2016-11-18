package tehnut.versionproxy;

import com.google.common.collect.ImmutableMap;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.discovery.ModDiscoverer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tehnut.versionproxy.iface.IVersionProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;

@Mod(modid = "versionproxy", name = "VersionProxy", version = "@VERSION@", dependencies = "before:*")
public class VersionProxyMain {

    public static final Boolean IS_DEV = (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");
    public static final Logger LOGGER = LogManager.getLogger("VersionProxy");
    public static final IVersionProxy PROXY;
    private static final Map<String, String> PROXY_MAP = ImmutableMap.of(
            "1.9.4", "tehnut.versionproxy.one_ten_two.VersionProxy1_10",
            "1.10", "tehnut.versionproxy.one_ten_two.VersionProxy1_10",
            "1.10.2", "tehnut.versionproxy.one_ten_two.VersionProxy1_10",
            "1.11", "tehnut.versionproxy.one_eleven.VersionProxy1_11"
    );

    static {
        String mcVersion = Loader.MC_VERSION;
        LOGGER.info("Attempting to get version proxy for {}", mcVersion);
        try {
            if (!PROXY_MAP.containsKey(mcVersion))
                throw new RuntimeException(mcVersion + " is not a valid Minecraft version for this version of VersionProxy");

            Class proxyClass = Class.forName(PROXY_MAP.get(mcVersion));
            PROXY = (IVersionProxy) proxyClass.newInstance();
            LOGGER.info("Created version proxy for {}", mcVersion);
        } catch (Exception e) {
            throw new RuntimeException("Could not find a valid Cross-Version proxy.");
        }

        try {
            Field discovererField = Loader.class.getDeclaredField("discoverer");
            discovererField.setAccessible(true);
            ModDiscoverer discoverer = (ModDiscoverer) discovererField.get(Loader.instance());
            Set<ASMDataTable.ASMData> asmData = discoverer.getASMTable().getAll(VersionProxy.class.getCanonicalName());
            for (ASMDataTable.ASMData data : asmData) {
                Class injectClass = Class.forName(data.getClassName());
                Field proxyField = injectClass.getDeclaredField(data.getObjectName());
                String fieldLocation = injectClass.getCanonicalName() + "." + proxyField.getName();
                proxyField.setAccessible(true);
                if (Modifier.isStatic(proxyField.getModifiers())) {
                    EnumHelper.setFailsafeFieldValue(proxyField, null, PROXY);
                    LOGGER.info("Injected version proxy at {}", fieldLocation);
                } else {
                    throw new RuntimeException("Cannot set IVersionProxy value for non-static field " + fieldLocation);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
