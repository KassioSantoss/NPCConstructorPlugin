package brcomkassin.constructor.commands;

import brcomkassin.constructor.item.ConstructorItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ConstructorBlockCommand implements CommandExecutor{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage("Uso correto: /constructorBlock <amount>");
            return true;
        }

        if (args[0].isEmpty()) return true;

        int amount = Integer.parseInt(args[0]);
        ConstructorItem.receiveBlock(player, amount);


        return false;
    }

}
