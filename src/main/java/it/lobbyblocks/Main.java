package it.lobbyblocks;

import it.lobbyblocks.commands.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Imaginary Green 16x

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        instance = this;

        getCommand("lobbyblocks").setExecutor(new MainCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
