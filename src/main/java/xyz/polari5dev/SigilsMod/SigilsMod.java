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

        private void registerSigils() {

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

                // mending !!!!!!!!!!!!!!!!
                key = new NamespacedKey(this, "mending_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("mending"));

                recipe.shape(
                                "SsS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('s', Material.AMETHYST_SHARD);
                getServer().addRecipe(recipe);

                // poison
                key = new NamespacedKey(this, "poison_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("poison"));

                recipe.shape(
                                "SeS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('e', Material.SPIDER_EYE);
                getServer().addRecipe(recipe);

                // molten
                key = new NamespacedKey(this, "molten_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("molten"));

                recipe.shape(
                                "ScS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('c', Material.FIRE_CHARGE);
                getServer().addRecipe(recipe);

                // hardened
                key = new NamespacedKey(this, "hardened_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("hardened"));

                recipe.shape(
                                "SsS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('s', Material.SHIELD);
                getServer().addRecipe(recipe);

                // endurance
                key = new NamespacedKey(this, "endurance_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("endurance"));

                recipe.shape(
                                "SgS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('g', Material.GOLDEN_CARROT);
                getServer().addRecipe(recipe);

                // turtle
                key = new NamespacedKey(this, "turtle_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("turtle"));

                recipe.shape(
                                "SsS",
                                "N D",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('s', Material.TURTLE_SCUTE);
                getServer().addRecipe(recipe);

                // concealement
                key = new NamespacedKey(this, "concealment_sigil");

                recipe = new ShapedRecipe(key, Sigils.create("concealment"));

                recipe.shape(
                                "ScS",
                                "NeD",
                                "SES");

                recipe.setIngredient('D', Material.DIAMOND_BLOCK);
                recipe.setIngredient('E', Material.ENDER_EYE);
                recipe.setIngredient('N', Material.NETHERITE_INGOT);
                recipe.setIngredient('S', Material.NETHER_STAR);
                recipe.setIngredient('e', Material.FERMENTED_SPIDER_EYE);
                recipe.setIngredient('c', Material.GOLDEN_CARROT);
                getServer().addRecipe(recipe);
        }

        @Override
        public void onDisable() {
                getLogger().info(getDescription().getName() + " has been disabled! Goodbye!");
        }
}
