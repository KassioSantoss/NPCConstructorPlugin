package brcomkassin.constructor.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface View {

    Inventory open();
    void close(Player player);
    void addItem(ItemStack itemStack);
    void removeItem(Material material);
    void init();

}
