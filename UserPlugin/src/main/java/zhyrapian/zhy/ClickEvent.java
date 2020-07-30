package zhyrapian.zhy;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ClickEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {

        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Moderation GUI")) {

            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);

            switch (e.getCurrentItem().getType()) {
                case PINK_BED:
                    Location spawn = p.getBedSpawnLocation();
                    if (spawn != null) {
                        //Stuur de speler naar de spawnlocatie.
                        p.teleport(spawn);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &l&dJe bent naar je spawnlocatie gestuurd!"));
                    }
                    //De speler heeft geen spawnlocatie
                    else p.sendMessage("Je kan niet naar je spawnlocatie.");
                    break;
                case FEATHER:
                    p.closeInventory();
                    if (p.getAllowFlight() == true) {
                        p.setAllowFlight(false);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &cJe bent uit de lucht geschoten!"));
                        //Speler krijgt nausea
                        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1, true));
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &2Vlieg als een echte vogel!!"));
                        ItemStack fly = new ItemStack(Material.LEATHER);
                    }

                    break;
                case RED_STAINED_GLASS_PANE:
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &dBezig met het sluiten van de Moderation GUI..."));
                    break;

                case PLAYER_HEAD:
                    if (p.getGameMode().equals(GameMode.SPECTATOR)) {
                        //Je gamemode is spectator, dus je wordt naar gamemode survival gezet.
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &l&dSpectator modus gedeactiveerd!"));
                    } else {
                        //Je gamemode is survival, dus je wordt naar gamemode spectator gezet.
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &l&dSpectator modus geactiveerd!"));

                        break;
                    }
            }
        }
    }
}
