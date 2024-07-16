package brcomkassin.constructor.events.area;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class AreaInteractListener implements Listener, CommandExecutor {

    private final Area area;
    private final AreaSection areaSection;

    public AreaInteractListener() {
        this.area = new Area();
        this.areaSection = new AreaSection();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Location pos1 = event.getClickedBlock().getLocation();
        Location pos2 = event.getClickedBlock().getLocation();
        Action action = event.getAction();

        if (!(player.getInventory().getItemInMainHand().getType() == Material.STICK)) return;

        if (action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_AIR) return;

        if (areaSection.isComplete()) {
            area.copyBlocks(areaSection);
            player.sendMessage("Area copied");
            return;
        }

        if (action == Action.RIGHT_CLICK_BLOCK) {
            areaSection.setPos1(pos1);
            player.sendMessage("Pos1 set");
            return;
        }

        if (action == Action.LEFT_CLICK_BLOCK) {
            areaSection.setPos2(pos2);
            player.sendMessage("Pos2 set");
            return;
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        area.pasteBlocks(area.getBlockCopiedMap(), player.getLocation());
        player.sendMessage("Construindo blocos");

        return false;
    }
}

