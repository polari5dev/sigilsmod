package xyz.polari5dev.SigilsMod.sigils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class Sigils {

    public static ItemStack create(String type) {
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();

        switch (type.toLowerCase()) {
            case "strength":
                meta.setDisplayName(ChatColor.YELLOW + "Strength Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Strength III while held."));
                break;

            case "speed":
                meta.setDisplayName(ChatColor.BLUE + "Speed Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Speed III while held."));
                break;

            case "vitality":
                meta.setDisplayName(ChatColor.RED + "Vitality Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Health Boost II while held."));
                break;

            case "luck":
                meta.setDisplayName(ChatColor.GREEN + "Luck Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Luck V while held."));
                break;

            case "haste":
                meta.setDisplayName(ChatColor.GOLD + "Haste Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Haste III while held."));
                break;

            case "mending":
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Mending Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Regeneration III while held."));
                break;

            case "poison":
                meta.setDisplayName(ChatColor.DARK_GREEN + "Poison Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Poison III while held."));
                break;

            case "molten":
                meta.setDisplayName(ChatColor.WHITE + "Molten Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Fire Resistance when held."));
                break;

            case "hardened":
                meta.setDisplayName(ChatColor.DARK_BLUE + "Hardened Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Resistance II when held."));
                break;

            case "endurance":
                meta.setDisplayName(ChatColor.DARK_PURPLE + "Endurance Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Saturation II when held."));
                break;

            case "turtle":
                meta.setDisplayName(ChatColor.DARK_AQUA + "Turtle Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Slowness IV and Resistance V when held."));
                break;

            case "concealment":
                meta.setDisplayName(ChatColor.GRAY + "Concealment Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Invisibility while held."));
                break;

            // wtf
            case "verity":
                meta.setDisplayName(ChatColor.BLACK + "Verity Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "I hate you."));
                break;

            default:
                return null;
        }

        // Store what kind of Sigil this is
        NamespacedKey key = new NamespacedKey("sigilsmod", "sigil_type");
        meta.getPersistentDataContainer().set(
                key,
                PersistentDataType.STRING,
                type.toLowerCase());

        item.setItemMeta(meta);
        return item;
    }
}