package eu.donals.badmin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandSlime implements CommandExecutor {

    Helper helper = new Helper();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("You issued slime command :)");

        if (sender instanceof Player) {
            Player player = (Player)sender;
            Location location = player.getLocation();

            helper.spawnEntitysAroundCommander(player.getWorld(), location, EntityType.SLIME);
        }

        return true;
    }
}
