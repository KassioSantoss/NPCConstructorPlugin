package brcomkassin.constructor.view;

import brcomkassin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.createInventory;

public class ReviewConstructorView implements View {

    private Inventory inventory;

    public static ReviewConstructorView get() {
        return new ReviewConstructorView();
    }

    @Override
    public void open(Player player) {
        if (inventory == null) init();
        player.openInventory(inventory);
    }

    @Override
    public void close(Player player) {
        player.closeInventory();
    }

    @Override
    public void init() {
        inventory = createInventory(null, 27, "Review Page");
    }

    private ItemStack createBuildItem() {

        return ItemBuilder.of(Material.CRAFTING_TABLE)
            .setName("&6&lComeçar a construir")
            .setLore("&fApertando aqui você vai iniciar a construção", "&fda sua casa!")
            .build();
    }

}
