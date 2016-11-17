package tehnut.versionproxy;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tehnut.versionproxy.iface.IVersionProxy;

import java.util.Map;

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

    // This is unused. It's just a way to trick Forge into initializing this class
    @Mod.Instance("forge")
    private static Object FORGE_INSTANCE;

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
    }

    // Shorthand IItemStackHelper methods

    public static ItemStack getInvalid() {
        return PROXY.getStackHelper().getInvalid();
    }

    public static boolean isValid(ItemStack stack) {
        return PROXY.getStackHelper().isValid(stack);
    }

    public static int getStackSize(ItemStack stack) {
        return PROXY.getStackHelper().getStackSize(stack);
    }

    public static ItemStack incrStackSize(ItemStack stack, int amount) {
        return PROXY.getStackHelper().incrStackSize(stack, amount);
    }

    public static ItemStack decrStackSize(ItemStack stack, int amount) {
        return PROXY.getStackHelper().decrStackSize(stack, amount);
    }

    // Shorthand IChatHelper methods

    public static void sendMessage(EntityPlayer player, ITextComponent message, boolean actionBar) {
        PROXY.getChatHelper().sendMessage(player, message, actionBar);
    }
}
