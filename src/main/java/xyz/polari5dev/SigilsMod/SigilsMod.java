package xyz.polari5dev.SigilsMod;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import org.bukkit.Bukkit;
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

                registerEasyRecipes();
                registerHardRecipes();
                registerSigils();

        }

        private void registerEasyRecipes() {

                // ez gaps recipe

                NamespacedKey vkey = NamespacedKey.minecraft("golden_apple");

                // remove hard gapple recipe
                Bukkit.getServer().removeRecipe(vkey, true);

                // declare new gapple
                NamespacedKey key = new NamespacedKey(this, "easy_golden_apple");

                // set new gapple to gapple
                ItemStack product = new ItemStack(Material.GOLDEN_APPLE);

                // make recipe, public it
                ShapedRecipe recipe = new ShapedRecipe(key, product);
                recipe.shape(
                                " G ",
                                "GAG",
                                " G ");
                recipe.setIngredient('G', Material.GOLD_INGOT);
                recipe.setIngredient('A', Material.APPLE);

                // accly add the recipe
                Bukkit.getServer().addRecipe(recipe);

                // xp bottles
                key = new NamespacedKey(this, "easy_xp_bottle");
                product = new ItemStack(Material.EXPERIENCE_BOTTLE, 4);
                recipe = new ShapedRecipe(key, product);
                recipe.shape(
                                " s ", // xp source
                                " g ", // make throwable
                                " b ");// bottle
                recipe.setIngredient('s', Material.SCULK);
                recipe.setIngredient('g', Material.GUNPOWDER);
                recipe.setIngredient('b', Material.GLASS_BOTTLE);
                Bukkit.getServer().addRecipe(recipe);

                // webs
                key = new NamespacedKey(this, "easy_cobweb");
                product = new ItemStack(Material.COBWEB);
                recipe = new ShapedRecipe(key, product);
                recipe.shape(
                                "s s",
                                " s ",
                                "s s");
                recipe.setIngredient('s', Material.STRING);
                Bukkit.getServer().addRecipe(recipe);

                // you all know the rest.

                // i don't have to document the rest of this, do i?

                // hope not.

        }

        private void registerHardRecipes() {

                // mace
                NamespacedKey vkey = NamespacedKey.minecraft("mace");
                Bukkit.getServer().removeRecipe(vkey, true);
                NamespacedKey key = new NamespacedKey(this, "hard_mace");
                ItemStack product = new ItemStack(Material.MACE);
                ShapedRecipe recipe = new ShapedRecipe(key, product);
                recipe.shape(
                                "HIH",
                                " B ",
                                " B ");
                recipe.setIngredient('H', Material.HEAVY_CORE);
                recipe.setIngredient('I', Material.IRON_INGOT);
                recipe.setIngredient('B', Material.BREEZE_ROD);

                // accly add the recipe
                Bukkit.getServer().addRecipe(recipe);
        }

        private void sigilsHelper(
                        String key,
                        String recipe,
                        String row1,
                        String row2,
                        String row3,
                        char ing1,
                        Material material1,
                        char ing2,
                        Material material2) {

                NamespacedKey k = new NamespacedKey(this, key);

                ShapedRecipe r = new ShapedRecipe(k, Sigils.create(recipe));

                r.shape(
                                row1,
                                row2,
                                row3);

                r.setIngredient('D', Material.DIAMOND_BLOCK);
                r.setIngredient('E', Material.ENDER_EYE);
                r.setIngredient('N', Material.NETHERITE_INGOT);
                r.setIngredient('S', Material.NETHER_STAR);

                r.setIngredient(ing1, material1);
                if (material2 != null) {
                        r.setIngredient(ing2, material2);
                }
                getServer().addRecipe(r);

        }

        private void registerSigils() {

                // strength
                sigilsHelper("strength_sigil", "strength", "SxS", "N D", "SES", 'x', Material.BLAZE_POWDER, '\0',
                                null);

                // speed
                sigilsHelper("speed_sigil", "speed", "SxS", "N D", "SES", 'x', Material.SUGAR, '\0',
                                null);

                // vitality
                sigilsHelper("vitality_sigil", "vitality", "SxS", "N D", "SES", 'x',
                                Material.ENCHANTED_GOLDEN_APPLE, '\0',
                                null);

                // luck
                sigilsHelper("luck_sigil", "luck", "SxS", "N D", "SES", 'x', Material.EXPERIENCE_BOTTLE, '\0',
                                null);

                // haste
                sigilsHelper("haste_sigil", "haste", "SxS", "N D", "SES", 'x', Material.NETHERITE_PICKAXE, '\0',
                                null);

                // mending !!!!!!!!!!!!!!!!
                sigilsHelper("speed_sigil", "speed", "SxS", "N D", "SES", 'x', Material.AMETHYST_CLUSTER, '\0',
                                null);

                // poison
                sigilsHelper("poison_sigil", "poison", "SxS", "N D", "SES", 'x', Material.SPIDER_EYE, '\0',
                                null);

                // molten
                sigilsHelper("molten_sigil", "molten", "SxS", "N D", "SES", 'x', Material.FIRE_CHARGE, '\0',
                                null);

                // hardened
                sigilsHelper("hardened_sigil", "hardened", "SxS", "N D", "SES", 'x', Material.SHIELD, '\0',
                                null);

                // endurance
                sigilsHelper("endurance_sigil", "endurance", "SxS", "N D", "SES", 'x', Material.GOLDEN_CARROT,
                                '\0',
                                null);

                // turtle
                sigilsHelper("turtle_sigil", "turtle", "SxS", "N D", "SES", 'x', Material.TURTLE_HELMET, '\0',
                                null);

                // concealement
                sigilsHelper("concealment_sigil", "concealment", "SxS", "NyD", "SES", 'x', Material.GOLDEN_CARROT,
                                'y', Material.FERMENTED_SPIDER_EYE);
        }

        @Override
        public void onDisable() {
                getLogger().info(getDescription().getName() + " has been disabled! Goodbye!");
        }
}
