package brcomkassin;

import brcomkassin.constructor.commands.ConstructorBlockCommand;
import brcomkassin.constructor.events.BlockBreakListener;
import brcomkassin.constructor.events.BlockPlaceListener;
import brcomkassin.constructor.events.InventoryInteractListener;
import brcomkassin.constructor.events.PlayerInteractListener;
import brcomkassin.constructor.events.area.AreaBlockBreak;
import brcomkassin.constructor.events.area.AreaInteractListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;
    private AreaInteractListener areaInteractListener;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        areaInteractListener = new AreaInteractListener();
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
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryInteractListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new AreaBlockBreak(), this);
        getServer().getPluginManager().registerEvents(areaInteractListener, this);
    }

}
