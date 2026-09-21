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
                boolean hasSpeedSigil = false;
                boolean hasVitalitySigil = false;
                boolean hasLuckSigil = false;
                boolean hasHasteSigil = false;
                boolean hasMendingSigil = false;
                boolean hasPoisonSigil = false;
                boolean hasMoltenSigil = false;
                boolean hasHardenedSigil = false;
                boolean hasEnduranceSigil = false;
                boolean hasTurtleSigil = false;
                boolean hasConcealmentSigil = false;

                boolean hasVeritySigil = false;

                for (ItemStack item : player.getInventory().getContents()) {

                    if (item == null || !item.hasItemMeta()) {
                        continue;
                    }

                    String type = item.getItemMeta()
                            .getPersistentDataContainer()
                            .get(sigilKey, PersistentDataType.STRING);

                    // test for bug.........
                    // Bukkit.getLogger().info("SIGIL TYPE: " + type);

                    if (type == null) {
                       continue;
                    }

                    switch (type) {
                        case "strength" -> hasStrengthSigil = true;
                        case "speed" -> hasSpeedSigil = true;
                        case "vitality" -> hasVitalitySigil = true;
                        case "luck" -> hasLuckSigil = true;
                        case "haste" -> hasHasteSigil = true;
                        case "mending" -> hasMendingSigil = true;
                        case "poison" -> hasPoisonSigil = true;
                        case "molten" -> hasMoltenSigil = true;
                        case "hardened" -> hasHardenedSigil = true;
                        case "endurance" -> hasEnduranceSigil = true;
                        case "turtle" -> hasTurtleSigil = true;
                        case "concealment" -> hasConcealmentSigil = true;

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

                if (hasSpeedSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.SPEED,
                                    40,
                                    2,
                                    false,
                                    false,
                                    true));
                }

                if (hasVitalitySigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.HEALTH_BOOST,
                                    40,
                                    1,
                                    false,
                                    false,
                                    true));
                }

                if (hasLuckSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.LUCK,
                                    40,
                                    4,
                                    false,
                                    false,
                                    true));
                }

                if (hasHasteSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.HASTE,
                                    40,
                                    2,
                                    false,
                                    false,
                                    true));
                }

                if (hasMendingSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.REGENERATION,
                                    40,
                                    2,
                                    false,
                                    false,
                                    true));
                }

                if (hasPoisonSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.POISON,
                                    40,
                                    2,
                                    false,
                                    false,
                                    true));
                }

                if (hasMoltenSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.FIRE_RESISTANCE,
                                    40,
                                    0,
                                    false,
                                    false,
                                    true));
                }

                if (hasHardenedSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.RESISTANCE,
                                    40,
                                    1,
                                    false,
                                    false,
                                    true));
                }

                if (hasEnduranceSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.SATURATION,
                                    40,
                                    1,
                                    false,
                                    false,
                                    true));
                }

                if (hasTurtleSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.RESISTANCE,
                                    40,
                                    4,
                                    false,
                                    false,
                                    true));
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.SLOWNESS,
                                    40,
                                    3,
                                    false,
                                    false,
                                    true));

                }

                if (hasConcealmentSigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.INVISIBILITY,
                                    40,
                                    0,
                                    false,
                                    false,
                                    true));
                }

                /*
                 * hey
                 * its me
                 * its verity
                 * 
                 * ask me anything
                 * (i got a question)
                 * 
                 * i know
                 * about
                 * a million things
                 * 
                 * i'll do everything
                 * 
                 */
                if (hasVeritySigil) {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.INSTANT_DAMAGE,
                                    100,
                                    255,
                                    false,
                                    false,
                                    true));
                }
            }
        }, 0L, 20L);
    }

}
