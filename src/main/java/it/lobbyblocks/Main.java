package it.lobbyblocks;

import it.lobbyblocks.commands.MainCommand;
import it.lobbyblocks.listeners.PlaceEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getCommand("lobbyblocks").setExecutor(new MainCommand(this));
        Bukkit.getPluginManager().registerEvents(new PlaceEvent(this), this);

        if(Material.matchMaterial(this.getConfig().getString("blocks").toUpperCase()) == null){
            System.out.println("Il blocco inserito non è valido");
            this.getConfig().set("blocks", "STONE");
            this.saveConfig();
        }

    }

    @Override
    public void onDisable() {
    }
}
