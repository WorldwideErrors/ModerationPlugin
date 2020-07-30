package zhyrapian.zhy;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.UUID;


public class FlyCommand implements CommandExecutor {

    String error =  ChatColor.DARK_BLUE +
                    "-----------------------------------------------------" + '\n' + ChatColor.BLUE +
                    "[MOD] " + ChatColor.WHITE + "Bedoel je een van de onderstaande commands?" + '\n' + ChatColor.DARK_BLUE +
                    "-----------------------------------------------------" + '\n' + ChatColor.GOLD +
                    "/mod fly - " + ChatColor.WHITE + "Hiermee kan je jezelf of een andere speler fly geven" + '\n' + ChatColor.GOLD +
                    "/mod spawn [speler] - " + ChatColor.WHITE + "Hiermee kan je jezelf of een andere speler naar spawn sturen";



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            //geen subcommando
            if (args.length == 0){
                Player p = (Player) sender;

                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &eBezig met het openen van de Moderation GUI..."));
                Inventory gui = Bukkit.createInventory(p, 54, ChatColor.BLUE + "Moderation GUI");

                ItemStack suicide = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemStack air = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
                ItemStack underline = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemStack fly = new ItemStack(Material.FEATHER);
                ItemStack spawn = new ItemStack(Material.PINK_BED);
                ItemStack spectator = new ItemStack(Material.SNOWBALL);
                ItemStack vision = new ItemStack(Material.GLOWSTONE_DUST);
                ItemStack team = new ItemStack(Material.WHITE_WOOL);
                ItemStack playerdata = new ItemStack(Material.PLAYER_HEAD,1,(byte) 3);

                if (p.getAllowFlight() == true){
                    fly.setType(Material.GRASS_BLOCK);

                }else if (p.getAllowFlight() == false){
                    fly.setType(Material.FEATHER);
                }

                ItemMeta suicide_meta = suicide.getItemMeta();
                suicide_meta.setDisplayName(ChatColor.RED + "Close");
                ArrayList<String> suicide_lore = new ArrayList<>();
                suicide_lore.add(ChatColor.WHITE + "Sluit het menu");
                suicide_meta.setLore(suicide_lore);
                suicide.setItemMeta(suicide_meta);

                ItemMeta air_meta = air.getItemMeta();
                air_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8&klol"));
                air.setItemMeta(air_meta);

                ItemMeta underline_meta = underline.getItemMeta();
                underline_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8&klol"));
                underline.setItemMeta(underline_meta);

                ItemMeta fly_meta = fly.getItemMeta();
                fly_meta.setDisplayName(ChatColor.GOLD + "Fly");
                ArrayList<String> fly_lore = new ArrayList<>();
                fly_lore.add(ChatColor.WHITE + "Geef jezelf fly");
                fly_meta.setLore(fly_lore);
                fly.setItemMeta(fly_meta);

                ItemMeta spawn_meta = spawn.getItemMeta();
                spawn_meta.setDisplayName(ChatColor.GOLD + "Spawn");
                ArrayList<String> spawn_lore = new ArrayList<>();
                spawn_lore.add(ChatColor.WHITE + "Ga naar spawn");
                spawn_meta.setLore(spawn_lore);
                spawn.setItemMeta(spawn_meta);

                ItemMeta spectator_meta = spectator.getItemMeta();
                spectator_meta.setDisplayName(ChatColor.GOLD + "Spectator Modus");
                ArrayList<String> spectator_lore = new ArrayList<>();
                spectator_lore.add(ChatColor.WHITE + "Ga in spectator modus");
                spectator_meta.setLore(spectator_lore);
                spectator.setItemMeta(spectator_meta);

                ItemMeta vision_meta = vision.getItemMeta();
                vision_meta.setDisplayName(ChatColor.GOLD + "Nightvision");
                ArrayList<String> vision_lore = new ArrayList<>();
                vision_lore.add(ChatColor.WHITE + "Ga in nightvision modus");
                vision_meta.setLore(vision_lore);
                vision.setItemMeta(vision_meta);

                ItemMeta team_meta = team.getItemMeta();
                vision_meta.setDisplayName(ChatColor.GOLD + "Team");
                ArrayList<String> team_lore = new ArrayList<>();
                team_lore.add(ChatColor.WHITE + "Kies in welk team jij wil");
                team_meta.setLore(team_lore);
                team.setItemMeta(team_meta);

                SkullMeta playerdata_meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);
                playerdata_meta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString(String.valueOf(p.getUniqueId()))));
                playerdata_meta.setDisplayName(ChatColor.GOLD + p.getPlayerListName());
                ArrayList<String> playerdata_lore = new ArrayList<>();
                playerdata_lore.add(ChatColor.YELLOW + "Level: " + ChatColor.WHITE + " " + p.getLevel());
                playerdata_lore.add(" ");
                playerdata_lore.add(ChatColor.YELLOW + "Health: " + ChatColor.WHITE + " " + p.getHealth());
                playerdata_lore.add(ChatColor.YELLOW + "Food: " + ChatColor.WHITE + " " + p.getFoodLevel());
                playerdata_meta.setLore(playerdata_lore);
                playerdata.setItemMeta(playerdata_meta);

                ItemStack[] menu_items = {
            air, air, air, air, air, air, air, air, air,
            air, fly, air, air, spawn, air, air, spectator, air,
            air, air, air, air, air, air, air, air, air,
            air, vision, air, air, team, air, air, playerdata, air,
            air, air, air, air, air, air, air, air, air,
            underline, underline, underline, underline, suicide, underline, underline, underline, underline,
    };
    gui.setContents(menu_items);

    p.openInventory(gui);

            }
            //Jezelf fly geven
            else if (args.length == 1 && args[0].equalsIgnoreCase("fly")) {
                Player p = (Player) sender;
                if (p.getAllowFlight() == true && !p.getGameMode().equals(GameMode.SPECTATOR)) {
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &cJe bent uit de lucht geschoten!"));
                    //Speler krijgt nausea
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1, true));
                }else if (p.getAllowFlight() == false && !p.getGameMode().equals(GameMode.SPECTATOR)){
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &2Vlieg als een echte vogel!!"));
                    ItemStack fly = new ItemStack(Material.LEATHER);
                }
                else {
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &cJe kan niet uit fly worden gehaald in gamemode Spectator!!"));

                }
            }
            //Iemand anders fly geven
            else if (args.length == 2 && args[0].equalsIgnoreCase("fly")){
                Player target = Bukkit.getServer().getPlayer(args[1]);
                if (target == null){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &eSpeler &l&6" + args[1] + " &r&eis niet gevonden!"));
                    return true;
                }
                else {
                    if (target.getAllowFlight() == true && !target.getGameMode().equals(GameMode.SPECTATOR)) {
                        target.setAllowFlight(false);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &dJe bent uit de lucht geschoten!"));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &l&e" + target.getName() + " is uit flymodus gehaald!"));
                        //Speler krijgt nausea
                        target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1, true));
                    } else if (target.getAllowFlight() == false && !target.getGameMode().equals(GameMode.SPECTATOR)){
                        target.setAllowFlight(true);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &dVlieg als een echte vogel!!"));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &l&e" + target.getName() + " is in flymodus gezet.!"));
                    }else {
                        target.setAllowFlight(true);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &cJe kan niet uit fly worden gehaald in gamemode Spectator!"));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &c" + target.getName() + " kon niet uit flymodus gehaald worden!"));
                    }
                }
            }
            //Spawnsend commando.
            else if (args.length == 1 && args[0].equalsIgnoreCase("spawn")){
                Player p = (Player) sender;
                //Controle wat de spawnlocatie is van de speler
                Location spawn = p.getBedSpawnLocation();
                if (spawn != null) {
                    //Stuur de speler naar de spawnlocatie.
                    p.teleport(spawn);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &l&dJe bent naar je spawnlocatie gestuurd!"));
                }
                //De speler heeft geen spawnlocatie
                else p.sendMessage("Je kan niet naar je spawnlocatie.");
            }
            else if (args.length == 2 && args[0].equalsIgnoreCase("spawn")){
            Player target = Bukkit.getServer().getPlayer(args[1]);
                if (target == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &cSpeler &l" + args[1] + " &r&cis niet gevonden!"));
                    return true;
                }
                Location Spawnlocation = target.getBedSpawnLocation();
                target.teleport(Spawnlocation);
                target.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &l&dJe bent naar je spawnlocatie gestuurd!"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &l&e" + target.getName() + " is naar zijn spawnlocatie gestuurd!"));
            }
            //Jezelf in spectator modus of survival zetten.
            else if (args.length == 1 && args[0].equalsIgnoreCase("spectator")){
                Player p = (Player) sender;
                if (p.getGameMode().equals(GameMode.SPECTATOR)){
                    //Je gamemode is spectator, dus je wordt naar gamemode survival gezet.
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &l&dSpectator modus gedeactiveerd!"));
                }else {
                    //Je gamemode is survival, dus je wordt naar gamemode spectator gezet.
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &l&dSpectator modus geactiveerd!"));
                    return true;
                }
            }
            else {
                sender.sendMessage(error);
            }
            //}
        }else {
            //Commando wordt uitgevoerd door de console.
            System.out.println("&l&9[MOD] Er is een commando uitgevoerd door de console, dit is niet mogelijk.");
        }
        return false;
    }
}
