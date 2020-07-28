package zhyrapian.zhy;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FlyCommand implements CommandExecutor {

    String error = "Try /mod [Subcommand]";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            if (args.length == 0){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&l&6" + error));
            }
            else if (args[0].equals("fly")) {
                Player p = (Player) sender;
                if (p.getAllowFlight() == true) {
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l[MOD] Je bent uit de lucht geschoten!"));
                    //Speler krijgt nausea
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1, true));
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&l[MOD] Vlieg als een echte vogel!!"));
                }
            }
            //Spawnsend commando.
            else if (args[0].equals("spawn")){
                Player p = (Player) sender;
                //Controle wat de spawnlocatie is van de speler
                Location spawn = p.getBedSpawnLocation();
                if (spawn != null) {
                    //Stuur de speler naar de spawnlocatie.
                    p.teleport(spawn);
                }
                //De speler heeft geen spawnlocatie
                else sender.sendMessage("Je kan niet naar je spawnlocatie.");
            }
            //Iemand anders fly geven
            //else if (args.length == 1 && args[1].contains(Player));
        }else {
            System.out.println("[MOD] Er is een commando uitgevoerd door de console, dit is niet mogelijk.");
        }
        return false;
    }
}
