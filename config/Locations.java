package me.maffew.config;

import me.maffew.practice.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Locations {
    public File newYML;
    public static FileConfiguration newConfig;
    private Main plugin;

    public Locations(Main p) {
        this.plugin = p;
    }

    public void saveCustomConfig() {
        try {
            newConfig.save(this.newYML);
        } catch (IOException e) {
            System.out.println("Practice : Cannot load arenas file.");
            System.out.println("Practice : Error - " + e);
        }
    }

    public static FileConfiguration getNewConfig() {
        return newConfig;
    }

    public File getNewYML() {
        return this.newYML;
    }

    public void copyDefaults() {
        InputStream defaultConfig = this.plugin.getResource("arenas.yml");
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defaultConfig);

        newConfig.setDefaults(defConfig);
        newConfig.options().copyDefaults(true);
        newConfig.options().copyDefaults();
    }

    public void reloadNewConfig()   {
        if (this.newYML == null) {
            this.newYML = new File(this.plugin.getDataFolder(), "arenas.yml");
        }
        newConfig = YamlConfiguration.loadConfiguration(this.newYML);

        InputStream defConfigStream = this.plugin.getResource("arenas.yml");
        if (defConfigStream != null)
        {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            newConfig.setDefaults(defConfig);
        }
    }

}
