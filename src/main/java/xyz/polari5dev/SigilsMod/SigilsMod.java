package xyz.polari5dev.SigilsMod;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.polari5dev.SigilsMod.managers.PluginManager;
import xyz.polari5dev.SigilsMod.commands.SigilCommand;
import xyz.polari5dev.SigilsMod.listeners.PlayerListener;

public class SigilsMod extends JavaPlugin {

    @Override
    public void onEnable() {

        // Initialize managers
        PluginManager.getInstance().initialize();

        // Register listeners
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        getLogger().info(getDescription().getName() + " has been enabled! Hello, User!");

        this.registerCommand("sigil", new SigilCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled! Goodbye!");
    }

}
