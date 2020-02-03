package eu.donals.badmin.tasks;

import eu.donals.badmin.Badmin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class RestoreModifiedBlocks extends BukkitRunnable {

    Badmin badmin = null;
    private HashMap<Location, Material> map = null;
    private World world;
    Player player;

    public RestoreModifiedBlocks(Badmin plugin, World passed_world, HashMap<Location, Material> passed_map, Player player){
        this.badmin = plugin;
        this.world = passed_world;
        this.map = passed_map;
        this.player = player;
    }

    @Override
    public void run() {
        for (Map.Entry<Location, Material> entry : map.entrySet()){
            world.getBlockAt(entry.getKey()).setType(entry.getValue());
        }

        player.sendMessage("Blocks restored");
    }
}
