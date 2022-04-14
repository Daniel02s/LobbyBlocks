package it.lobbyblocks.listeners;

import it.lobbyblocks.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener
{

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        Player p = e.getPlayer();

        if(e.getBlockPlaced().getType() == Material.WOOL) {
            if(p.hasPermission("lobbyblocks.use")) {

                Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {

                    e.getBlockPlaced().setType(Material.AIR);

                }, 80L);
            }
        }

    }

}
