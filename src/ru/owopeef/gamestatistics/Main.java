package ru.owopeef.gamestatistics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ru.owopeef.gamestatistics.utils.ItemUtil;
import ru.owopeef.gamestatistics.utils.MySQLUtil;
import ru.owopeef.gamestatistics.utils.ScoreboardUtil;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        try {
            getCommand("game_stats").setExecutor(new Commands());
            this.getLogger().info("Command \"game_stats\" init success");
        } catch (Exception exc) {
            this.getLogger().warning("Command \"game_stats\" don't init. ("+exc.getMessage()+")");
        }
        MySQLUtil.SQLInit("localhost", "minecraft", "root", "");
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            ItemUtil.LoadItem(p);
            ScoreboardUtil.LoadScoreboard(p);
        }
    }
}
