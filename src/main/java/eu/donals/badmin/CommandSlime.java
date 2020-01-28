package eu.donals.badmin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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

            for (int x = -3; x < 4; x++){
                for (int z = -3; z < 4; z++){
                    player.getWorld().getBlockAt(player.getLocation().add(x, -1 , z)).setType(Material.SLIME_BLOCK);
                }
            }

        }

        return true;
    }
}
