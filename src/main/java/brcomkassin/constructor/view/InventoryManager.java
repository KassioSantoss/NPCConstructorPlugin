package brcomkassin.constructor.view;

import brcomkassin.constructor.view.inventories.HomeConstructorView;
import brcomkassin.constructor.view.inventories.ReviewConstructorView;

import java.util.HashMap;
import java.util.Map;

public final class InventoryManager {

    private final Map<ViewType, View> views;

    private InventoryManager() {
        this.views = new HashMap<>();
        this.register(ViewType.HOME_CONSTRUCTOR, HomeConstructorView.get());
        this.register(ViewType.REVIEW_PAGE, ReviewConstructorView.get());
    }

    public View get(ViewType type) {
        if (type == null) return null;

        return this.views.get(type);
    }

    private void register(ViewType type, View view) {
        this.views.put(type, view);
    }
}
