package fr.sandro642.github;

import fr.sandro642.github.commands.Guicmd;
import fr.sandro642.github.events.LoaderEvent;
import fr.sandro642.github.utils.PlayerManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {

    private static Main instance;

    public HashMap<UUID, PlayerManager> players = new HashMap<>();
    public ArrayList<UUID> moderateurs = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;

        System.out.println("Plugin MenuGui activé.");
        // Plugin

        getServer().getPluginManager().registerEvents(new LoaderEvent(), this);
        getCommand("guibypass").setExecutor(new Guicmd());

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel((Plugin) this, "BungeeCord", (PluginMessageListener) new LoaderEvent());
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin MenuGui désactivé.");
    }
}