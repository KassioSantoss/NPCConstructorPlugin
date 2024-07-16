package brcomkassin.constructor.view;

import org.bukkit.entity.Player;

public interface View {

    void open(Player player);

    void close(Player player);

    void init();

}
