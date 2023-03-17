package fr.sandro642.github.loader;

import fr.sandro642.github.Main;
import me.itswagpvp.economyplus.vault.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.UUID;

public class GuiLoader {

    public static Double BalanceDynamic(Player p) {
        Economy eco = new Economy(p);
        Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin) Main.getInstance(), new Runnable() {
            int timer = 0;
            @Override
            public void run() {
                if (this.timer == 4) {
                    this.timer = 0;
                }
                switch (this.timer) {
                    case 0:
                        Double BalanceDynamic = eco.getBalance();
                        break;
                }
            }
        }, 0, 60L);
        return eco.getBalance();
    }

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

        ItemStack skywars = new ItemStack(Material.WHITE_WOOL);
        ItemMeta skywarsm = skywars.getItemMeta();
        skywarsm.setDisplayName("§eSkyWars §2(Clique gauche)");
        skywarsm.setLore(Arrays.asList("§eRejoindre le serveur SkyWars avec clique gauche."));
        skywars.setItemMeta(skywarsm);
        compass.setItem(21, skywars);

        ItemStack lg = new ItemStack(Material.REDSTONE);
        ItemMeta lgm = lg.getItemMeta();
        lgm.setDisplayName("§eLoup-Garou §2(Clique gauche)");
        lgm.setLore(Arrays.asList("§eRejoindre le serveur Loup-Garou avec clique gauche."));
        lg.setItemMeta(lgm);
        compass.setItem(22, lg);

        ItemStack dac = new ItemStack(Material.BARRIER);
        ItemMeta dacm = dac.getItemMeta();
        dacm.setDisplayName("§eDé à coudre §2(Clique gauche)");
        dacm.setLore(Arrays.asList("§eRejoindre le serveur Dé à coudre avec clique gauche."));
        dac.setItemMeta(dacm);
        compass.setItem(23, dac);

        ItemStack hg = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta hgm = hg.getItemMeta();
        hgm.setDisplayName("§eHungerGames §2(Clique gauche)");
        hgm.setLore(Arrays.asList("§eRejoindre le serveur HungerGames avec clique gauche."));
        hg.setItemMeta(hgm);
        compass.setItem(24, hg);





        p.updateInventory();
        p.openInventory(compass);
    }

    public static void cosmetics(Player p) {
        Inventory cosmetics = Bukkit.createInventory(null, 54, "§eMenu des cosmetiques");

        p.updateInventory();
        p.openInventory(cosmetics);
    }

    public static  void profile(Player p) {


        Inventory profile = Bukkit.createInventory(null, 54, "§eVotre Profil");

        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        headMeta.setOwner(p.getName());
        headMeta.setDisplayName("§eVous avez : §a" + BalanceDynamic(p) + "$");
        head.setItemMeta(headMeta);
        profile.setItem(22, head);

        p.updateInventory();
        p.openInventory(profile);
    }

    public static void lobbys(Player p) {
        Inventory lobbys = Bukkit.createInventory(null, 54, "§eSélecteur de lobby");

        ItemStack lobby1 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta lobby1m = lobby1.getItemMeta();
        lobby1m.setDisplayName("§eLobby 1 §2(Clique gauche)");
        lobby1m.setLore(Arrays.asList("§eRejoindre le lobby 1 avec clique gauche."));
        lobby1.setItemMeta(lobby1m);
        lobbys.setItem(0, lobby1);

        ItemStack lobby2 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta lobby2m = lobby2.getItemMeta();
        lobby2m.setDisplayName("§eLobby 2 §2(Clique gauche)");
        lobby2m.setLore(Arrays.asList("§eRejoindre le lobby 2 avec clique gauche."));
        lobby2.setItemMeta(lobby2m);
        lobbys.setItem(1, lobby2);

        ItemStack lobby3 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta lobby3m = lobby3.getItemMeta();
        lobby3m.setDisplayName("§eLobby 3 §2(Clique gauche)");
        lobby3m.setLore(Arrays.asList("§eRejoindre le lobby 3 avec clique gauche."));
        lobby3.setItemMeta(lobby3m);
        lobbys.setItem(2, lobby3);

        ItemStack lobby4 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta lobby4m = lobby4.getItemMeta();
        lobby4m.setDisplayName("§eLobby 4 §2(Clique gauche)");
        lobby4m.setLore(Arrays.asList("§eRejoindre le lobby 4 avec clique gauche."));
        lobby4.setItemMeta(lobby4m);
        lobbys.setItem(3, lobby4);

        ItemStack lobby5 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta lobby5m = lobby5.getItemMeta();
        lobby5m.setDisplayName("§eLobby 5 §2(Clique gauche)");
        lobby5m.setLore(Arrays.asList("§eRejoindre le lobby 5 avec clique gauche."));
        lobby5.setItemMeta(lobby5m);
        lobbys.setItem(4, lobby5);

        p.updateInventory();
        p.openInventory(lobbys);
    }
}
