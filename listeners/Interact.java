package me.maffew.listeners;

import me.maffew.kits.Inventories;
import me.maffew.practice.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Interact implements Listener {

    private Main plugin;
    private Inventories inventories;

    public Interact(Main p, Inventories inv) {
        this.plugin = p;
        this.inventories = inv;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack inHand = p.getItemInHand();

        if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
            if(inHand.getType() == Material.DIAMOND_SWORD && inHand.getItemMeta().getDisplayName().equalsIgnoreCase("Ranked Styles")) {
                inventories.rankedStyles(p);
            } else if(inHand.getType() == Material.IRON_SWORD && inHand.getItemMeta().getDisplayName().equalsIgnoreCase("Unranked Styles")) {
                inventories.unrankedStyles(p);
            }
        }
        e.setCancelled(true);
    }

}
