package fr.sandro642.github.loader;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.UUID;

public class GuiLoader {

    public static void joinLoader(Player p) {

        UUID uuid = p.getUniqueId();

        // ItemStack
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassm = compass.getItemMeta();
        compassm.setDisplayName("§eCarte des mini-jeux §2(Clique droit)");
        compassm.setLore(Arrays.asList("§eOuvrir la carte des minijeux avec clique droit."));
        compass.setItemMeta(compassm);
        p.getInventory().setItem(4, compass);

        ItemStack cosmetics = new ItemStack(Material.CHEST);
        ItemMeta cosmeticsm = cosmetics.getItemMeta();
        cosmeticsm.setDisplayName("§eMenu des cosmetiques §2(Clique droit)");
        cosmeticsm.setLore(Arrays.asList("§eOuvrir le menu des cosmetiques avec clique droit."));
        cosmetics.setItemMeta(cosmeticsm);
        p.getInventory().setItem(0, cosmetics);

        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        headMeta.setOwner(p.getName());
        headMeta.setDisplayName("§eProfil §2(Clique droit)");
        head.setItemMeta(headMeta);
        p.getInventory().setItem(1, head);

        ItemStack lobbys = new ItemStack(Material.NETHER_STAR);
        ItemMeta lobbysm = lobbys.getItemMeta();
        lobbysm.setDisplayName("§eSélecteur de lobby §2(Clique droit)");
        lobbysm.setLore(Arrays.asList("§eOuvrez le sélecteur de lobby avec clique droit."));
        lobbys.setItemMeta(lobbysm);
        p.getInventory().setItem(8, lobbys);

        ItemStack vanish = new ItemStack(Material.GRAY_DYE);
        ItemMeta vanishm = vanish.getItemMeta();
        vanishm.setDisplayName("§eCacher les joueurs §2(Clique droit)");
        vanishm.setLore(Arrays.asList("§eCacher les joueurs en faisant clique droit."));
        vanish.setItemMeta(vanishm);
        p.getInventory().setItem(7, vanish);

        p.updateInventory();
    }

    public static void compass(Player p) {

        Inventory compass = Bukkit.createInventory(null, 54, "§eMenu des mini-jeux");



        p.updateInventory();
        p.openInventory(compass);
    }

    public static void cosmetics(Player p) {
        Inventory cosmetics = Bukkit.createInventory(null, 54, "§eMenu des cosmetiques");

        p.updateInventory();
        p.openInventory(cosmetics);
    }

    public static void profile(Player p) {
        Inventory profile = Bukkit.createInventory(null, 54, "§eVotre Profil");

        p.updateInventory();
        p.openInventory(profile);
    }

    public static void lobbys(Player p) {
        Inventory lobbys = Bukkit.createInventory(null, 54, "§eSélecteur de lobby");

        p.updateInventory();
        p.openInventory(lobbys);
    }
}
