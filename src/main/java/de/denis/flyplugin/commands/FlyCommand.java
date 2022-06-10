package de.denis.flyplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            boolean playerisflying = player.isFlying();
            if (player.hasPermission("flyplugin.fly")) {
                if (args.length == 0) {
                    if (!playerisflying) {
                        player.setAllowFlight(true);
                        player.sendMessage("§a Fly Mode: Activated");
                    } else {
                        player.setAllowFlight(false);
                        player.sendMessage("§a Fly Mode: §cDeactivated");
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        boolean targetisflying = target.isFlying();
                        if (!targetisflying){
                            target.setAllowFlight(true);
                            target.sendMessage("§a Fly Mode: Activated");
                            player.sendMessage("§b ("+target.getName()+") -> Fly Mode: Activated");
                        } else {
                            target.setAllowFlight(false);
                            target.sendMessage("§a Fly Mode: §cDeactivated");
                            player.sendMessage("§b ("+target.getName()+") -> Fly Mode: §cDeactivated");
                        }
                    } else {
                        player.sendMessage("§c Der Spieler §6"+args[0]+"§c wurde nicht gefunden!");
                    }
                } else {
                    sender.sendMessage("§cBitte benutze §6/fly <Spieler>§c!");
                }
            } else {
                sender.sendMessage("§cDu hast keine Rechte um diesen Befehl auszuführen!");
            }

        } else {
            sender.sendMessage("Diesen Befehl kannst du nur als Spieler ausführen!");
        }
        return false;
    }
}
