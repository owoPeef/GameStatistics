package ru.owopeef.gamestatistics;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import ru.owopeef.gamestatistics.utils.InventoryUtil;
import ru.owopeef.gamestatistics.utils.ItemUtil;
import ru.owopeef.gamestatistics.utils.ScoreboardUtil;

import java.util.Objects;

public class PlayerEvents implements Listener {
    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        ItemUtil.LoadItem(event.getPlayer());
        ScoreboardUtil.LoadScoreboard(event.getPlayer());
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem().getItemMeta() != null) {
            if (Objects.equals(event.getCurrentItem().getItemMeta().getDisplayName(), ChatColor.GREEN + "Победные танцы")) {
                Inventories.CreateCustomizationWinEffectsInventory((Player) event.getWhoClicked());
                event.setCancelled(true);
            }
            if (Objects.equals(event.getCurrentItem().getItemMeta().getDisplayName(), ChatColor.GREEN + "Шапки")) {
                Inventories.CreateCustomizationHatsInventory((Player) event.getWhoClicked());
                event.setCancelled(true);
            }
            if (Objects.equals(event.getCurrentItem().getItemMeta().getDisplayName(), ChatColor.GREEN + "Магазин кастомизации")) {
                Inventories.CreateCustomizationInventory((Player) event.getWhoClicked());
                event.setCancelled(true);
            }
            if (Objects.equals(event.getCurrentItem().getItemMeta().getDisplayName(), ChatColor.GREEN + "Кастомизация " + ChatColor.GRAY + "(ПКМ)")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void OnInteract(PlayerInteractEvent event) {
        if (event.hasItem()) {
            if (Objects.equals(event.getItem().getItemMeta().getDisplayName(), ChatColor.GREEN + "Кастомизация " + ChatColor.GRAY + "(ПКМ)")) {
                InventoryUtil.LoadInventory(event.getPlayer(), 5);
            }
        }
    }

    @EventHandler
    public void OnWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
