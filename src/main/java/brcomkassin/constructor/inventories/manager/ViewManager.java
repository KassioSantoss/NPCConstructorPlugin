package brcomkassin.constructor.inventories.manager;

import brcomkassin.constructor.inventories.MainPageInventory;
import brcomkassin.constructor.inventories.View;
import brcomkassin.constructor.inventories.ViewType;

import java.util.HashMap;
import java.util.Map;

public class ViewManager {
    private final Map<ViewType, View> views;
    public ViewManager() {
        this.views = new HashMap<>();
        this.register(ViewType.BUILD_PAGE_CONSTRUCTOR, MainPageInventory.get());
    }

    public View get(ViewType type) {
        return this.views.get(type);
    }

    public void register(ViewType type, View view) {
        this.views.put(type, view);
    }

}
