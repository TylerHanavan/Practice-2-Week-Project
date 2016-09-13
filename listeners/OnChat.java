package me.maffew.listeners;

import me.maffew.practice.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class OnChat implements Listener {
    private Main plugin;
    private ArrayList disabledGlobalChat;
    
    public OnChat(Main p) {
        this.plugin = p;
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.disabledGlobalChat = new ArrayList();
    }

    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String noParty = "§a<player>§r: <message>";
        String inParty = "§7(§9Party§7)<player>§r: <message>";
        String partyLeader = "§c*§7(§9Party§7)<player>: <message>";
        //if(plugin.)
    }
}
