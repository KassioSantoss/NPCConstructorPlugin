package brcomkassin;

import brcomkassin.constructor.commands.ConstructorBlockCommand;
import brcomkassin.constructor.events.constructorEvent.ConstructorBreakListener;
import brcomkassin.constructor.events.constructorEvent.ConstructorPlaceListener;
import brcomkassin.constructor.events.constructorEvent.ConstructorInventoryListener;
import brcomkassin.constructor.events.constructorEvent.ConstructorInteractListener;
import brcomkassin.constructor.area.AreaListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;
    private AreaListener areaInteractListener;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        areaInteractListener = new AreaListener();
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("constructorBlock").setExecutor(new ConstructorBlockCommand());
        getCommand("paste").setExecutor(areaInteractListener);
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new ConstructorPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new ConstructorInteractListener(), this);
        getServer().getPluginManager().registerEvents(new ConstructorInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new ConstructorBreakListener(), this);
        getServer().getPluginManager().registerEvents(areaInteractListener, this);
    }

}
