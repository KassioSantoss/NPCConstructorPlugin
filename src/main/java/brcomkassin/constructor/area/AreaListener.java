package brcomkassin.constructor.area;

import brcomkassin.utils.MessageUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public final class AreaListener implements Listener, CommandExecutor {

    private final AreaManager areaManager;

    public AreaListener() {
        areaManager = AreaBukkit.getAreaBukkit().getAreaManager();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getClickedBlock() == null) return;

        Location pos1 = event.getClickedBlock().getLocation();
        Location pos2 = event.getClickedBlock().getLocation();
        Action action = event.getAction();

        if (!(player.getInventory().getItemInMainHand().getType() == Material.STICK)) return;

        if (action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_AIR) return;

        if (areaManager.getAreaSection().isComplete()) {
            areaManager.copyBlocks();
            MessageUtils.sendMessage(player, "&aArea Copiada!");
            return;
        }

        if (action == Action.RIGHT_CLICK_BLOCK) {
            areaManager.getAreaSection().setPos1(pos1);
            MessageUtils.sendMessage(player, "&aPos1 set");
            return;
        }

        if (action == Action.LEFT_CLICK_BLOCK) {
            areaManager.getAreaSection().setPos2(pos2);
            MessageUtils.sendMessage(player, "&aPos2 set");
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() == Material.STICK) event.setCancelled(true);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        areaManager.pasteBlocks(player, areaManager.getBlockCache(), player.getLocation());
        return true;
    }

}

