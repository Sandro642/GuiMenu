package fr.sandro642.github.commands;

import fr.sandro642.github.Main;
import fr.sandro642.github.loader.GuiLoader;
import fr.sandro642.github.utils.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Guicmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (label.equalsIgnoreCase("guibypass")){
                if (!player.hasPermission("guibypass")){
                    player.sendMessage("§cVous n'avez pas la permission d'éxecuter la commande");
                    return false;
                }

                if (player.getInventory().isEmpty()) {
                    player.sendMessage("§cVous avez désactivé le bypass du menu gui.");
                    GuiLoader.joinLoader(player);
                    return false;
                } else if (!player.getInventory().isEmpty()) {
                    player.sendMessage("§aVous avez activé le bypass du menu gui.");
                    player.getInventory().clear();
                    return false;
                }

            }
        }
        return false;
    }
}
