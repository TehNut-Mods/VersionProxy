package tehnut.versionproxy.one_eleven;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import tehnut.versionproxy.iface.IChatHelper;

public class ChatHelper implements IChatHelper {

    ChatHelper() {
        // No-op
    }

    @Override
    public void sendMessage(EntityPlayer player, ITextComponent textComponent, boolean actionBar) {
        player.addChatComponentMessage(textComponent, actionBar);
    }
}
