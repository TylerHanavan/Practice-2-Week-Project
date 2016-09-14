package me.maffew.practice;

import me.maffew.arenas.Arena;
import me.maffew.enums.GameStatus;
import me.maffew.queue.DuelRequests;
import org.bukkit.entity.Player;

public class Practice {

    private Main plugin;
    private Arena arena;
    private Player[] players = new Player[2];
    private String[] playernames = new String[2];
    private Player winner;
    private boolean getKit;
    private GameStatus gameState = GameStatus.ABOUT_TO_START;

    public Practice(Main p, DuelRequests requests) {

    }

    public void startGame() {

    }

    public GameStatus getGameState() {
        return this.gameState;
    }

    public Arena getArena() {
        return this.arena;
    }

    public Player getPlayerOne() {
        return this.players[0];
    }

    public Player getPlayerTwo() {
        return this.players[2];
    }

    public void setWinner(Player p) {
        this.winner = p;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public String[] getPlayerNames() {
        return this.playernames;
    }

    public boolean getKit() {
        return this.getKit;
    }
}
