package ru.owopeef.gamestatistics;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.owopeef.gamestatistics.utils.ItemUtil;
import ru.owopeef.gamestatistics.utils.MySQLUtil;
import ru.owopeef.gamestatistics.utils.ScoreboardUtil;

import java.util.List;
import java.util.Objects;

public class Commands implements CommandExecutor {
    Plugin pl = JavaPlugin.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("game_stats")) {
            if (args.length == 0) {
                String str = ChatColor.AQUA + " " + pl.getDescription().getName() + " " + ChatColor.GRAY + "(v" + pl.getDescription().getVersion() + ") ";
                String first = ChatColor.GOLD + "-===" + str + ChatColor.GOLD + "===-";
                String a = ChatColor.YELLOW + "Автор плагина: " + ChatColor.GREEN + pl.getDescription().getAuthors().get(0);
                String b = ChatColor.YELLOW + "Сайт плагина: " + ChatColor.GREEN + pl.getDescription().getWebsite();
                String c = ChatColor.YELLOW + "Все команды: " + ChatColor.GREEN + "/" + cmd.getLabel() + " help";
                String last = ChatColor.GOLD + "-===";
                for (int i = 0; i != str.length(); i++) {
                    last += "=";
                }
                last += "===-";
                player.sendMessage(first + "\n" + a + "\n" + b + "\n" + c + "\n" + last);
                return true;
            }
            if (args.length == 1) {
                if (Objects.equals(args[0], "games")) {
                    String a = ChatColor.AQUA + "Available games:";
                    List<String> b = MySQLUtil.GetStringListFromDB("SELECT * FROM games", 3);
                    assert b != null;
                    StringBuilder c = new StringBuilder();
                    int i = 1;
                    for (String d : b) {
                        c.append(ChatColor.RESET).append(String.valueOf(i)).append(". ").append(d.replace("&", "§")).append("\n");
                        i++;
                    }
                    player.sendMessage(a + "\n" + c);
                    return true;
                }
                if (Objects.equals(args[0], "conn") || Objects.equals(args[0], "connection")) {
                    String conn = MySQLUtil.CheckConnection();
                    player.sendMessage(conn);
                }
                if (Objects.equals(args[0], "db")) {
                    player.sendMessage(String.format("URL: %s\n(User:Password): %s:%s", MySQLUtil.url, MySQLUtil.user, MySQLUtil.password));
                }
            }
        }
        if (args.length == 2) {
            if (Objects.equals(args[0], "reload")) {
                if (Objects.equals(args[1], "board")) {
                    ScoreboardUtil.ReloadBoard(player);
                }
                if (Objects.equals(args[1], "item")) {
                    ItemUtil.ReloadItem(player);
                }
            }
        }
        return true;
    }
}
