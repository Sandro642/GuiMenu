package fr.sandro642.github.events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.sandro642.github.Main;
import fr.sandro642.github.loader.GuiLoader;
import fr.sandro642.github.utils.BungeeConnect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getServer;

public class LoaderEvent implements Listener {

    private boolean playersHidden = false;

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


        if (Main.getInstance().moderateurs.contains(p.getUniqueId())) {
            Main.getInstance().moderateurs.remove(p.getUniqueId());
        }
    }


    @EventHandler
    public void dropItem(PlayerDropItemEvent e) {
        Player p = e.getPlayer();

        if (Main.getInstance().moderateurs.contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if (Main.getInstance().moderateurs.contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onTake(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();

        if (Main.getInstance().moderateurs.contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnPick(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (Main.getInstance().moderateurs.contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack it = e.getItem();
        Action a = e.getAction();

        if (it == null) return;
        if (it.getType() == Material.COMPASS && it.getItemMeta().getDisplayName().equals("§eCarte des mini-jeux §2(Clique droit)")) {
            if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                GuiLoader.compass(p);
            }
        }

        if (it.getType() == Material.CHEST && it.getItemMeta().getDisplayName().equals("§eMenu des cosmetiques §2(Clique droit)")) {
            if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                GuiLoader.cosmetics(p);
            }
        }

        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equals("§eSélecteur de lobby §2(Clique droit)")) {
            if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                GuiLoader.lobbys(p);
            }
        }

        if (it.getType() == Material.GRAY_DYE && it.getItemMeta().getDisplayName().equals("§eCacher les joueurs §2(Clique droit)")) {
            if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);

            }
        }

        if (it.getType() == Material.PLAYER_HEAD && it.getItemMeta().getDisplayName().equals("§eProfil §2(Clique droit)")) {
            if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                GuiLoader.profile(p);
            }
        }
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack it = e.getCurrentItem();

        if (it == null) return;

        if (it.getType() == Material.WHITE_WOOL && it.getItemMeta().getDisplayName().equals("§eSkyWars §2(Clique droit")) {
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            p.closeInventory();
            BungeeConnect.connect(p, "sw1");
        }
        if( it.getType() == Material.REDSTONE && it.getItemMeta().getDisplayName().equals("§eLoup-Garou §2(Clique droit)")) {
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            p.closeInventory();
            BungeeConnect.connect(p, "lg1");
        }
    }

}


