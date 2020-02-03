package eu.donals.badmin.commands;

import eu.donals.badmin.Badmin;
import eu.donals.badmin.Helper;
import eu.donals.badmin.tasks.RestoreModifiedBlocks;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class CommandSlime implements CommandExecutor {

    Helper helper = new Helper();
    private final Badmin badmin;

    public CommandSlime(Badmin plugin){
        this.badmin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player)sender;
            Location location = player.getLocation();
            HashMap<Location, Material> locationsAndBlockTypes = new HashMap<Location, Material>();

            helper.spawnEntitiesAroundCommander(player.getWorld(), location, EntityType.SLIME);

            // Turn area under player to slime and save blocks changed in a hashmap so they can be made unbreakable and reverted later
            for (int x = -3; x <= 3; x++){
                for (int z = -3; z <= 3; z++){
                    Location blockLocation = player.getLocation().add(x, -1 , z);
                    Material blockType = player.getWorld().getBlockAt(blockLocation).getType();
                    locationsAndBlockTypes.put(blockLocation, blockType);
                    player.getWorld().getBlockAt(blockLocation).setType(Material.SLIME_BLOCK);
                }
            }

            BukkitTask restoreBlocksTask = new RestoreModifiedBlocks(this.badmin, player.getWorld(), locationsAndBlockTypes, player).runTaskLater(this.badmin, 100);

            return true;
        }

        sender.sendMessage("You issued slime command, but you are console, so nothing happened :)");
        return true;
    }
}
