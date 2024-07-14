package brcomkassin.constructor.view;

public final class ViewBukkit {

    private static ViewBukkit instance;

    private final ViewManager manager;

    public ViewBukkit() {
        this.manager = new ViewManager();
    }

    public static ViewBukkit getInstance() {
        if (instance == null)
            instance = new ViewBukkit();
        return instance;
    }

    public ViewManager getManager() {
        return manager;
    }
}
