package zhyrapian.zhy;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
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
        EmeraldChest_lore.add(ChatColor.translateAlternateColorCodes('&',"&e&o 'A chestplate made for real warriors.'"));
        EmeraldChest_lore.add(ChatColor.translateAlternateColorCodes('&',"&6&o Unbreakable"));
        EmeraldChest_Meta.setLore(EmeraldChest_lore);
        EmeraldChest_Meta.addEnchant(Enchantment.THORNS,3,true);
        EmeraldChest_Meta.setUnbreakable(true);
        EmeraldChest_Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        EmeraldChest_Meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EmeraldChest.setItemMeta(EmeraldChest_Meta);

        //Aanmaken van het Recipe van Emerald Chestplate
        ShapedRecipe EmeraldChest_Recipe = new ShapedRecipe(EmeraldChest);
        EmeraldChest_Recipe.shape("E E", "EEE", "EEE");
        EmeraldChest_Recipe.setIngredient('E', Material.EMERALD_BLOCK);

        plugin.getServer().addRecipe(EmeraldChest_Recipe);

        //-------------------------------------------------------------------------

        //Emerald Leggings
        ItemStack EmeraldLeggs = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta EmeraldLeggs_Meta = EmeraldLeggs.getItemMeta();

        //Custom Item maken
        EmeraldLeggs_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&2E&amerald &2L&aeggings"));
        ArrayList<String>EmeraldLeggs_lore = new ArrayList<String>();
        EmeraldLeggs_lore.add(ChatColor.translateAlternateColorCodes('&',"&e&o 'Leggings made for real warriors.'"));
        EmeraldLeggs_lore.add(ChatColor.translateAlternateColorCodes('&',"&6&o Unbreakable"));
        EmeraldLeggs_Meta.setLore(EmeraldLeggs_lore);
        EmeraldLeggs_Meta.addEnchant(Enchantment.THORNS,3,true);
        EmeraldLeggs_Meta.setUnbreakable(true);
        EmeraldLeggs_Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        EmeraldLeggs_Meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        EmeraldLeggs.setItemMeta(EmeraldLeggs_Meta);

        //Aanmaken van het Recipe van Emerald Leggings
        ShapedRecipe EmeraldLeggs_Recipe = new ShapedRecipe(EmeraldLeggs);
        EmeraldLeggs_Recipe.shape("EEE", "E E", "E E");
        EmeraldLeggs_Recipe.setIngredient('E', Material.EMERALD_BLOCK);

        plugin.getServer().addRecipe(EmeraldLeggs_Recipe);

        //-------------------------------------------------------------------------

        //Iron Chestplate omsmelten
        ItemStack IronChest = new ItemStack(Material.IRON_INGOT, 7);

        FurnaceRecipe IronChestplate = new FurnaceRecipe(IronChest, Material.IRON_CHESTPLATE);
        IronChestplate.setCookingTime(2000);
        IronChestplate.setExperience(150);

        plugin.getServer().addRecipe(IronChestplate);

        //-------------------------------------------------------------------------

        //Iron Leggings omsmelten
        ItemStack IronLegg = new ItemStack(Material.IRON_INGOT, 6);

        FurnaceRecipe IronLegging = new FurnaceRecipe(IronLegg, Material.IRON_LEGGINGS);
        IronChestplate.setCookingTime(2000);
        IronChestplate.setExperience(150);

        plugin.getServer().addRecipe(IronLegging);

        //-------------------------------------------------------------------------

        //Iron Helmet omsmelten
        ItemStack IronHelm = new ItemStack(Material.IRON_INGOT, 4);

        FurnaceRecipe IronHelmet = new FurnaceRecipe(IronHelm, Material.IRON_HELMET);
        IronChestplate.setCookingTime(2000);
        IronChestplate.setExperience(150);

        plugin.getServer().addRecipe(IronHelmet);

        //-------------------------------------------------------------------------

        //Iron Helmet omsmelten
        ItemStack IronBoots = new ItemStack(Material.IRON_INGOT, 3);

        FurnaceRecipe IronBoot = new FurnaceRecipe(IronBoots, Material.IRON_BOOTS);
        IronChestplate.setCookingTime(2000);
        IronChestplate.setExperience(150);

        plugin.getServer().addRecipe(IronBoot);

        //-------------------------------------------------------------------------

        //Iron Helmet omsmelten
        ItemStack Steak = new ItemStack(Material.ROTTEN_FLESH, 1);

        FurnaceRecipe Beef = new FurnaceRecipe(Steak, Material.LEGACY_RAW_BEEF);
        Beef.setCookingTime(500);
        Beef.setExperience(75);

        plugin.getServer().addRecipe(Beef);
    }
}
