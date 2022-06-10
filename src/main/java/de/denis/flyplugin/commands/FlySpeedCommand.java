package de.denis.flyplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.geom.Arc2D;

public class FlySpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("flyplugin.fly.speed")) {
                if (args.length == 0) {
                    player.sendMessage("§cBitte benutze /flyspeed §nspeed");
                } else if (args.length == 1) {
                    float arg = Float.parseFloat(args[0]);
                    if (arg <= 1 && arg >= 0) {
                        player.setFlySpeed(arg);
                    player.sendMessage("§aFly Speed: §b" + arg * 10);
                    } else{
                        player.sendMessage("§cBitte benutze Zahlen von 0.0 bis 1.0");
                    }
                } else {
                    player.sendMessage("§cBitte benutze /flyspeed speed");
                }
            } else {
                player.sendMessage("§cDu hast keine Rechte um diesen Befehl auszuführen!");
            }
        } else {
            sender.sendMessage("§cDiesen Befehl kannst du nur als Spieler ausführen!");
        }
        return false;
    }
}
