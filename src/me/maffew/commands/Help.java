package me.maffew.commands;

import me.maffew.arenas.Arena;
import me.maffew.practice.Main;
import me.maffew.queue.Queue;
import me.maffew.utils.ExcessCmds;
import me.maffew.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {

    private Main p;
    private ExcessCmds utils;

    public Help(Main plugin, ExcessCmds utils) {
        this.p = plugin;
        this.utils = utils;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("help")) {
                utils.helpCommand(sender, args);
            }
        }

        return true;
    }

}
