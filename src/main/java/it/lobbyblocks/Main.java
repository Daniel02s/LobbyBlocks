package it.lobbyblocks;

import com.comphenix.protocol.ProtocolManager;
import it.lobbyblocks.commands.MainCommand;
import it.lobbyblocks.listeners.PlaceEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Imaginary Green 16x

    private static Main instance;

    public static ProtocolManager protocolManager;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        instance = this;

        getCommand("lobbyblocks").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new PlaceEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
