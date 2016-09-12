package me.maffew.practice;

import me.maffew.commands.Duel;
import me.maffew.commands.Help;
import me.maffew.commands.SetSpawn;
import me.maffew.commands.Spawn;
import me.maffew.config.Locations;
import me.maffew.kits.Inventories;
import me.maffew.listeners.Interact;
import me.maffew.listeners.Join;
import me.maffew.queue.Queue;
import me.maffew.utils.ExcessCmds;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public Plugin plugin;
    MySQL sql;
    private Locations loc;
    private ExcessCmds utils;
    private Queue main_queue;
    private Inventories inv;
    public FileConfiguration config;
    public FileConfiguration arenas;
    private PluginDescriptionFile pluginDescFile;
    public ArrayList<Queue> queue = new ArrayList();
    public List<String> allArenas = new ArrayList();
    public ArrayList<Inventories> inventories = new ArrayList();
    public ArrayList<UUID> inGame = new ArrayList<UUID>();
    public Inventory unrankedKitList = Bukkit.createInventory(null, 9, "Unranked Styles");
    public Inventory rankedKitList = Bukkit.createInventory(null, 9, "Ranked Styles");
    Connection conn = DriverManager.getConnection("jdbc:mysql://" + this.plugin.getConfig().getString("MySQL.hostname") + "/" + this.plugin.getConfig().getString("MySQL.database"), this.plugin.getConfig().getString("MySQL.username"), this.plugin.getConfig().getString("MySQL.password"));

    public Main(Locations locations) throws SQLException {
    }

    @Override
    public void onEnable() {
        System.out.println("Practice : Enabled");
        pluginDescFile = getDescription();
        arenas = Locations.getNewConfig();
        config = getConfig();
        saveDefaultConfig();
        plugin = this;
        loadConfigs();
        registerCommands();
        registerListeners();
        loadClasses();

        if(config.getBoolean("MySQL.enabled")) {
            this.sql.openConnection();
            if(this.sql.con != null) {
                this.sql.createTable();
            }
        }
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    public void onDisable() {
        System.out.println("Practice : Disabled");

    }

    private void loadConfigs() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        this.loc.newYML = new File(getDataFolder(), "arenas.yml");
        Locations.newConfig = YamlConfiguration.loadConfiguration(this.loc.newYML);
    }

    public void loadClasses() {
        this.loc = new Locations(this);
    }

    private void registerCommands() {
        getCommand("help").setExecutor(new Help(this, utils));
        getCommand("duel").setExecutor(new Duel(this, main_queue));
        getCommand("accept").setExecutor(new Duel(this, main_queue));
        getCommand("deny").setExecutor(new Duel(this, main_queue));
        getCommand("spawn").setExecutor(new Spawn(this));
        getCommand("setspawn").setExecutor(new SetSpawn(this));
    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        //pm.registerEvents(new Interact(this), this);
        pm.registerEvents(new Join(this, inv), this);
    }

    public FileConfiguration config() {
        return this.config;
    }

    public String getVersion() {
        return pluginDescFile.getVersion();
    }

    public String getAuthor() {
        return pluginDescFile.getAuthors().get(0);
    }

}
