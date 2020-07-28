package zhyrapian.zhy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


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
            if (args.length == 0){
                sender.sendMessage(error);
            }
            else if (args.length == 1 && args[0].equalsIgnoreCase("fly")) {
                Player p = (Player) sender;
                if (p.getAllowFlight() == true) {
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &cJe bent uit de lucht geschoten!"));
                    //Speler krijgt nausea
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1, true));
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &2Vlieg als een echte vogel!!"));
                }
            }
            else if (args.length == 2 && args[0].equalsIgnoreCase("fly")){
                Player target = Bukkit.getServer().getPlayer(args[1]);
                if (target == null){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&9[MOD] &cSpeler &l" + args[1] + " &r&cis niet gevonden!"));
                    return true;
                }
                else {
                    if (target.getAllowFlight() == true) {
                        target.setAllowFlight(false);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &cJe bent uit de lucht geschoten!"));
                        //Speler krijgt nausea
                        target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1, true));
                    } else {
                        target.setAllowFlight(true);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&9[MOD] &2Vlieg als een echte vogel!!"));
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
            //Iemand anders fly gevenPlayer p = (Player) sender;
            //else if (args.length == 1 && args[1].contains(Player));
        }else {
            //Commando wordt uitgevoerd door de console.
            System.out.println("&l&9[MOD] Er is een commando uitgevoerd door de console, dit is niet mogelijk.");
        }
        return false;
    }
}
