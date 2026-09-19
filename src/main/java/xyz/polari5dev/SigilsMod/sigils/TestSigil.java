package xyz.polari5dev.SigilsMod.sigils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class TestSigil {
    public ItemStack createStrengthSigil() {
        ItemStack item = new ItemStack(Material.NETHER_STAR);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§cStrength Sigil");
        meta.setLore(List.of(
                "§7Grants Strength III.",
                "§8A unique Sigil."));

        item.setItemMeta(meta);

        return item;
    }
}
// §