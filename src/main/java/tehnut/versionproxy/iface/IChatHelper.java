package tehnut.versionproxy.iface;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;

public interface IChatHelper {

    /**
     * Sends a chat message to the player.
     *
     * In 1.10, the {@code actionBar} param is ignored. All messages are sent to the chat.
     * In 1.11, this will either set the action bar text or add a chat message.
     *
     * @param player - The player to send the message to
     * @param textComponent - The message to send
     * @param actionBar - If this message should be displayed in the action bar instead (Ignored in 1.10)
     */
    void sendMessage(EntityPlayer player, ITextComponent textComponent, boolean actionBar);
}
