package it.lobbyblocks.listeners;

import it.lobbyblocks.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class PlaceEvent implements Listener {

    Main main;
    FileConfiguration config;

    public PlaceEvent(Main main){
        this.main = main;
        config = main.getConfig();
    }



    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        Player p = e.getPlayer();

        if(e.getBlockPlaced().getType().toString().equals(config.getString("blocks")) && p.hasPermission("lobbyblocks.use")){
            Block b = e.getBlockPlaced();




            new BukkitRunnable(){
                @Override
                public void run() {
                    b.setType(Material.AIR);

                    e.getPlayer().getInventory().addItem(new ItemStack(Material.valueOf(config.getString("blocks").toUpperCase())));

                    cancel();
                }
            }.runTaskLater(main, config.getLong("timer"));


        }

    }
}
