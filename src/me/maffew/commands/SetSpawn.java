package me.maffew.commands;

import me.maffew.practice.Main;
import me.maffew.utils.Message;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {

    private Main plugin;

    public SetSpawn(Main p) {
        this.plugin = p;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("setspawn")) {
                Location loc = p.getLocation();
                int x = loc.getBlockX();
                int y = loc.getBlockY();
                int z = loc.getBlockZ();
                String worldName = p.getWorld().getName();

                plugin.config.set("Spawn.x", x);
                plugin.config.set("Spawn.y", y);
                plugin.config.set("Spawn.z", z);
                plugin.config.set("Spawn,world", worldName);

                Message.send(p, plugin.config.getString("Messages.Help.SpawnSet"));
            }
        }

        return false;
    }
}
