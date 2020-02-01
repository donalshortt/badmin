package eu.donals.badmin.commands;

import eu.donals.badmin.Helper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CommandSlime implements CommandExecutor {

    Helper helper = new Helper();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player)sender;
            Location location = player.getLocation();
            HashMap<Location, Block> locationsAndBlocks = new HashMap<Location, Block>();

            helper.spawnEntitiesAroundCommander(player.getWorld(), location, EntityType.SLIME);

            // Turn area under player to slime and save blocks changed in a hashmap so they can be made unbreakable and reverted later
            for (int x = -3; x <= 3; x++){
                for (int z = -3; z <= 3; z++){
                    Location blockLocation = player.getLocation().add(x, -1 , z);
                    Block blockType = player.getWorld().getBlockAt(blockLocation);
                    blockType.setType(Material.SLIME_BLOCK);
                    locationsAndBlocks.put(blockLocation, blockType);
                }
            }

            return true;
        }

        sender.sendMessage("You issued slime command, but you are console, so nothing happened :)");
        return true;
    }
}
