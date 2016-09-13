package me.maffew.commands;


import me.maffew.arenas.Arena;
import me.maffew.practice.Main;
import me.maffew.queue.DuelRequests;
import me.maffew.queue.Queue;
import me.maffew.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Duel implements CommandExecutor {

    private Main p;
    private Queue queue;
    private DuelRequests requests;

    public Duel(Main plugin, Queue queue) {
        this.p = plugin;
        this.queue = queue;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("duel")) {
                if(args[0] == null) {
                    Message.send(sender, "&4Please specify a player!");
                } else {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if(target != null) {
	                    Message.send(p, "&bYou have dueled " + args[0]);
	                    Message.send(target, "&bYou have been dueled by " + p);
	                    Queue.addRequest(sender, target);
                    } else {
	                    Message.send(p, "&4That player is not online!");
                    }
                }
            } else if(cmd.getName().equalsIgnoreCase("accept")) {
                if(args[0] == null) {
                    Message.send(sender, "&4Please specify who you're accepting a duel from!");
                } else {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if(target != null) {
	                    if(!Queue.getRequest(target)) {
	                        Message.send(p, "&4You have not been dueled by this player!");
	                    } else {
	                        //TP THEM TO THE ARENA
	                        //START GAME
	                    }
                    } else {
	                    Message.send(p, "&4That player is not online!");
                    }
                }
            } else if(cmd.getName().equalsIgnoreCase("deny")) {
                if(args[0] == null) {
                    Message.send(sender, "&4Please specify who's request you're denying!");
                } else {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if(target != null) {
	                    if(!Queue.getRequest(target)) {
	                        Message.send(p, "&4You have not been dueled by this player!");
	                    } else {
	                        queue.removeRequest(requests);
	                    }
                    } else {
	                    Message.send(p, "&4That player is not online!");
                    }
                }
            }
        }

        return true;
    }
}
