package fr.sandro642.github.commands;

import fr.sandro642.github.Main;
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

                if (Main.getInstance().moderateurs.contains(player.getUniqueId())){
                    PlayerManager pm = PlayerManager.getFromPlayer(player);

                    Main.getInstance().moderateurs.remove(player.getUniqueId());
                    player.getInventory().clear();
                    player.sendMessage("§cVous n'êtes maintenant plus en mode moderation");
                    pm.giveInventory();
                    pm.destroy();
                    return false;
                }

                PlayerManager pm = new PlayerManager(player);
                pm.init();

                Main.getInstance().moderateurs.add(player.getUniqueId());
                player.sendMessage("§cVous êtes à présent en mode modération");
                pm.saveInventory();
            }
        }
        return false;
    }
}
