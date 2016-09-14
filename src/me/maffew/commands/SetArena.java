package me.maffew.commands;

import me.maffew.arenas.Arena;
import me.maffew.practice.Main;
import me.maffew.utils.Message;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Scanner;

public class SetArena implements CommandExecutor {

    private Main plugin;

    public SetArena(Main p, Arena a) {
        this.plugin = p;
        Arena arena = a;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("arena")) {
                if(args[0] == null) {
                    //Message.send(p, CURRENT ARENA);
                    Message.send(p, "&bCreate arena : /arena <create/remove> <name>");
                    Message.send(p, "&bSet arena : /arena set <name> <x/y/z>");
                } else if(args[0].equalsIgnoreCase("create") && args[1] == null) {
                    Message.send(p, "&bCreate arena : /arena <create/remove> <name>");
                } else if(args[0].equalsIgnoreCase("remove") && args[1] == null) {
                    Message.send(p, "&bCreate arena : /arena <create/remove> <name>");
                } else if(args[0].equalsIgnoreCase("create")){
                    String arenaName = args[1];
                    if(plugin.arenas.contains(arenaName)) {
                        Message.send(p, "&bAn arena under that name has already been created.");
                    } else {
                        if(args[2] == null) {
                            Message.send(p, "&bPlease specify which spawn it is. [1/2]");
                        } else {
                            String spawnPoint = args[2];
                            setArenaTP(p, spawnPoint, arenaName);
                        }
                    }
                } else if(args[0].equalsIgnoreCase("remove")) {
                    String arenaName = args[1];
                    if(!plugin.arenas.contains(arenaName)) {
                        Message.send(p, "&bThere is no arena with that name stored.");
                    } else {
                        Location loc = p.getLocation();
                        String worldName = loc.getWorld().getName();
                        removeArena(p, arenaName, worldName);
                    }
                }
            }
        }

        return false;
    }

    private void removeArena(Player p, String arenaName, String worldName) {
        int i = 1;
        while (i < 3) {
            String spawnPoint = Integer.toString(i);
            plugin.arenas.set("arena." + arenaName + spawnPoint + ".x", null);
            plugin.arenas.set("arena." + arenaName + spawnPoint + ".y", null);
            plugin.arenas.set("arena." + arenaName + spawnPoint + ".z", null);
            plugin.arenas.set("arena." + arenaName + "world", null);
            i++;
        }
        Message.send(p, "&bArena " + arenaName + " has been cleared.");
    }

    private void setArenaTP(Player p, String spawnP, String arenaName) {
        int spawnPoint = Integer.parseInt(spawnP);
        if(spawnPoint > 2) {
            Message.send(p, "&bThere can only be two spawnpoints in an arena!");
        } else {
            Location loc = p.getLocation();
            int x = loc.getBlockX();
            int y = loc.getBlockY();
            int z = loc.getBlockZ();
            String worldName = p.getWorld().getName();

            plugin.arenas.set("arena." + arenaName + spawnP + ".x", x);
            plugin.arenas.set("arena." + arenaName + spawnP + ".y", y);
            plugin.arenas.set("arena." + arenaName + spawnP + ".z", z);
            plugin.arenas.set("arena." + arenaName + "world", worldName);
        }
    }
}
