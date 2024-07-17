package brcomkassin.constructor.area.utils;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

@Getter
public class BlockProperties {

    private final Material material;
    private final Location location;
    private final BlockData blockData;

    public BlockProperties(Material material, Location location, BlockData blockData) {
        this.material = material;
        this.location = location;
        this.blockData = blockData;
    }

}
