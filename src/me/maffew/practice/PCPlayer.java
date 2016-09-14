package me.maffew.practice;

import org.bukkit.Bukkit;

import java.util.UUID;

public class PCPlayer {

    private UUID uuid;
    private Integer elo;

    public PCPlayer(UUID uuid, Integer elo) {
        this.uuid = uuid;
        this.elo = elo;
    }

    public PCPlayer getPlayer() {
        return (PCPlayer) Bukkit.getPlayer(this.uuid);
    }

    public int getElo(PCPlayer p) {
        return this.elo;
    }

}
