package eu.donals.badmin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Badmin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Badmin successfully enabled");

        this.getCommand("slime").setExecutor(new CommandSlime());
    }
}

