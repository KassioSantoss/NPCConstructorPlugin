package brcomkassin.constructor.events.area;

import org.bukkit.Location;
import org.bukkit.block.data.BlockData;

import java.util.Map;

public interface AreaManager {

    void pasteBlocks(Map<Location, DataBlock> blockDataMap, Location newBaseLocation);

    Map<Location, DataBlock> copyBlocks(AreaSection area);

}
