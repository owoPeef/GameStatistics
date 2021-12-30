package ru.owopeef.gamestatistics.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {
    public static void LoadItem(Player player) {
        ItemStack is = new ItemStack(Material.EMERALD, 1);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(ChatColor.GREEN + "Кастомизация " + ChatColor.GRAY + "(ПКМ)");
        is.setItemMeta(im);
        player.getInventory().setItem(2, is);
    }

    public static void ReloadItem(Player player) {
        LoadItem(player);
    }
}
