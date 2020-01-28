package eu.donals.badmin;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;

public final class Helper {

    protected void spawnEntitysAroundCommander(World world, Location location, EntityType entity){

        //hmm very ugly
        location.add(3, 0, 0);
        world.spawnEntity(location, entity);
        location.add(0, 0, 3);
        world.spawnEntity(location, entity);
        location.subtract(3, 0, 0);
        world.spawnEntity(location, entity);
        location.subtract(3, 0, 0);
        world.spawnEntity(location, entity);
        location.subtract(0, 0, 3);
        world.spawnEntity(location, entity);
        location.subtract(0, 0, 3);
        world.spawnEntity(location, entity);
        location.add(3, 0, 0);
        world.spawnEntity(location, entity);
        location.add(3, 0 , 0);
        world.spawnEntity(location, entity);
    }
}
