package fr.sandro642.github.utils;

import fr.sandro642.github.Main;

import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BungeeConnect {

    public static void connect(Player p, String server) throws IOException {
        p.sendMessage("§5§l* §dAttempting connection to §l" + server + "§d...");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream out2 = new DataOutputStream(out);
        out2.writeUTF("Connect");
        out2.writeUTF(server);
        p.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
    }
}
