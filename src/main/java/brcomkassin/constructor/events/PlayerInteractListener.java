package brcomkassin.constructor.events;

import brcomkassin.constructor.inventories.InventoryBukkit;
import brcomkassin.constructor.inventories.ViewType;
import brcomkassin.constructor.utils.DataManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class PlayerInteractListener implements Listener {

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

        openInventory(player);

    }

    private void openInventory(Player player) {
        player.openInventory(InventoryBukkit.getViewManager(ViewType.BUILD_PAGE_CONSTRUCTOR).open());
    }

}

