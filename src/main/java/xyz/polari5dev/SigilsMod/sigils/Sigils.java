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
                meta.setDisplayName(ChatColor.RED + "Strength Sigil");
                meta.setLore(java.util.List.of(
                        ChatColor.GRAY + "Grants Strength III."));
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