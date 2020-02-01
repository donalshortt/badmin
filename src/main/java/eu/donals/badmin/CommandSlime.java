package eu.donals.badmin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;

public class CommandSlime implements CommandExecutor {

    Helper helper = new Helper();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player)sender;
            Location location = player.getLocation();
            Array<Location> savedBlocks = new Array();

            helper.spawnEntitiesAroundCommander(player.getWorld(), location, EntityType.VILLAGER);

            // Turn area under player to slime and save blocks changed in an array so they can be made unbreakable and reverted later
            for (int x = -3; x <= 3; x++){
                for (int z = -3; z <= 3; z++){
                    player.getWorld().getBlockAt(player.getLocation().add(x, -1 , z)).setType(Material.SLIME_BLOCK);
                }
            }

            return true;
        }

        sender.sendMessage("You issued slime command, but you are console, so nothing happened :)");
        return true;
    }
}
