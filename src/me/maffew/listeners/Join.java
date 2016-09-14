package me.maffew.listeners;

import me.maffew.kits.Inventories;
import me.maffew.practice.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Join implements Listener {

    private Main plugin;
    private Inventories inventories;

    public Join(Main p, Inventories inv) {
        this.plugin = p;
        this.inventories = inv;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        PlayerInventory i = p.getInventory();
        e.setJoinMessage(null);
        p.setGameMode(GameMode.SURVIVAL);
        inventories.playerInventory(p);
    }


}
