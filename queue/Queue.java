package me.maffew.queue;

import me.maffew.arenas.Arena;
import me.maffew.practice.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Queue {

    private Main plugin;
    private Arena arena;
    private static ArrayList<DuelRequests> requests = new ArrayList();


    public Queue(Main p, Arena arena) {
        this.plugin = p;
        this.arena = arena;
        p.queue.add(this);
    }

    public ArrayList<DuelRequests> getRequests() {
        return requests;
    }

    public static boolean getRequest(Player target) {
        if(requests.contains(target)) {
            return false;
        }
        return false;
    }

    public static void addRequest(CommandSender sender, Player dueled) {
        requests.add((DuelRequests) sender, dueled);
    }

    public void removeRequest(DuelRequests requests) {
        Queue.requests.remove(requests, requests.getRecievedReq(), requests.getReq());
    }

    public Arena getArena() {
        return this.arena;
    }

}
