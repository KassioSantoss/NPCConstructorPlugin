package brcomkassin.constructor.area;

import brcomkassin.constructor.area.utils.BlockCache;
import brcomkassin.constructor.area.utils.BlockProperties;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Map;

public interface Area {

    void pasteBlocks(Player player, BlockCache blockCache, Location newBaseLocation);

    void copyBlocks();

}
