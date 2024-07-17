package brcomkassin.constructor.events.constructorEvent;

import brcomkassin.constructor.view.ViewBukkit;
import brcomkassin.constructor.view.ViewType;
import brcomkassin.utils.DataManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class ConstructorInteractListener implements Listener {

    @EventHandler
    public void onInteractBlock(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();

        if (block == null || block.getType() == Material.AIR) return;

        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;

        if (block.getType() != Material.CHEST) return;

        String data = DataManager.getBlockData(block);

        if (data == null) return;

        event.setCancelled(true);

        ViewBukkit.getInstance().getInventoryManager().get(ViewType.HOME_CONSTRUCTOR).open(player);

    }
}

