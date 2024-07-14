package brcomkassin.constructor.utils;

import brcomkassin.Main;
import brcomkassin.constructor.item.ConstructorKey;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import java.util.Set;

public class DataManager {

    public static String getItemData(ItemStack item, Set<NamespacedKey> keys) {
        if (!item.hasItemMeta()) return null;
        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
        for (NamespacedKey key : keys) {
            if (container.has(key, PersistentDataType.STRING)) {
                return container.get(key, PersistentDataType.STRING);
            }
        }
        return null;
    }

    public static void setBlockData(Block block) {
        if (!(block.getState() instanceof TileState)) return;

        TileState tileState = (TileState) block.getState();
        PersistentDataContainer container = tileState.getPersistentDataContainer();

        container.set(new NamespacedKey(Main.getInstance(), ConstructorKey.CONSTRUCTOR_BLOCK_KEY),
                PersistentDataType.STRING, ConstructorKey.CONSTRUCTOR_BLOCK_KEY);

        tileState.update();
    }

    public static void removeItemData(ItemStack itemStack) {
        itemStack.getItemMeta().getPersistentDataContainer()
                .remove(new NamespacedKey(Main.getInstance(), ConstructorKey.CONSTRUCTOR_KEY));
    }

    public static String getBlockData(Block block) {

        if (!(block.getState() instanceof TileState)) return null;

        TileState tileState = (TileState) block.getState();
        PersistentDataContainer container = tileState.getPersistentDataContainer();

        NamespacedKey key = new NamespacedKey(Main.getInstance(), ConstructorKey.CONSTRUCTOR_BLOCK_KEY);

        if (container.has(key, PersistentDataType.STRING)) {
            return container.get(key, PersistentDataType.STRING);
        }
        return null;
    }
}

