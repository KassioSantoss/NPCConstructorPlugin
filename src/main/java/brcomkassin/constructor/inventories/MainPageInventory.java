package brcomkassin.constructor.inventories;

import brcomkassin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public final class MainPageInventory implements View {
    private Inventory inventory;

    public static View get() {
        return new MainPageInventory();
    }

    @Override
    public Inventory open() {
        init();
        return inventory;
    }

    @Override
    public void close(Player player) {
        player.openInventory(inventory);
        player.closeInventory();
    }

    @Override
    public void addItem(ItemStack itemStack) {
        inventory.addItem(itemStack);
    }

    @Override
    public void removeItem(Material material) {
        inventory.remove(material);
    }

    @Override
    public void init() {
        inventory = Bukkit.createInventory(null, 27, "Construtor Manager");
        initMainPage();
    }

    private void initMainPage() {
        ItemStack buildItem = createBuildItem();
        ItemStack reviewHouse = createReviewHouseItem();
        ItemStack glasses = createGlassesItem();

        for (int i = 0; i < inventory.getSize(); i++) {
            if (i == 12) {
                inventory.setItem(i, buildItem);
            } else if (i == 14) {
                inventory.setItem(i, reviewHouse);
            } else {
                inventory.setItem(i, glasses);
            }
        }
    }

    private ItemStack createBuildItem() {
        return ItemBuilder.of(Material.CRAFTING_TABLE)
                .setName("&6&lComeçar a construir")
                .setLore("&fApertando aqui você vai iniciar a construção", "&fda sua casa!")
                .build();
    }

    private ItemStack createReviewHouseItem() {
        return ItemBuilder.of(Material.LIGHT_BLUE_SHULKER_BOX)
                .setName("&6&lRevisar Casa")
                .setLore("&fApertando aqui você vai revisar a construção", "&fda sua casa!")
                .build();
    }


    private ItemStack createGlassesItem() {
        return ItemBuilder.of(Material.GRAY_STAINED_GLASS_PANE)
                .setName(" ")
                .build();
    }

}