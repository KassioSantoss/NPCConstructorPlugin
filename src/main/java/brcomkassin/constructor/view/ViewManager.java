package brcomkassin.constructor.view;

import java.util.HashMap;
import java.util.Map;

public final class ViewManager {

    private final Map<ViewType, View> views;

    public ViewManager() {
        this.views = new HashMap<>();
        this.register(ViewType.MAIN_PAGE_CONSTRUCTOR, HomeConstructorView.get());
    }

    public View get(ViewType type) {
        return this.views.get(type);
    }

    public void register(ViewType type, View view) {
        this.views.put(type, view);
    }
}
