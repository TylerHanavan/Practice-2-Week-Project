package me.maffew.utils;

import me.maffew.practice.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExcessCmds {

    Main plugin;

    public ExcessCmds(Main p) {
        this.plugin = p;
    }

    public void helpCommand(CommandSender p, String[] args) {
        Message.send(p, "&8&m-----------------------------------------------------\n" 
        + this.plugin.getConfig().getString("Messages.Help.Information") + "\n"
        + "&8&m-----------------------------------------------------\n" 
        + this.plugin.getConfig().getString("Messages.Help.Season") + "\n"
        + this.plugin.getConfig().getString("Messages.Help.AvailableKits") + "\n" 
        + this.plugin.getConfig().getString("Messages.Help.HelpfulCommands") + "\n"
        + this.plugin.getConfig().getString("Messages.Help.DuelCmd") + "\n"
        + this.plugin.getConfig().getString("Messages.Help.Leaderboard"));
    }

}
