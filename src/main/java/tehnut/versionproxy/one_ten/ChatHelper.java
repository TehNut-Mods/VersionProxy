package tehnut.versionproxy.one_ten;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import tehnut.versionproxy.VersionProxyMain;
import tehnut.versionproxy.iface.IChatHelper;

import java.lang.reflect.Method;

public class ChatHelper implements IChatHelper {

    private static final Method _ADD_MESSAGE;

    static {
        try {
            String methodName = VersionProxyMain.IS_DEV ? "addChatComponentMessage" : "func_146105_b";
            _ADD_MESSAGE = EntityPlayer.class.getMethod(methodName, ITextComponent.class);
            _ADD_MESSAGE.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException("Could not reflect the \"addChatComponentMessage\" method in EntityPlayer.");
        }
    }

    ChatHelper() {
        // No-op
    }

    @Override
    public void sendMessage(EntityPlayer player, ITextComponent textComponent, boolean actionBar) {
        try {
            _ADD_MESSAGE.invoke(player, textComponent);
        } catch (Exception e) {
            // No-op
        }
    }
}
