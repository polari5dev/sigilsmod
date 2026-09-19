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