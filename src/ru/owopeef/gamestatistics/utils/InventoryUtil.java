package ru.owopeef.gamestatistics.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class InventoryUtil {
    public static void LoadInventory(Player player, int size) {
        Inventory inv = Bukkit.createInventory(null, size * 9, "Магазин TNT Tag");
        ItemStack is = new ItemStack(Material.SLIME_BALL, 1);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(ChatColor.GREEN + "Магазин кастомизации");
        is.setItemMeta(im);
        inv.setItem(10, is);
        player.openInventory(inv);
    }

    public static void LoadInventory(Player player, int size, String title, List<ItemStack> items, List<Integer> itemsSlots) {
        Inventory inv = Bukkit.createInventory(null, size * 9, title);
        for (int i = 0; i != items.size(); i++) {
            inv.setItem(itemsSlots.get(i), items.get(i));
        }
        player.openInventory(inv);
    }
}
