package brcomkassin.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public final class MessageUtils {
    public static void sendMessage(Player player, String message) {
        String coloredMessage = ChatColor.translateAlternateColorCodes('&', message);
        player.sendMessage(coloredMessage);
    }
}

