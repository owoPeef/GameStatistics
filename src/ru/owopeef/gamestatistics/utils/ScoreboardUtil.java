package ru.owopeef.gamestatistics.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;
import ru.owopeef.gamestatistics.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScoreboardUtil {
    static Plugin pl = JavaPlugin.getPlugin(Main.class);
    public static void LoadScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("test", "sb");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§f§lTNT Tag");

        List<String> sb_types = MySQLUtil.GetStringListFromDB("SELECT * FROM gs_sb", 2);
        List<Integer> sb_indexes = MySQLUtil.GetIntegerListFromDB("SELECT * FROM gs_sb", 3);

        for (int i = 0; i != sb_types.size(); i++) {
            String q = "SELECT * FROM gs_types WHERE type_id='"+sb_types.get(i)+"'";
            String sb_name = MySQLUtil.GetStringFromDB(q, 3);
            String sb_prefix = MySQLUtil.GetStringFromDB(q, 4).replace("&", "§");
            String sb_suffix = MySQLUtil.GetStringFromDB(q, 5);
            if (sb_suffix == null) {
                sb_suffix = "";
            }
            List<Integer> player_score = MySQLUtil.GetIntegerListFromDB("SELECT * FROM gs_stats WHERE type='"+sb_types.get(i)+"' and (uuid='"+player.getUniqueId()+"' or nick='"+player.getName()+"')", 4);
            int sc = 0;
            assert player_score != null;
            for (Integer f : player_score) {
                sc += f;
            }
            Score score = objective.getScore(ChatColor.RESET + sb_name + ": " + sb_prefix + sc + sb_suffix);
            assert sb_indexes != null;
            score.setScore(sb_indexes.get(i));
        }
        player.setScoreboard(manager.getNewScoreboard());
        player.setScoreboard(board);
    }

    public static void ReloadBoard(Player player) {
        LoadScoreboard(player);
    }
}
