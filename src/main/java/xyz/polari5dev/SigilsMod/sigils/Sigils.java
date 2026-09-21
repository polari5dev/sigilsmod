package xyz.polari5dev.SigilsMod.sigils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class Sigils {

    public static ItemStack create(String type) {
        if (type == null) {
            return null;
        }

        type = type.toLowerCase();

        switch (type) {
            case "strength":
            case "speed":
            case "vitality":
            case "luck":
            case "haste":
            case "mending":
            case "poison":
            case "molten":
            case "hardened":
            case "endurance":
            case "turtle":
            case "concealment":
            case "verity":
                break;

            default:
                return null;
        }

        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();

        switch (type) {
            case "strength":
                meta.setDisplayName(ChatColor.YELLOW + "Strength Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Strength III while held."));

                meta.setItemModel(new NamespacedKey("minecraft", "strength_sigil"));
                break;

            case "speed":
                meta.setDisplayName(ChatColor.BLUE + "Speed Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Speed III while held."));

                meta.setItemModel(new NamespacedKey("minecraft", "speed_sigil"));
                break;

            case "vitality":
                meta.setDisplayName(ChatColor.RED + "Vitality Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Health Boost II while held."));

                meta.setItemModel(new NamespacedKey("minecraft", "vitality_sigil"));
                break;

            case "luck":
                meta.setDisplayName(ChatColor.GREEN + "Luck Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Luck V while held."));

                meta.setItemModel(new NamespacedKey("minecraft", "luck_sigil"));
                break;

            case "haste":
                meta.setDisplayName(ChatColor.GOLD + "Haste Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Haste III while held."));

                meta.setItemModel(new NamespacedKey("minecraft", "haste_sigil"));
                break;

            case "mending":
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Mending Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Regeneration III while held."));

                meta.setItemModel(new NamespacedKey("minecraft", "mending_sigil"));
                break;

            case "poison":
                meta.setDisplayName(ChatColor.DARK_GREEN + "Poison Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Poison III while held."));

                meta.setItemModel(new NamespacedKey("minecraft", "poison_sigil"));
                break;

            case "molten":
                meta.setDisplayName(ChatColor.WHITE + "Molten Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Fire Resistance when held."));

                meta.setItemModel(new NamespacedKey("minecraft", "molten_sigil"));
                break;

            case "hardened":
                meta.setDisplayName(ChatColor.DARK_BLUE + "Hardened Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Resistance II when held."));

                meta.setItemModel(new NamespacedKey("minecraft", "hardened_sigil"));
                break;

            case "endurance":
                meta.setDisplayName(ChatColor.DARK_PURPLE + "Endurance Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Saturation II when held."));

                meta.setItemModel(new NamespacedKey("minecraft", "endurance_sigil"));
                break;

            case "turtle":
                meta.setDisplayName(ChatColor.DARK_AQUA + "Turtle Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Slowness IV and Resistance V when held."));

                meta.setItemModel(new NamespacedKey("minecraft", "turtle_sigil"));
                break;

            case "concealment":
                meta.setDisplayName(ChatColor.GRAY + "Concealment Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Invisibility while held."));

                meta.setItemModel(new NamespacedKey("minecraft", "concealment_sigil"));
                break;

            // wtf
            case "verity":
                meta.setDisplayName(ChatColor.BLACK + "Verity Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "I hate you."));

                meta.setItemModel(new NamespacedKey("minecraft", "verity_sigil"));
                break;

            default:
                return null;
        }

        // store sigil type shit
        NamespacedKey key = new NamespacedKey("sigilsmod", "sigil_type");
        meta.getPersistentDataContainer().set(
                key,
                PersistentDataType.STRING,
                type.toLowerCase());

        item.setItemMeta(meta);
        return item;
    }
}
