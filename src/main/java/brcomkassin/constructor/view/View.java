package brcomkassin.constructor.view;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface View {

    Inventory open();
    void close(Player player);

    void init();

}
