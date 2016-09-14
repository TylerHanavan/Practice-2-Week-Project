package me.maffew.queue;

import me.maffew.arenas.Arena;
import me.maffew.practice.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private Main plugin;
    private Arena arena;
    private static List<DuelRequests> requests = new ArrayList<DuelRequests>();


    public Queue(Main p, Arena arena) {
        this.plugin = p;
        this.arena = arena;
        p.queue.add(this);
    }

    public List<DuelRequests> getRequests() {
        return requests;
    }

    public static boolean getRequest(Player target) {
        if(requests.contains(target)) {
            return false;
        }
        return false;
    }

    public static void addRequest(CommandSender sender, Player dueled) {
        //requests.add((DuelRequests) sender, dueled);//List.add() only takes one parameter... And DuelRequests cannot be cast to CommandSender or Player. You need to make a way to get an instance of DuelRequests as CommandSender or Player
    }

    public void removeRequest(DuelRequests requests) {
        Queue.requests.remove(requests);
        Queue.requests.remove(requests.getRecievedReq());
        Queue.requests.remove(requests.getReq()); //List.remove() only takes one parameter at a time
    }

    public Arena getArena() {
        return this.arena;
    }

}
