package brcomkassin.constructor.events;

import brcomkassin.constructor.item.ConstructorKey;
import brcomkassin.constructor.utils.DataManager;
import brcomkassin.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public final class BlockPlaceListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlace(BlockPlaceEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();

        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (!(block.getType() == Material.CHEST)) return;

        for (Block b : adjacentBlocks(block)) {
            if (b.getType() == Material.CHEST && DataManager.getBlockData(b) != null) {
                event.setCancelled(true);
                MessageUtils.sendMessage(player, "&4Já tem um bloco construtor nesta área");
                return;
            }
        }

        String data = DataManager.getItemData(itemInHand, itemInHand.getItemMeta().getPersistentDataContainer().getKeys());

        if (data == null) return;

        if (!data.equals(ConstructorKey.CONSTRUCTOR_KEY)) return;

        Block placedBlock = event.getBlockPlaced();

        DataManager.setBlockData(placedBlock);
        DataManager.removeItemData(itemInHand);

    }

    private Block[] adjacentBlocks(Block block) {
        return new Block[]{
                block.getRelative(BlockFace.NORTH),
                block.getRelative(BlockFace.EAST),
                block.getRelative(BlockFace.SOUTH),
                block.getRelative(BlockFace.WEST),
                block.getRelative(BlockFace.UP),
        };
    }

}
