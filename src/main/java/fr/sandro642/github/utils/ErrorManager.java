package fr.sandro642.github.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ErrorManager {

    public static String ErrorLobbys(Player p) {
        Bukkit.getConsoleSender().sendMessage("§cVous ne pouvez pas vous connecter à un lobby car il sont en maintenance!");
        return null;
    }
}
