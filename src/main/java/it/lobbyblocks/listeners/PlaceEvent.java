package it.lobbyblocks.listeners;

import it.lobbyblocks.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PlaceEvent implements Listener
{

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        Player p = e.getPlayer();
        FileConfiguration config = Main.getInstance().getConfig();
        ItemStack block = new ItemStack(Material.getMaterial(config.getString("blocks")), 1, (short) 0);

        if (e.getBlockPlaced().getType().toString().equals(config.getString("blocks"))) {
            if(p.hasPermission("lobbyblocks.use")) {
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {


                    e.getBlockPlaced().setType(Material.AIR);

                    if(p.getGameMode() == GameMode.SURVIVAL) {
                        p.getInventory().addItem(block);
                    }else {
                        return;
                    }


                }, config.getLong("timer"));

            }
        }else {
            e.setCancelled(true);
        }
    }
}
