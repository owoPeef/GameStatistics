package ru.owopeef.gamestatistics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.owopeef.gamestatistics.utils.InventoryUtil;

import java.util.ArrayList;
import java.util.List;

public class Inventories {
    public static void CreateCustomizationInventory(Player player) {
        List<ItemStack> items = new ArrayList<>();
        List<Integer> itemsSlots = new ArrayList<>();

        ItemStack oneIS = new ItemStack(Material.GLASS, 1);
        ItemMeta oneIM = oneIS.getItemMeta();
        oneIM.setDisplayName(ChatColor.GREEN + "Шапки");
        oneIS.setItemMeta(oneIM);
        items.add(oneIS);
        itemsSlots.add(10);

        ItemStack twoIS = new ItemStack(Material.GLASS, 1);
        ItemMeta twoIM = twoIS.getItemMeta();
        twoIM.setDisplayName(ChatColor.GREEN + "Победные танцы");
        twoIS.setItemMeta(twoIM);
        items.add(twoIS);
        itemsSlots.add(12);

        InventoryUtil.LoadInventory(player, 5, "Магазин кастомизации", items, itemsSlots);
    }

    public static void CreateCustomizationHatsInventory(Player player) {
        List<ItemStack> items = new ArrayList<>();
        List<Integer> itemsSlots = new ArrayList<>();

        ItemStack oneIS = new ItemStack(Material.BARRIER, 1);
        ItemMeta oneIM = oneIS.getItemMeta();
        oneIM.setDisplayName(ChatColor.GREEN + "Нет");
        oneIS.setItemMeta(oneIM);
        items.add(oneIS);
        itemsSlots.add(10);

        ItemStack twoIS = new ItemStack(Material.GLASS, 1);
        ItemMeta twoIM = twoIS.getItemMeta();
        twoIM.setDisplayName(ChatColor.GREEN + "Астронавт");
        twoIS.setItemMeta(twoIM);
        items.add(twoIS);
        itemsSlots.add(11);

        InventoryUtil.LoadInventory(player, 5, ChatColor.RESET + "Шапки", items, itemsSlots);
    }

    public static void CreateCustomizationWinEffectsInventory(Player player) {
        List<ItemStack> items = new ArrayList<>();
        List<Integer> itemsSlots = new ArrayList<>();

        ItemStack oneIS = new ItemStack(Material.BARRIER, 1);
        ItemMeta oneIM = oneIS.getItemMeta();
        oneIM.setDisplayName(ChatColor.GREEN + "Нет");
        oneIS.setItemMeta(oneIM);
        items.add(oneIS);
        itemsSlots.add(10);

        InventoryUtil.LoadInventory(player, 5, "Победные танцы", items, itemsSlots);
    }

    public static void CreateExampleInventory(Player player) {
        List<ItemStack> items = new ArrayList<>();
        List<Integer> itemsSlots = new ArrayList<>();

        ItemStack oneIS = new ItemStack(Material.BARRIER, 1);
        ItemMeta oneIM = oneIS.getItemMeta();
        oneIM.setDisplayName(ChatColor.GREEN + "Нет");
        oneIS.setItemMeta(oneIM);
        items.add(oneIS);
        itemsSlots.add(10);

        InventoryUtil.LoadInventory(player, 5, "Кастомизация" + ChatColor.GRAY + " >> " + ChatColor.RESET + "Шапки", items, itemsSlots);
    }
}
