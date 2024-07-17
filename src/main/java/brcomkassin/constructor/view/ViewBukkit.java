package brcomkassin.constructor.view;

import lombok.Getter;

@Getter
public final class ViewBukkit {

    private static ViewBukkit instance;

    private final InventoryManager inventoryManager;

    private ViewBukkit() {
        this.inventoryManager = new InventoryManager();
    }

    public static ViewBukkit getInstance() {
        if (instance == null)
            instance = new ViewBukkit();
        return instance;
    }

}
