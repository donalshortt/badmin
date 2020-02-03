package eu.donals.badmin;

import eu.donals.badmin.commands.CommandSlime;
import org.bukkit.plugin.java.JavaPlugin;

public final class Badmin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Badmin successfully enabled");

        // Commands
        this.getCommand("slime").setExecutor(new CommandSlime(this));

        // Listeners
        getServer().getPluginManager().registerEvents(new BlockEvents(), this);
    }
}

