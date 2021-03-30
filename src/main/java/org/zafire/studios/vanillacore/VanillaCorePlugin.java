package org.zafire.studios.vanillacore;

import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.zafire.studios.vanillacore.listener.PlayerJoinListener;
import org.zafire.studios.vanillacore.util.LocationSelector;

public final class VanillaCorePlugin extends JavaPlugin {
    private Logger logger;
    private Server server;
    private PluginManager pluginManager;
    private LocationSelector locationSelector;

    @Override
    public void onEnable() {
        setInstances();
        registerListeners();
    }

    private void setInstances() {
        logger = getLogger();
        server = getServer();
        pluginManager = server.getPluginManager();
        locationSelector = new LocationSelector(server);
        logger.info("Object instances has been set!");
    }

    private void registerListeners() {
        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        logger.info("The listeners has been registered!");
    }

    public LocationSelector getLocationSelector() {
        return locationSelector;
    }
}