package brcomkassin.constructor.area;

import brcomkassin.constructor.area.utils.BlockProperties;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.HashMap;
import java.util.Map;

@Getter
public final class AreaManager implements Area {

    private final Map<Location, BlockProperties> blocks;
    private AreaSection areaSection;

    AreaManager() {
        blocks = new HashMap<>();
    }

    public AreaSection getAreaSection() {
        if (areaSection == null) areaSection = new AreaSection();
        return areaSection;
    }

    @Override
    public void pasteBlocks(final Map<Location, BlockProperties> blockDataMap, final Location newBaseLocation) {
        final Location originLocation = blockDataMap.keySet().iterator().next();
        final World world = originLocation.getWorld();

        for (Map.Entry<Location, BlockProperties> entry : blockDataMap.entrySet()) {
            Location originalLoc = entry.getKey();
            BlockProperties blockData = entry.getValue();

            int offSetX = originalLoc.getBlockX() - originLocation.getBlockX();
            int offSetY = originalLoc.getBlockY() - originLocation.getBlockY();
            int offSetZ = originalLoc.getBlockZ() - originLocation.getBlockZ();

            Location newLoc = new Location(world, newBaseLocation.getX() + offSetX,
                newBaseLocation.getY() + offSetY,
                newBaseLocation.getZ() + offSetZ);

            Block block = newLoc.getBlock();
            block.setType(blockData.getMaterial());
            world.setBlockData(newLoc, blockData.getBlockData());

        }
        blocks.clear();
    }

    @Override
    public void copyBlocks(AreaSection area) {

        Location pos1 = area.getPos1();
        Location pos2 = area.getPos2();

        int xMin = Math.min(pos1.getBlockX(), pos2.getBlockX());
        int yMin = Math.min(pos1.getBlockY(), pos2.getBlockY());
        int zMin = Math.min(pos1.getBlockZ(), pos2.getBlockZ());

        int xMax = Math.max(pos1.getBlockX(), pos2.getBlockX());
        int yMax = Math.max(pos1.getBlockY(), pos2.getBlockY());
        int zMax = Math.max(pos1.getBlockZ(), pos2.getBlockZ());

        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMin; y <= yMax; y++) {
                for (int z = zMin; z <= zMax; z++) {
                    Location blockLocation = new Location(pos1.getWorld(), x, y, z);
                    Block block = blockLocation.getBlock();
                    blocks.put(blockLocation, new BlockProperties(block.getType(), blockLocation, block.getBlockData()));
                }
            }
        }
        area.clear();
    }

}
