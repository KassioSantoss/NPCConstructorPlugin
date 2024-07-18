package brcomkassin.constructor.area.utils;


import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public final class BlockCache {

    private final Map<Location, BlockProperties> blocks;

    public BlockCache() {
        blocks = new HashMap<>();
    }

    public Map<Location, BlockProperties> get() {
        return blocks;
    }

}
