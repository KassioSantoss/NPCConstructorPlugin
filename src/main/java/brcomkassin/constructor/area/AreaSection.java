package brcomkassin.constructor.area;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

@Getter
@Setter
public final class AreaSection {

    private Location pos1;
    private Location pos2;

    AreaSection() {
        pos1 = null;
        pos2 = null;
    }

    public boolean isComplete() {
        return pos1 != null && pos2 != null;
    }

    public void clear() {
        pos1 = null;
        pos2 = null;
    }
}
