package brcomkassin.constructor.inventories;

import brcomkassin.constructor.inventories.manager.ViewManager;

public final class InventoryBukkit {
    private static ViewManager viewManager = new ViewManager();

    public static View getViewManager(ViewType type) {
        return viewManager.get(type);
    }

}
