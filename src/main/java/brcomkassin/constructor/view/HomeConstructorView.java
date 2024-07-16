package brcomkassin.constructor.view;

import brcomkassin.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public final class HomeConstructorView implements View {

    private Inventory inventory;

    public static HomeConstructorView get() {
        return new HomeConstructorView();
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
        inventory = Bukkit.createInventory(null, 27, Component.text("Construtor Manager"));

        for (int i = 0; i < inventory.getSize(); i++)
            inventory.setItem(i, createGlassesItem());

        inventory.setItem(12, createBuildItem());
        inventory.setItem(14, createReviewHouseItem());
        inventory.setItem(26, createGlassesItem());
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
        return ItemBuilder.of(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build();
    }
}