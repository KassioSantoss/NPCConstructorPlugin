package brcomkassin.constructor.view;

import java.util.HashMap;
import java.util.Map;

public final class ViewManager {

    private final Map<ViewType, View> views;

    public ViewManager() {
        this.views = new HashMap<>();
        this.register(ViewType.HOME_CONSTRUCTOR, HomeConstructorView.get());
        this.register(ViewType.REVIEW_PAGE, ReviewConstructorView.get());
    }

    public View get(ViewType type) {
        if (type == null) return null;

        return this.views.get(type);
    }

    public void register(ViewType type, View view) {
        this.views.put(type, view);
    }
}
