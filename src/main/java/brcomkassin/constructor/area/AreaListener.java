package brcomkassin.constructor.area;

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

public final class AreaListener implements Listener, CommandExecutor {

    private final AreaManager areaManager;

    public AreaListener() {
        areaManager = AreaBukkit.getAreaBukkit().getAreaManager();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Location pos1 = event.getClickedBlock().getLocation();
        Location pos2 = event.getClickedBlock().getLocation();
        Action action = event.getAction();

        if (!(player.getInventory().getItemInMainHand().getType() == Material.STICK)) return;

        if (action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_AIR) return;

        if (areaManager.getAreaSection().isComplete()) {
            areaManager.copyBlocks(areaManager.getAreaSection());
            player.sendMessage("AreaManager copied");
            return;
        }

        if (action == Action.RIGHT_CLICK_BLOCK) {
            areaManager.getAreaSection().setPos1(pos1);
            player.sendMessage("Pos1 set");
            return;
        }

        if (action == Action.LEFT_CLICK_BLOCK) {
            areaManager.getAreaSection().setPos2(pos2);
            player.sendMessage("Pos2 set");
            return;
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() == Material.STICK) event.setCancelled(true);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        areaManager.pasteBlocks(areaManager.getBlockCopiedMap(), player.getLocation());
        player.sendMessage("Construindo blocos");
        return false;
    }

}

