package de.denis.flyplugin;

import de.denis.flyplugin.commands.FlyCommand;
import de.denis.flyplugin.commands.FlySpeedCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Flyplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("flyspeed").setExecutor(new FlySpeedCommand());
        getCommand("fly").setExecutor(new FlyCommand());
    }
}
