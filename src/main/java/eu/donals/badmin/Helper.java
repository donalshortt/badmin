package eu.donals.badmin;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;

public final class Helper {

    protected void spawnEntitiesAroundCommander(World world, Location location, EntityType entity){

        for (int x = -3; x <= 3; x += 3){
            for (int z = -3; z <= 3; z += 3){
                Location spawn_location = location.clone();
                spawn_location.add(x, 0, z);
                if (x == 0 && z == 0) {continue;}
                world.spawnEntity(spawn_location, entity);
            }
        }
    }
}
