package zhyrapian.zhy;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class UserPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.GREEN + "The Userplugin is enabled");
        getCommand("mod").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "The Userplugin is disabled.");
    }
}
