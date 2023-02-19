package fr.sandro642.github.events;

import fr.sandro642.github.Main;
import fr.sandro642.github.loader.GuiLoader;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

public class LoaderEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        GuiLoader.joinLoader(p);

        if (!p.hasPermission("guibypass")) {

        } else {
            p.sendMessage("§aTu peux utiliser la commande /guibypass pour désactiver le menu gui et inversement.");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        p.getInventory().clear();


        if(Main.getInstance().moderateurs.contains(p.getUniqueId())){
            Main.getInstance().moderateurs.remove(p.getUniqueId());
        }
    }



     @EventHandler
    public void dropItem(PlayerDropItemEvent e) {
        Player p = e.getPlayer();

         if (Main.getInstance().moderateurs.contains(p.getUniqueId())){
             e.setCancelled(false);
         } else {
             e.setCancelled(true);
         }
     }

     @EventHandler
     public void onBreak(BlockBreakEvent e) {
         Player p = e.getPlayer();

         if (Main.getInstance().moderateurs.contains(p.getUniqueId())){
             e.setCancelled(false);
         } else {
             e.setCancelled(true);
         }
     }

     @EventHandler
     public void onTake(PlayerPickupItemEvent e) {
         Player p = e.getPlayer();

         if (Main.getInstance().moderateurs.contains(p.getUniqueId())){
             e.setCancelled(false);
         } else {
             e.setCancelled(true);
         }
     }

     @EventHandler
    public void onInteract(PlayerInteractEvent e) {
         // Code of HashMap
         Player p = e.getPlayer();
         Action action = e.getAction();
         ItemStack it = e.getItem();

         if (Main.getInstance().moderateurs.contains(p.getUniqueId())) {
             e.setCancelled(false);
         } else {
             e.setCancelled(true);

             if ()
         }
     }
}
