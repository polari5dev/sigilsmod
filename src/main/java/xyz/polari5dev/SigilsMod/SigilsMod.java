package xyz.polari5dev.SigilsMod;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.polari5dev.SigilsMod.managers.PluginManager;
import xyz.polari5dev.SigilsMod.sigils.Sigils;
import xyz.polari5dev.SigilsMod.commands.SigilCommand;
import xyz.polari5dev.SigilsMod.listeners.PlayerListener;

public class SigilsMod extends JavaPlugin {

        @Override
        public void onEnable() {

                // Initialize managers
                PluginManager.getInstance().initialize();

                // Register listeners
                getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

                getLogger().info(getDescription().getName() + " has been enabled! Hello, User!");

                this.registerCommand("sigil", new SigilCommand());
                registerRecipes();
        }

        private void registerRecipes() {

                // strength
                NamespacedKey key = new NamespacedKey(this, "strength_sigil");

                ShapedRecipe recipe = new ShapedRecipe(key, Sigils.create("strength"));

                recipe.shape(
                                "SbS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('b', Material.BLAZE_POWDER);
                getServer().addRecipe(recipe);

                // speed
                key = new NamespacedKey(this, "speed_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("speed"));

                recipe.shape(
                                "SsS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('s', Material.SUGAR);
                getServer().addRecipe(recipe);

                // vitality
                key = new NamespacedKey(this, "vitality_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("vitality"));

                recipe.shape(
                                "SgS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('g', Material.ENCHANTED_GOLDEN_APPLE);
                getServer().addRecipe(recipe);

                // luck
                key = new NamespacedKey(this, "luck_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("luck"));

                recipe.shape(
                                "SbS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('b', Material.EXPERIENCE_BOTTLE);
                getServer().addRecipe(recipe);

                // haste
                key = new NamespacedKey(this, "haste_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("haste"));

                recipe.shape(
                                "SpS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('p', Material.NETHERITE_PICKAXE);
                getServer().addRecipe(recipe);
        }

        @Override
        public void onDisable() {
                getLogger().info(getDescription().getName() + " has been disabled! Goodbye!");
        }

}
