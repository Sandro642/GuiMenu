package fr.sandro642.github.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.sandro642.github.Main;
import fr.sandro642.github.loader.GuiLoader;
import org.bukkit.entity.Player;

public class BungeeConnect {

    public static void connect(Player p, String server) {
        p.sendMessage("§5§l* §dAttempting connection to §l" + server + "§d...");
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        p.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
    }
}
