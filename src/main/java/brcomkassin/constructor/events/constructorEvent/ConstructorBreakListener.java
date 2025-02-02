package brcomkassin.constructor.events.constructorEvent;

import brcomkassin.constructor.item.ConstructorItem;
import brcomkassin.utils.DataManager;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class ConstructorBreakListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (DataManager.getBlockData(block) == null) return;

        if (player.getGameMode() == GameMode.CREATIVE) return;

        player.getInventory().addItem(ConstructorItem.blockConstructorItem);
        event.setDropItems(false);

    }

}
