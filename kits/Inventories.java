package me.maffew.kits;

import me.maffew.practice.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventories {

    private Main plugin;

    public Inventories(Main p) {
        this.plugin = p;
        p.inventories.add(this);
    }

    public void playerInventory(Player p) {
        Inventory inv = p.getPlayer().getInventory();

        ItemStack rankedList = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = rankedList.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bRanked Styles"));
        rankedList.setItemMeta(meta);
        inv.setItem(0, rankedList);

        ItemStack unrankedList = new ItemStack(Material.IRON_SWORD);
        ItemMeta ur = unrankedList.getItemMeta();
        ur.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bUnranked Styles"));
        inv.setItem(1, unrankedList);
    }

    public void rankedStyles(Player p) {
        ItemStack noDebuff = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = noDebuff.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bNo Debuff"));
        noDebuff.setItemMeta(meta);
        noDebuff.addEnchantment(Enchantment.FIRE_ASPECT, 1);
        plugin.rankedKitList.setItem(0, noDebuff);

        ItemStack debuff = new ItemStack(Material.IRON_SWORD);
        ItemMeta ur = debuff.getItemMeta();
        ur.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bDebuff"));
        plugin.rankedKitList.setItem(1, debuff);

        p.openInventory(plugin.rankedKitList);
    }



}
