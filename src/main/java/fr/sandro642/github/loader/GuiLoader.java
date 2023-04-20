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

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
        vanishm.setDisplayName("§eVanish §2(Clique droit)");
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
        compass.setItem(20, skywars);

        ItemStack lg = new ItemStack(Material.REDSTONE);
        ItemMeta lgm = lg.getItemMeta();
        lgm.setDisplayName("§eLoup-Garou §2(Clique gauche)");
        lgm.setLore(Arrays.asList("§eRejoindre le serveur Loup-Garou avec clique gauche."));
        lg.setItemMeta(lgm);
        compass.setItem(21, lg);

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
    public static void connect(Player p, String server) throws IOException {
        p.sendMessage("§5§l* §dAttempting connection to §l" + server + "§d...");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream out2 = new DataOutputStream(out);
        out2.writeUTF("Connect");
        out2.writeUTF(server);
        p.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
    }
    public static void profile(Player p) {


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


    /// Loader of gui for Little Games.

    public static void skywarsloader(Player p) {
        Inventory skywars = Bukkit.createInventory(null, 54, "§eSkyWars");

        ItemStack skywars1 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta skywars1m = skywars1.getItemMeta();
        skywars1m.setDisplayName("§eSkyWars 1 §2(Clique gauche)");
        skywars1m.setLore(Arrays.asList("§eRejoindre le serveur SkyWars 1 avec clique gauche."));
        skywars1.setItemMeta(skywars1m);
        skywars.setItem(0, skywars1);

        ItemStack skywars2 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta skywars2m = skywars2.getItemMeta();
        skywars2m.setDisplayName("§eSkyWars 2 §2(Clique gauche)");
        skywars2m.setLore(Arrays.asList("§eRejoindre le serveur SkyWars 2 avec clique gauche."));
        skywars2.setItemMeta(skywars2m);
        skywars.setItem(1, skywars2);

        ItemStack skywars3 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta skywars3m = skywars3.getItemMeta();
        skywars3m.setDisplayName("§eSkyWars 3 §2(Clique gauche)");
        skywars3m.setLore(Arrays.asList("§eRejoindre le serveur SkyWars 3 avec clique gauche."));
        skywars3.setItemMeta(skywars3m);
        skywars.setItem(2, skywars3);

        ItemStack skywars4 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta skywars4m = skywars4.getItemMeta();
        skywars4m.setDisplayName("§eSkyWars 4 §2(Clique gauche)");
        skywars4m.setLore(Arrays.asList("§eRejoindre le serveur SkyWars 4 avec clique gauche."));
        skywars4.setItemMeta(skywars4m);
        skywars.setItem(3, skywars4);

        p.openInventory(skywars);
    }

    public static void hungergamesloader(Player p) {
        Inventory hungergames = Bukkit.createInventory(null, 54, "§eHungerGames");

        ItemStack hungergames1 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta hungergames1m = hungergames1.getItemMeta();
        hungergames1m.setDisplayName("§eHungerGames 1 §2(Clique gauche)");
        hungergames1m.setLore(Arrays.asList("§eRejoindre le serveur HungerGames 1 avec clique gauche."));
        hungergames1.setItemMeta(hungergames1m);
        hungergames.setItem(0, hungergames1);

        ItemStack hungergames2 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta hungergames2m = hungergames2.getItemMeta();
        hungergames2m.setDisplayName("§eHungerGames 2 §2(Clique gauche)");
        hungergames2m.setLore(Arrays.asList("§eRejoindre le serveur HungerGames 2 avec clique gauche."));
        hungergames2.setItemMeta(hungergames2m);
        hungergames.setItem(1, hungergames2);

        ItemStack hungergames3 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta hungergames3m = hungergames3.getItemMeta();
        hungergames3m.setDisplayName("§eHungerGames 3 §2(Clique gauche)");
        hungergames3m.setLore(Arrays.asList("§eRejoindre le serveur HungerGames 3 avec clique gauche."));
        hungergames3.setItemMeta(hungergames3m);
        hungergames.setItem(2, hungergames3);

        ItemStack hungergames4 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta hungergames4m = hungergames4.getItemMeta();
        hungergames4m.setDisplayName("§eHungerGames 4 §2(Clique gauche)");
        hungergames4m.setLore(Arrays.asList("§eRejoindre le serveur HungerGames 4 avec clique gauche."));
        hungergames4.setItemMeta(hungergames4m);
        hungergames.setItem(3, hungergames4);

        p.openInventory(hungergames);
    }

    public static void loupgarouloader(Player p) {
        Inventory loupgarou = Bukkit.createInventory(null, 54, "§eLoupGarou");

        ItemStack loupgarou1 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta loupgarou1m = loupgarou1.getItemMeta();
        loupgarou1m.setDisplayName("§eLoupGarou 1 §2(Clique gauche)");
        loupgarou1m.setLore(Arrays.asList("§eRejoindre le serveur LoupGarou 1 avec clique gauche."));
        loupgarou1.setItemMeta(loupgarou1m);
        loupgarou.setItem(0, loupgarou1);

        ItemStack loupgarou2 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta loupgarou2m = loupgarou2.getItemMeta();
        loupgarou2m.setDisplayName("§eLoupGarou 2 §2(Clique gauche)");
        loupgarou2m.setLore(Arrays.asList("§eRejoindre le serveur LoupGarou 2 avec clique gauche."));
        loupgarou2.setItemMeta(loupgarou2m);
        loupgarou.setItem(1, loupgarou2);

        ItemStack loupgarou3 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta loupgarou3m = loupgarou3.getItemMeta();
        loupgarou3m.setDisplayName("§eLoupGarou 3 §2(Clique gauche)");
        loupgarou3m.setLore(Arrays.asList("§eRejoindre le serveur LoupGarou 3 avec clique gauche."));
        loupgarou3.setItemMeta(loupgarou3m);
        loupgarou.setItem(2, loupgarou3);

        ItemStack loupgarou4 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta loupgarou4m = loupgarou4.getItemMeta();
        loupgarou4m.setDisplayName("§eLoupGarou 4 §2(Clique gauche)");
        loupgarou4m.setLore(Arrays.asList("§eRejoindre le serveur LoupGarou 4 avec clique gauche."));
        loupgarou4.setItemMeta(loupgarou4m);
        loupgarou.setItem(3, loupgarou4);

        p.openInventory(loupgarou);
    }

    public static void deacoudreloader(Player p) {
        Inventory deacoudre = Bukkit.createInventory(null, 54, "§eDeACoudre");

        ItemStack deacoudre1 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta deacoudre1m = deacoudre1.getItemMeta();
        deacoudre1m.setDisplayName("§eDeACoudre 1 §2(Clique gauche)");
        deacoudre1m.setLore(Arrays.asList("§eRejoindre le serveur DeACoudre 1 avec clique gauche."));
        deacoudre1.setItemMeta(deacoudre1m);
        deacoudre.setItem(0, deacoudre1);

        ItemStack deacoudre2 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta deacoudre2m = deacoudre2.getItemMeta();
        deacoudre2m.setDisplayName("§eDeACoudre 2 §2(Clique gauche)");
        deacoudre2m.setLore(Arrays.asList("§eRejoindre le serveur DeACoudre 2 avec clique gauche."));
        deacoudre2.setItemMeta(deacoudre2m);
        deacoudre.setItem(1, deacoudre2);

        ItemStack deacoudre3 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta deacoudre3m = deacoudre3.getItemMeta();
        deacoudre3m.setDisplayName("§eDeACoudre 3 §2(Clique gauche)");
        deacoudre3m.setLore(Arrays.asList("§eRejoindre le serveur DeACoudre 3 avec clique gauche."));
        deacoudre3.setItemMeta(deacoudre3m);
        deacoudre.setItem(2, deacoudre3);

        ItemStack deacoudre4 = new ItemStack(Material.WHITE_WOOL);
        ItemMeta deacoudre4m = deacoudre4.getItemMeta();
        deacoudre4m.setDisplayName("§eDeACoudre 4 §2(Clique gauche)");
        deacoudre4m.setLore(Arrays.asList("§eRejoindre le serveur DeACoudre 4 avec clique gauche."));
        deacoudre4.setItemMeta(deacoudre4m);
        deacoudre.setItem(3, deacoudre4);



        p.openInventory(deacoudre);
    }
}