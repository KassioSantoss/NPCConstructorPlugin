package brcomkassin.constructor.area;

import brcomkassin.constructor.area.utils.BlockProperties;
import org.bukkit.Location;

import java.util.Map;

public interface Area {

    void pasteBlocks(Map<Location, BlockProperties> blockDataMap, Location newBaseLocation);

    void copyBlocks(AreaSection area);

}
