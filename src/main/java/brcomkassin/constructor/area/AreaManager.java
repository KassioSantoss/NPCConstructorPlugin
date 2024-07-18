package brcomkassin.constructor.area;

import brcomkassin.constructor.area.utils.BlockCache;
import brcomkassin.constructor.area.utils.BlockProperties;
import brcomkassin.utils.MessageUtils;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Map;

@Getter
public final class AreaManager implements Area {

    private AreaSection areaSection;
    private final BlockCache blockCache;

    AreaManager() {
        blockCache = new BlockCache();
    }

    public AreaSection getAreaSection() {
        if (areaSection == null) areaSection = new AreaSection();
        return areaSection;
    }

    @Override
    public void pasteBlocks(final Player player, final BlockCache blockCache, final Location newBaseLocation) {

        if (!areaSection.isComplete()) {
            MessageUtils.sendMessage(player, "&4 Você precisa setar as duas posições primeiro!");
            return;
        }

        final Location originLocation = blockCache.get().keySet().iterator().next();
        final World world = originLocation.getWorld();

        for (Map.Entry<Location, BlockProperties> entry : blockCache.get().entrySet()) {
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
        blockCache.get().clear();
        MessageUtils.sendMessage(player, "&6Construindo Blocos");
    }

    @Override
    public void copyBlocks() {

        if (areaSection.isComplete()) {
            blockCache.get().clear();
        }

        Location pos1 = areaSection.getPos1();
        Location pos2 = areaSection.getPos2();

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
                    blockCache.get().put(blockLocation, new BlockProperties(block.getType(), blockLocation, block.getBlockData()));
                }
            }
        }
        areaSection.clear();
    }

}
