package brcomkassin.constructor.events;

import brcomkassin.constructor.view.ViewBukkit;
import brcomkassin.constructor.view.ViewManager;
import brcomkassin.constructor.view.ViewType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

public final class InventoryInteractListener implements Listener {

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        InventoryView view = event.getView();
        Player player = (Player) event.getWhoClicked();

        if (!view.getTitle().equals("Construtor Manager")) return;
        event.setCancelled(true);

        ViewManager viewManager = ViewBukkit.getInstance().getManager();

        switch (event.getSlot()) {
            case 12:
                viewManager.get(ViewType.HOME_CONSTRUCTOR).open(player);
                break;
            case 14:
                viewManager.get(ViewType.REVIEW_PAGE).open(player);
                break;
        }
    }

}
