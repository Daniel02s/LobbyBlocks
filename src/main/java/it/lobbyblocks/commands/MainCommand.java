package it.lobbyblocks.commands;

import it.lobbyblocks.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("Questo comando è eseguibile solamente da un giocatore.");
        }

        Player p = (Player) sender;

        if(args.length == 0) {
            p.sendMessage("§cThis server running LobbyBlocks by");
            p.sendMessage("§c@imaxiid and @banevado");
        }else if(args.length == 1) {
            if(args[0].equalsIgnoreCase("reload")) {
                if(p.hasPermission("lobbyblocks.reload")) {

                    Main.getInstance().reloadConfig();
                    Main.getInstance().saveConfig();
                    p.sendMessage("§aLe configurazioni sono state ricaricate.");

                }else {
                    p.sendMessage("§cThis server running LobbyBlocks by");
                    p.sendMessage("§c@imaxiid and @banevado");
                }
            }else {
                p.sendMessage("§cThis server running LobbyBlocks by");
                p.sendMessage("§c@imaxiid and @banevado");
            }
        }else {
            p.sendMessage("§cThis server running LobbyBlocks by");
            p.sendMessage("§c@imaxiid and @banevado");
        }

        return true;
    }
}
