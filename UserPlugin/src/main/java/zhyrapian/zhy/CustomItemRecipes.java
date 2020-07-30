package zhyrapian.zhy;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class CustomItemRecipes implements Listener {
    public Plugin plugin = UserPlugin.getPlugin(UserPlugin.class);
    public void customRecipe(){
        //Emerald Chestplate
        ItemStack EmeraldChest = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta EmeraldChest_Meta = EmeraldChest.getItemMeta();

        //Custom Item maken
        EmeraldChest_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&2E&amerald &2C&ahestplate"));
        ArrayList<String> EmeraldChest_lore = new ArrayList<String>();
        EmeraldChest_lore.add(ChatColor.translateAlternateColorCodes('&',"&e&o'A chestplate made for real warriors.'"));
        EmeraldChest_Meta.setLore(EmeraldChest_lore);
        EmeraldChest_Meta.addEnchant(Enchantment.THORNS,3,true);
        EmeraldChest_Meta.setUnbreakable(true);
        EmeraldChest_Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        EmeraldChest.setItemMeta(EmeraldChest_Meta);

        //Aanmaken van het Recipe van Emerald Chestplate
        ShapedRecipe EmeraldChest_Recipe = new ShapedRecipe(EmeraldChest);
        EmeraldChest_Recipe.shape("E E", "EEE", "EEE");
        EmeraldChest_Recipe.setIngredient('E', Material.EMERALD_BLOCK);

        plugin.getServer().addRecipe(EmeraldChest_Recipe);
    }
}
