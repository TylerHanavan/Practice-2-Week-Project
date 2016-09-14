package me.maffew.commands;

import me.maffew.practice.Main;
import me.maffew.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    private Main plugin;

    public Spawn(Main p) {
        this.plugin = p;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("spawn")) {
                if(getSpawn() != null) {
                    Message.send(p, plugin.config.getString("Messages.Help.Spawn"));
                    p.teleport(getSpawn());
                } else {
                    Message.send(p, "&4/spawn is currently not working.");
                }
            }
        }

        return false;
    }

    private Location getSpawn() {
        try {
            int x = plugin.config.getInt("Spawn.x");
            int y = plugin.config.getInt("Spawn.y");
            int z = plugin.config.getInt("Spawn.z");
            String worldName = plugin.config.getString("Spawn.world");
            return new Location(Bukkit.getWorld(worldName), x + 0.5D, y, z + 0.5D);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Practice : Error finding spawn");
        }
        return null;
    }

    public void teleportToSpawn(Player p) {
        if(getSpawn() != null) {
            p.teleport(getSpawn());
        } else {
            Message.send(p, "&4Error teleporting you to spawn!");
            p.teleport(p.getWorld().getSpawnLocation());
        }
    }
}
