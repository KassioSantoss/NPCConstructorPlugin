package brcomkassin.constructor.area;

import lombok.Getter;

@Getter
public class AreaBukkit {

    private static volatile AreaBukkit areaBukkit;
    private final AreaManager areaManager;

    private AreaBukkit() {
        this.areaManager = new AreaManager();
    }

    public static AreaBukkit getAreaBukkit() {
        if (areaBukkit == null) {
            synchronized (AreaBukkit.class) {
                if (areaBukkit == null) {
                    areaBukkit = new AreaBukkit();
                }
            }
        }
        return areaBukkit;
    }
}
