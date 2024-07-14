package brcomkassin;

import brcomkassin.constructor.commands.ConstructorBlockCommand;
import brcomkassin.constructor.events.BlockBreakListener;
import brcomkassin.constructor.events.BlockPlaceListener;
import brcomkassin.constructor.events.InventoryInteractListener;
import brcomkassin.constructor.events.PlayerInteractListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("constructorBlock").setExecutor(new ConstructorBlockCommand());
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryInteractListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

}
