package brcomkassin.constructor.events;

import brcomkassin.constructor.view.ViewBukkit;
import brcomkassin.constructor.view.ViewType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

public class InventoryInteractListener implements Listener {

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        InventoryView view = event.getView();
        Player player = (Player) event.getWhoClicked();

        if (!view.getTitle().equals("Construtor Manager")) return;
        event.setCancelled(true);


        switch (event.getSlot()) {
            case 12:
                player.openInventory(ViewBukkit.getViewManager(ViewType.BUILD_PAGE_CONSTRUCTOR).open());
                break;
            case 14:
                break;
        }
    }

}
