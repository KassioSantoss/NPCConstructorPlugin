package brcomkassin.constructor.item;

import brcomkassin.utils.ItemBuilder;
import brcomkassin.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ConstructorItem {
    public static final ItemStack blockConstructorItem;

    static {
        blockConstructorItem = ItemBuilder.of(Material.CHEST)
                .setName("&3&LBloco Construtor")
                .setLore("&3Com esse bloco você pode gerar construções de forma automática")
                .setItemMetaData(ConstructorKey.CONSTRUCTOR_KEY)
                .build();
    }

    public static void receiveBlock(Player player, int amount) {
        for (int i = 0; i < amount; i++) {
            player.getInventory().addItem(blockConstructorItem);
        }
        MessageUtils.sendMessage(player, "&aItem recebido com sucesso!");
    }

}
