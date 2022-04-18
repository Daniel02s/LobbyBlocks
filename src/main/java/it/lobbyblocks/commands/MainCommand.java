package it.lobbyblocks.commands;

import it.lobbyblocks.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    Main main;

    public MainCommand(Main main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player)) {
            Bukkit.getLogger().warning("Questo comando è eseguibile solamente da un giocatore.");
            return false;
        }

        Player p = (Player) sender;

        if(args.length != 1){
            p.sendMessage("§c§lHELP MENU");
            p.sendMessage("§f/lobbyblocks reload §8- §freloads the plugin");
            return false;
        }

            if (args[0].equalsIgnoreCase("reload")) {
                if (p.hasPermission("lobbyblocks.reload")) {

                    main.reloadConfig();
                    main.saveConfig();

                    p.sendMessage("§aLe configurazioni sono state ricaricate.");

                    if(Material.matchMaterial(main.getConfig().getString("blocks").toUpperCase()) == null){
                        System.out.println("Il blocco inserito non è valido");
                        main.getConfig().set("blocks", "STONE");
                        main.saveConfig();
                    }

                    return true;
                }

            } else {
                p.sendMessage("§c§lHELP MENU");
                p.sendMessage("§f/lobbyblocks reload §8- §freloads the plugin");
                return false;
            }
        return false;
    }
}

