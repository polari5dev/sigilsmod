package xyz.polari5dev.SigilsMod.listeners;

import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Handle player join event

    }

    private final JavaPlugin plugin;
    private final NamespacedKey sigilKey;

    public PlayerListener(JavaPlugin plugin) {
        this.plugin = plugin;
        this.sigilKey = new NamespacedKey(plugin, "sigil_type");

        startSigilTask();
    }

    private void startSigilTask() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {

            for (Player player : Bukkit.getOnlinePlayers()) {

                boolean hasStrengthSigil = false;

                for (ItemStack item : player.getInventory().getContents()) {

                    if (item == null || !item.hasItemMeta()) {
                        continue;
                    }

                    String type = item.getItemMeta()
                            .getPersistentDataContainer()
                            .get(sigilKey, PersistentDataType.STRING);

                    if ("strength".equals(type)) {
                        hasStrengthSigil = true;
                        break;
                    }
                }

                if (hasStrengthSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.STRENGTH,
                                    40,
                                    2,
                                    false,
                                    false,
                                    true));
                }
            }

        }, 0L, 20L);
    }

}
