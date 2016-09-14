package me.maffew.queue;

import me.maffew.arenas.Arena;
import me.maffew.practice.Main;

public class DuelRequests {

    public Main plugin;
    private String sendReq;
    private String recievedReq;
    private Arena arena;
    private boolean duelKit = false;

    public DuelRequests(Main p, String send, String rec, Arena bool) {
        this.sendReq = send;
        this.recievedReq = rec;
        this.arena = bool;
    }

    public String getReq() {
        return this.sendReq;
    }

    public String getRecievedReq() {
        return this.recievedReq;
    }

    public Arena getArena() {
        return this.arena;
    }
    
    public boolean getKit() {
        return this.duelKit;
    }
}
